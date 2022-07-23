package co.edu.escuelaing.primisketch.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.escuelaing.primisketch.entities.Users;

/**
 * Repositorio de la entidad Users
 */
@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    
    /**
     * Consulta que obtiene un usuario con su nombre de usuario y contraseña
     * @param name Nombre de usuario
     * @param password Contraseña
     * @return usuario con su nombre de usuario y contraseña
     */
    @Query("SELECT c FROM Users c WHERE username=:name AND passwrd=:password")
    Optional<Users> loginValidation(@Param("name") String name, @Param("password") String password);

    /**
     * Consulta que obtiene un usuario con su nombre de usuario
     * @param name Nombre de usuario
     * @return usuario con su nombre de usuario
     */
    @Query("SELECT c FROM Users c WHERE username=:name")
    Optional<Users> getUserByUsername(@Param("name") String name);
    
}
