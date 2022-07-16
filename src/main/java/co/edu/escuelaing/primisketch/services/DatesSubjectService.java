package co.edu.escuelaing.primisketch.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.escuelaing.primisketch.entities.DatesSubject;
import co.edu.escuelaing.primisketch.repositories.DatesSubjectRepository;

@Service
public class DatesSubjectService {
    
    @Autowired
    private DatesSubjectRepository datesSubjectRepository;

    public DatesSubject create(DatesSubject datesSubject) {
        return datesSubjectRepository.save(datesSubject);
    }

    public List<DatesSubject> getAllDatesSubjects() {
        return datesSubjectRepository.findAll();
    }

    public void delete(DatesSubject datesSubject) {
        datesSubjectRepository.delete(datesSubject);
    }

    public Optional<DatesSubject> getDatesSubjectById(Long id) {
        return datesSubjectRepository.findById(id);
    }

    public List<DatesSubject> getDatesSubject(Long id) {
        return datesSubjectRepository.getDatesSubject(id);
    }
}
