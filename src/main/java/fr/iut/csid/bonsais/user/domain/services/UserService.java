package fr.iut.csid.bonsais.user.domain.services;

import fr.iut.csid.bonsais.common.AuthorityDao;
import fr.iut.csid.bonsais.common.AuthorityEntity;
import fr.iut.csid.bonsais.common.UserDao;
import fr.iut.csid.bonsais.common.UserEntity;
import fr.iut.csid.bonsais.user.Mapper;
import fr.iut.csid.bonsais.user.domain.models.AppUser;
import fr.iut.csid.bonsais.user.domain.models.UserModel;
import fr.iut.csid.bonsais.user.exposition.UserDTO;
import fr.iut.csid.bonsais.user.infrastructure.AuthorityId;
import fr.iut.csid.bonsais.user.infrastructure.PasswordChanges;
import fr.iut.csid.bonsais.user.infrastructure.UserCreationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityDao authorityDao;

    public UserService(UserDao userDao, PasswordEncoder passwordEncoder, AuthorityDao authorityDao) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.authorityDao = authorityDao;
    }

    @Transactional
    public void create(UserCreationRequest userCreationRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userCreationRequest.username());
        userEntity.setPassword(passwordEncoder.encode(userCreationRequest.password()));
        UserEntity savedUser = userDao.save(userEntity);

        List<AuthorityEntity> authorities = new ArrayList<>();
        authorities.add(new AuthorityEntity(AuthorityId.getDefaultAuthority(savedUser.getId())));
        savedUser.setAuthorities(authorities);

        userDao.save(savedUser);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = userDao.findByUsername(s);
        List<String> authoritiesList = userDao.findAuthorityByUserId(user.getId());
        String authorities = String.join(",", authoritiesList);
        return new AppUser(user.getId(), user.getUsername(), user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
    }

    public void updatePassword(String username, PasswordChanges passwords) throws InvalidPasswordException {
        UserEntity user = userDao.findByUsername(username);
        if (!passwordEncoder.matches(passwords.getOldPassword(), user.getPassword())) throw new InvalidPasswordException();
        user.setPassword(passwordEncoder.encode(passwords.getNewPassword()));
        userDao.save(user);
    }

    public void updateAuthority(UUID id, String role) {
        authorityDao.deleteAuthByUserId(id);
        authorityDao.save(new AuthorityEntity(new AuthorityId(id,role)));
    }

    public List<UserModel> findAllUsers() {
        return userDao.findAll().stream().map(Mapper::mapFromEntity).collect(Collectors.toList());
    }

    public Optional<UserModel> getMe() {
        AppUser credentials = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDao.findById(credentials.getId()).map(Mapper::mapFromEntity);
    }
}