package co.edu.escuelaing.primisketch.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.escuelaing.primisketch.entities.Schedules;

/**
 * Repositorio de la entidad Schedules
 */
@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Long> {
    
    /**
     * Consulta que obtiene todos el horario asociado a un nombre
     * @param name Nombre del horario
     * @return horario asociado a un nombre
     */
    @Query("SELECT c FROM Schedules c WHERE nombre=:name")
    Optional<Schedules> getScheduleByName(@Param("name") String name);
    
}
