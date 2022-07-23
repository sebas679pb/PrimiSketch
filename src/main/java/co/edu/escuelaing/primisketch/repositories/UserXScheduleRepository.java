package co.edu.escuelaing.primisketch.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.escuelaing.primisketch.entities.UserXSchedule;

@Repository
public interface UserXScheduleRepository extends JpaRepository<UserXSchedule, Long>{
    
    @Query("SELECT c FROM UserXSchedule c WHERE id_user=:id")
    List<UserXSchedule> getGroupByUserId(@Param("id") Long id);

    @Query("SELECT c FROM UserXSchedule c WHERE id_schedule=:id")
    List<UserXSchedule> getGroupByScheduleId(@Param("id") Long id);

    @Query("SELECT c FROM UserXSchedule c WHERE id_user=:idUser AND id_schedule=:idSchedule")
    Optional<UserXSchedule> getByUserXSchedule(@Param("idUser") Long idUser, @Param("idSchedule") Long idSchedule);

}
