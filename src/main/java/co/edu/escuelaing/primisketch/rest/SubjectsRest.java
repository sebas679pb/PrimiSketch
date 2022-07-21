package co.edu.escuelaing.primisketch.rest;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.escuelaing.primisketch.entities.DatesSubject;
import co.edu.escuelaing.primisketch.entities.Subjects;
import co.edu.escuelaing.primisketch.services.DatesSubjectService;
import co.edu.escuelaing.primisketch.services.SubjectsService;

@RestController
@RequestMapping("/api/subjects")
public class SubjectsRest {

    @Autowired
    private SubjectsService subjectsService;

    @Autowired
    private DatesSubjectService datesSubjectService;

    @PostMapping("/getSubjectsByMemoGroup")
    private ResponseEntity<Optional<Subjects>> getSubjectsByMemoGroup(@PathParam("memo") String memo, @PathParam("group") Long group) {
        Optional<Subjects> subject = subjectsService.getSubjectByMemoGroup(memo, group);
        return ResponseEntity.ok(subject);
    }

    @GetMapping("/getAllSubjects")
    private ResponseEntity<List<Subjects>> getAllSubjects() {
        List<Subjects> subjects = subjectsService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/getSubjectsByMemo")
    private ResponseEntity<List<Subjects>> getSubjectsByMemo(@PathParam("memo") String memo) {
        List<Subjects> subjects = subjectsService.getSubjectsByMemo(memo);
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/getDatesSubject")
    private ResponseEntity<List<DatesSubject>> getDatesSubject(@PathParam("id") Long id) {
        List<DatesSubject> datesSubject = datesSubjectService.getDatesSubject(id);
        return ResponseEntity.ok(datesSubject);
    }

}
