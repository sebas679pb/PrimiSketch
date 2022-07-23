package co.edu.escuelaing.primisketch.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.escuelaing.primisketch.entities.Subjects;

/**
 * Repositorio de la entidad Subjects
 */
@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Long> {
    
    /**
     * Consulta que obtiene todas las materias con un memotecnico
     * @param memo Memotecnico de la materia
     * @return Lista de materias con un memotecnico
     */
    @Query("SELECT c FROM Subjects c WHERE memo_sub=:memo")
    List<Subjects> getSubjectsByMemo(@Param("memo") String memo);
    
    /**
     * Consulta que obtiene todas las materias con un nombre
     * @param name Nombre de la materia
     * @return Lista de materias con un nombre
     */
    @Query("SELECT c FROM Subjects c WHERE name_sub=:name")
    List<Subjects> getSubjectsByName(@Param("name") String name);

    /**
     * Consulta que obtiene todas las materias de un profesor
     * @param name Nombre del profesor
     * @return Lista de materias con el profesor
     */
    @Query("SELECT c FROM Subjects c WHERE professor=:name")
    List<Subjects> getSubjectsByProfessor(@Param("name") String name);

    /**
     * Consulta que obtiene una asignatura con un memotecnico y grupo
     * @param memo Memotecnico de la asignatura
     * @param group Grupo de la asignatura
     * @return Asignatura con un memotecnico y grupo
     */
    @Query("SELECT c FROM Subjects c WHERE memo_sub=:memo AND group_sub=:group")
    Optional<Subjects> getSubjetByMemoGroup(@Param("memo") String memo, @Param("group") Long group);

}
