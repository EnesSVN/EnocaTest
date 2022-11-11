package com.example.enocatest.service;

import com.example.enocatest.entity.Tutorial;
import com.example.enocatest.repository.TutorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {

    private TutorialRepository tutorialRepository;

    public TutorialService(TutorialRepository tutorialRepository){
        this.tutorialRepository = tutorialRepository;
    }

    public Optional<Tutorial> getTutorialById(Long id){
        return tutorialRepository.findById(id);
    }

    public List<Tutorial> getAllTutorials(){
        return tutorialRepository.findAll();
    }

    public Tutorial createTutorial(Tutorial tutorial){
        return tutorialRepository.save(tutorial);
    }

    public Tutorial updateTutorial(Tutorial tutorial){
        return tutorialRepository.save(tutorial);
    }

    public void deleteTutorial(Long id){
        tutorialRepository.deleteById(id);
    }


}
