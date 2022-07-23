package co.edu.escuelaing.primisketch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.escuelaing.primisketch.entities.DatesSubject;

/**
 * Repositorio de la entidad DatesSubject
 */
@Repository
public interface DatesSubjectRepository extends JpaRepository<DatesSubject, Long> {
    
    /**
     * Consulta que obtiene todos los horarios de una asignatura
     * @param id Identificador de la asignatura
     * @return Lista de horarios de la asignatura
     */
    @Query("SELECT c FROM DatesSubject c WHERE id_subject=:id")
    List<DatesSubject> getDatesSubject(@Param("id") Long id);
    
}
