package co.edu.escuelaing.primisketch.rest;

import java.util.List;
import java.util.Optional;

import javax.security.auth.Subject;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.escuelaing.primisketch.entities.ScheduleXSubject;
import co.edu.escuelaing.primisketch.entities.Schedules;
import co.edu.escuelaing.primisketch.entities.Subjects;
import co.edu.escuelaing.primisketch.entities.UserXSchedule;
import co.edu.escuelaing.primisketch.entities.Users;
import co.edu.escuelaing.primisketch.services.ScheduleXSubjectService;
import co.edu.escuelaing.primisketch.services.SchedulesService;
import co.edu.escuelaing.primisketch.services.SubjectsService;
import co.edu.escuelaing.primisketch.services.UserXScheduleService;
import co.edu.escuelaing.primisketch.services.UsersService;

@RestController
@RequestMapping("/api/schedules")
public class SchedulesRest {
    
    @Autowired
    private SchedulesService schedulesService;

    @Autowired
    private UserXScheduleService userXScheduleService;

    @Autowired
    private ScheduleXSubjectService scheduleXSubjectService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private SubjectsService subjectsService;
    
    @GetMapping("/getGroupByUserId")
    private ResponseEntity<List<UserXSchedule>> getGroupByUserId(@PathParam("id") Long id) {
        return ResponseEntity.ok(userXScheduleService.getGroupByUserId(id));
    }

    @GetMapping("/getSubjectsByScheduleId")
    private ResponseEntity<List<ScheduleXSubject>> getSubjectsByScheduleId(@PathParam("id") Long id) {
        return ResponseEntity.ok(scheduleXSubjectService.getWithScheduleId(id));
    }

    @PostMapping("/newSchedule")
    private ResponseEntity<Schedules> newSchedule(@PathParam("name") String name) {
        Schedules schedule = new Schedules(name);
        try{
            return ResponseEntity.ok(schedulesService.create(schedule));
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/newUserXSchedule")
    private ResponseEntity<UserXSchedule> newUserXSchedule(@PathParam("userId") Long userId, @PathParam("scheduleId") Long scheduleId) {
        Optional<Users> user = usersService.getUserById(userId);
        Optional<Schedules> schedule = schedulesService.getScheduleById(scheduleId);
        UserXSchedule userXSchedule = new UserXSchedule(user.get(), schedule.get());
        return ResponseEntity.ok(userXScheduleService.create(userXSchedule));
    }

    @PostMapping("/newScheduleXSubject")
    private ResponseEntity<ScheduleXSubject> newScheduleXSubject(@PathParam("scheduleId") Long scheduleId, @PathParam("subjectId") Long subjectId) {
        Optional<Schedules> schedule = schedulesService.getScheduleById(scheduleId);
        Optional<Subjects> subject = subjectsService.getSubjectById(subjectId);
        ScheduleXSubject scheduleXSubject = new ScheduleXSubject(schedule.get(), subject.get());
        return ResponseEntity.ok(scheduleXSubjectService.create(scheduleXSubject));
    }

    @DeleteMapping("/deleteScheduleXSubject")
    private void deleteScheduleXSubject(@PathParam("scheduleId") Long scheduleId, @PathParam("subjectId") Long subjectId) {
        Optional<ScheduleXSubject> scheduleXSubject = scheduleXSubjectService.getByScheduleXSubject(scheduleId, subjectId);
        scheduleXSubjectService.delete(scheduleXSubject.get());
    }

}
