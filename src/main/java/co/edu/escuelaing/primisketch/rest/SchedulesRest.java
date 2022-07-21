package co.edu.escuelaing.primisketch.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.escuelaing.primisketch.entities.UserXSchedule;
import co.edu.escuelaing.primisketch.services.SchedulesService;
import co.edu.escuelaing.primisketch.services.UserXScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class SchedulesRest {
    
    @Autowired
    private SchedulesService schedulesService;

    @Autowired
    private UserXScheduleService userXScheduleService;
    
    @GetMapping("/getGroupByUserId")
    private ResponseEntity<List<UserXSchedule>> getGroupByUserId(@PathParam("id") Long id) {
        return ResponseEntity.ok(userXScheduleService.getGroupByUserId(id));
    }

}
