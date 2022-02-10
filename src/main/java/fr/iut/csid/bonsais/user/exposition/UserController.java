package fr.iut.csid.bonsais.user.exposition;


import fr.iut.csid.bonsais.user.Mapper;
import fr.iut.csid.bonsais.user.domain.models.AppUser;
import fr.iut.csid.bonsais.user.domain.services.InvalidPasswordException;
import fr.iut.csid.bonsais.user.domain.services.UserService;
import fr.iut.csid.bonsais.user.infrastructure.PasswordChanges;
import fr.iut.csid.bonsais.user.infrastructure.UserCreationRequest;
import fr.iut.csid.bonsais.user.infrastructure.UserCredentials;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody UserCredentials userCredentials){
        userService.create(new UserCreationRequest(userCredentials));
    }

    @PutMapping("/me/password")
    public ResponseEntity<Void> changePassword(@RequestBody PasswordChanges passwordChanges){
        try{
            AppUser credentials = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(!passwordChanges.getNewPassword().equals(passwordChanges.getConfirmationNew())){
                return ResponseEntity.badRequest().build();
            }
            else{
                userService.updatePassword(credentials.getUsername(), passwordChanges);
                return ResponseEntity.ok().build();
            }
        }catch (InvalidPasswordException e){
            return ResponseEntity.status(403).build();
        }

    }

    @PutMapping("/{id}/authority")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> changeAuthority(@PathVariable("id") UUID id, @RequestBody String role){
        try{
            userService.updateAuthority(id, role);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(403).build();
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('STAFF')")
    public List<UserDTO> getUsers(){
        return userService.findAllUsers().stream().map(Mapper::mapFromModel).collect(Collectors.toList());
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getMe(){
        return userService.getMe().map(Mapper::mapFromModel).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
