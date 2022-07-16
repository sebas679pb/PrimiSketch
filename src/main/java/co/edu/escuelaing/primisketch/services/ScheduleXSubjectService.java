package co.edu.escuelaing.primisketch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.escuelaing.primisketch.entities.ScheduleXSubject;
import co.edu.escuelaing.primisketch.repositories.ScheduleXSubjectRepository;

@Service
public class ScheduleXSubjectService {

    @Autowired
    private ScheduleXSubjectRepository scheduleXSubjectRepository;

    public ScheduleXSubject create(ScheduleXSubject scheduleXSubject) {
        return scheduleXSubjectRepository.save(scheduleXSubject);
    }

    public List<ScheduleXSubject> getAllSchedulesXSubjects() {
        return scheduleXSubjectRepository.findAll();
    }

    public void delete(ScheduleXSubject scheduleXSubject) {
        scheduleXSubjectRepository.delete(scheduleXSubject);
    }

    public List<ScheduleXSubject> getWithScheduleId(Long id) {
        return scheduleXSubjectRepository.getWithScheduleId(id);
    }

    public List<ScheduleXSubject> getWithSubjectId(Long id) {
        return scheduleXSubjectRepository.getWithSubjectId(id);
    }
    
}
