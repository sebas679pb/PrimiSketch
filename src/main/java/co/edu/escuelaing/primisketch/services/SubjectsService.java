package co.edu.escuelaing.primisketch.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.escuelaing.primisketch.entities.Subjects;
import co.edu.escuelaing.primisketch.repositories.SubjectsRepository;

@Service
public class SubjectsService {
    
    @Autowired
    private SubjectsRepository subjectsRepository;

    public Subjects create(Subjects subject) {
        return subjectsRepository.save(subject);
    }

    public List<Subjects> getAllSubjects() {
        return subjectsRepository.findAll();
    }

    public void delete(Subjects subject) {
        subjectsRepository.delete(subject);
    }

    public Optional<Subjects> getSubjectById(Long id) {
        return subjectsRepository.findById(id);
    }

    public List<Subjects> getSubjectsByMemo(String memo) {
        return subjectsRepository.getSubjectsByMemo(memo);
    }

    public List<Subjects> getSubjectsByName(String name) {
        return subjectsRepository.getSubjectsByName(name);
    }

    public List<Subjects> getSubjectsByProfessor(String name) {
        return subjectsRepository.getSubjectsByProfessor(name);
    }

}
