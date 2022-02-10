package fr.iut.csid.bonsais.user.exposition;

import fr.iut.csid.bonsais.user.infrastructure.UserCredentials;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AuthenticationController {

    private AuthenticationManager authenticationManager;

    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> authenticate(@RequestBody UserCredentials userCredentials){
        try{
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword(), new ArrayList<>()));
            SecurityContextHolder.getContext().setAuthentication(auth);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.status(403).build();
        }
    }
}
