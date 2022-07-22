package co.edu.escuelaing.primisketch.rest;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.escuelaing.primisketch.entities.Users;
import co.edu.escuelaing.primisketch.services.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersRest {
    
    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    private ResponseEntity<Optional<Users>> loginValidation(@PathParam("name") String name, @PathParam("password") String password) {
        Optional<Users> user = usersService.loginValidation(name, password);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getUserById")
    private ResponseEntity<Optional<Users>> getUserById(@PathParam("id") Long id) {
        Optional<Users> user = usersService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    
}
