package co.edu.escuelaing.primisketch.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.escuelaing.primisketch.entities.UserXSchedule;
import co.edu.escuelaing.primisketch.repositories.UserXScheduleRepository;

/**
 * Clase que contiene los servicios para realizar las operaciones CRUD sobre la asociacion entre usuarios y horarios
 */
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

    public Optional<UserXSchedule> getByUserXSchedule(Long idUser, Long idSchedule) {
        return userXScheduleRepository.getByUserXSchedule(idUser, idSchedule);
    }
    
}
