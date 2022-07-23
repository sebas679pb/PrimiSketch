package co.edu.escuelaing.primisketch.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.escuelaing.primisketch.entities.ScheduleXSubject;

@Repository
public interface ScheduleXSubjectRepository extends JpaRepository<ScheduleXSubject, Long>{
    
    @Query("SELECT c FROM ScheduleXSubject c WHERE id_schedule=:id")
    List<ScheduleXSubject> getWithScheduleId(@Param("id") Long id);

    @Query("SELECT c FROM ScheduleXSubject c WHERE id_subject=:id")
    List<ScheduleXSubject> getWithSubjectId(@Param("id") Long id);

    @Query("SELECT c FROM ScheduleXSubject c WHERE id_schedule=:idSchedule AND id_subject=:idSubject")
    Optional<ScheduleXSubject> getByScheduleXSubject(@Param("idSchedule") Long idSchedule, @Param("idSubject") Long idSubject);

}
