package co.edu.escuelaing.primisketch.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.escuelaing.primisketch.entities.UserXSchedule;

/**
 * Repositorio de la entidad UserXSchedule
 */
@Repository
public interface UserXScheduleRepository extends JpaRepository<UserXSchedule, Long>{
    
    /**
     * Consulta que obtiene todos los horarios asociados a un id de usuario
     * @param id Identificador del usuario
     * @return horarios asociados a un id de usuario
     */
    @Query("SELECT c FROM UserXSchedule c WHERE id_user=:id")
    List<UserXSchedule> getGroupByUserId(@Param("id") Long id);

    /**
     * Consulta que obtiene todos los horarios asociados a un id de horario
     * @param id Identificador del horario
     * @return horarios asociados a un id de horario
     */
    @Query("SELECT c FROM UserXSchedule c WHERE id_schedule=:id")
    List<UserXSchedule> getGroupByScheduleId(@Param("id") Long id);

    /**
     * Consulta que obtiene todos los horarios asociados a un id de usuario y un id de horario
     * @param idUser Identificador del usuario
     * @param idSchedule Identificador del horario
     * @return horarios asociados a un id de usuario y un id de horario
     */
    @Query("SELECT c FROM UserXSchedule c WHERE id_user=:idUser AND id_schedule=:idSchedule")
    Optional<UserXSchedule> getByUserXSchedule(@Param("idUser") Long idUser, @Param("idSchedule") Long idSchedule);

}
