package co.edu.escuelaing.primisketch.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.escuelaing.primisketch.entities.Users;
import co.edu.escuelaing.primisketch.repositories.UsersRepository;

@Service
public class UsersService {
    
    @Autowired
    private UsersRepository usersRepository;

    public Users create(Users c){
        return usersRepository.save(c);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public void delete(Users c) {
        usersRepository.delete(c);
    }

    public Optional<Users> getUserById(Long id) {
        return usersRepository.findById(id);
    }

    public Optional<Users> getUserByUsername(String name) {
        return usersRepository.getUserByUsername(name);
    }

}
