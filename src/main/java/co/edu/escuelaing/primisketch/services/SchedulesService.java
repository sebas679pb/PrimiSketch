package co.edu.escuelaing.primisketch.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.escuelaing.primisketch.entities.Schedules;
import co.edu.escuelaing.primisketch.repositories.SchedulesRepository;

@Service
public class SchedulesService {
    
    @Autowired
    private SchedulesRepository schedulesRepository;

    public Schedules create(Schedules schedule) {
        return schedulesRepository.save(schedule);
    }

    public List<Schedules> getAllSchedules() {
        return schedulesRepository.findAll();
    }

    public void delete(Schedules schedule) {
        schedulesRepository.delete(schedule);
    }

    public Optional<Schedules> getScheduleById(Long id) {
        return schedulesRepository.findById(id);
    }

    public Optional<Schedules> getScheduleByName(String name) {
        return schedulesRepository.getScheduleByName(name);
    }
}
