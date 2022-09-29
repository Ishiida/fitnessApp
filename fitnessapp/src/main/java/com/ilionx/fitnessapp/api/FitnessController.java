package com.ilionx.fitnessapp.api;


import com.ilionx.fitnessapp.model.Exercise;
import com.ilionx.fitnessapp.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/exercises")
public class FitnessController {

    @Autowired
    private ExerciseService exerciseService;

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String errorHandler() {
        return "What happend?";
    }

    // All exercises
    @GetMapping
    public List<Exercise> exercises() {
        return this.exerciseService.findAll();
    }

    // Get 1 specific
    @GetMapping("{id}")
    public ResponseEntity<Exercise> findById(@PathVariable long id) {

        Optional<Exercise> optionalExercise = this.exerciseService.findById(id);
        if (optionalExercise.isPresent()) {
            return ResponseEntity.ok(optionalExercise.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Exercise> updateById(@PathVariable long id, @RequestBody Exercise input) {

        Optional<Exercise> optionalExercise = this.exerciseService.updateById(id, input);

        if (optionalExercise.isPresent()) {
            return ResponseEntity.ok(optionalExercise.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Exercise create(@RequestBody Exercise exercise){

        return this.exerciseService.save(exercise);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Exercise> deleteById(@PathVariable Long id) {

        Optional<Exercise> optionalExercise = this.exerciseService.findById(id);

        if (optionalExercise.isPresent()){
            this.exerciseService.deleteById(id);
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

