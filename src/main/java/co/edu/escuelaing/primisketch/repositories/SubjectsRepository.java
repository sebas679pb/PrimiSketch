package co.edu.escuelaing.primisketch.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.escuelaing.primisketch.entities.Subjects;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Long> {
    
    @Query("SELECT c FROM Subjects c WHERE memo_sub=:memo")
    List<Subjects> getSubjectsByMemo(@Param("memo") String memo);
    
    @Query("SELECT c FROM Subjects c WHERE name_sub=:name")
    List<Subjects> getSubjectsByName(@Param("name") String name);

    @Query("SELECT c FROM Subjects c WHERE professor=:name")
    List<Subjects> getSubjectsByProfessor(@Param("name") String name);

    @Query("SELECT c FROM Subjects c WHERE memo_sub=:memo AND group_sub=:group")
    Optional<Subjects> getSubjetByMemoGroup(@Param("memo") String memo, @Param("group") Long group);

}
