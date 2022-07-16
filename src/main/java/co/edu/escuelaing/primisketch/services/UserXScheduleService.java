package co.edu.escuelaing.primisketch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.escuelaing.primisketch.entities.UserXSchedule;
import co.edu.escuelaing.primisketch.repositories.UserXScheduleRepository;

@Service
public class UserXScheduleService {
    
    @Autowired
    private UserXScheduleRepository userXScheduleRepository;

    public UserXSchedule create(UserXSchedule userXSchedule) {
        return userXScheduleRepository.save(userXSchedule);
    }

    public List<UserXSchedule> getAllUsersXSchedules() {
        return userXScheduleRepository.findAll();
    }

    public void delete(UserXSchedule userXSchedule) {
        userXScheduleRepository.delete(userXSchedule);
    }

    public List<UserXSchedule> getGroupByUserId(Long id) {
        return userXScheduleRepository.getGroupByUserId(id);
    }

    public List<UserXSchedule> getGroupByScheduleId(Long id) {
        return userXScheduleRepository.getGroupByScheduleId(id);
    }
    
}
