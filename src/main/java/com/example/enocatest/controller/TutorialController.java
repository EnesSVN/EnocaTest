package com.example.enocatest.controller;

import com.example.enocatest.entity.Tutorial;
import com.example.enocatest.exception.ResourceNotFoundException;
import com.example.enocatest.service.TutorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TutorialController {

    private TutorialService tutorialService;

    public  TutorialController(TutorialService tutorialService){
        this.tutorialService = tutorialService;
    }

    @GetMapping("/tutorial")
    public List<Tutorial> getAllTutorial(){
        List<Tutorial> tutorials = new ArrayList<>();
        tutorialService.getAllTutorials().forEach(tutorials::add);
        return tutorials;
    }

    @GetMapping("/tutorial/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable(name = "id") Long id){
        Tutorial tutorial = tutorialService.getTutorialById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }

    @PostMapping("/create/tutorial")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
         Tutorial tutorial1 = tutorialService.createTutorial(tutorial);
         return new ResponseEntity<>(tutorial1, HttpStatus.CREATED);
    }

    @PutMapping("/update/tutorial/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") Long id, @RequestBody Tutorial tutorial) {
        Tutorial tutorial1 = tutorialService.getTutorialById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

        tutorial1.setTitle(tutorial.getTitle());
        tutorial1.setDescription(tutorial.getDescription());
        tutorial1.setPublished(tutorial.isPublished());

        return new ResponseEntity<>(tutorialService.updateTutorial(tutorial1), HttpStatus.OK);
    }

    @DeleteMapping("/delete/tutorial/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteTutorial(@PathVariable("id") Long id) {
        tutorialService.deleteTutorial(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }





}
