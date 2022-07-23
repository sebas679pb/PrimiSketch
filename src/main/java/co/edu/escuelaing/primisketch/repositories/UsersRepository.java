package co.edu.escuelaing.primisketch.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.escuelaing.primisketch.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    
    @Query("SELECT c FROM Users c WHERE username=:name AND passwrd=:password")
    Optional<Users> loginValidation(@Param("name") String name, @Param("password") String password);

    @Query("SELECT c FROM Users c WHERE username=:name")
    Optional<Users> getUserByUsername(@Param("name") String name);
    
}
