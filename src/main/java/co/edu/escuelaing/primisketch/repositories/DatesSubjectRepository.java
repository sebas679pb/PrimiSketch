package co.edu.escuelaing.primisketch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.escuelaing.primisketch.entities.DatesSubject;

@Repository
public interface DatesSubjectRepository extends JpaRepository<DatesSubject, Long> {
    
    @Query("SELECT c FROM DatesSubject c WHERE idSubject=:id")
    List<DatesSubject> getDatesSubject(@Param("id") Long id);
    
}
