package co.edu.escuelaing.primisketch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.escuelaing.primisketch.entities.UserXSchedule;

@Repository
public interface UserXScheduleRepository extends JpaRepository<UserXSchedule, Long>{
    
    @Query("SELECT c FROM UserXSchedule c WHERE idUser=:id")
    List<UserXSchedule> getGroupByUserId(@Param("id") Long id);

    @Query("SELECT c FROM UserXSchedule c WHERE idSchedule=:id")
    List<UserXSchedule> getGroupByScheduleId(@Param("id") Long id);

}
