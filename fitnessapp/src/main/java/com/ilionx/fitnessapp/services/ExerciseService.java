package com.ilionx.fitnessapp.services;


import com.ilionx.fitnessapp.model.Exercise;
import com.ilionx.fitnessapp.persistance.ExerciseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepo exerciseRepo;

    @Transactional
    public Exercise save(Exercise exercise) {
        Exercise savedExercise = this.exerciseRepo.save(exercise);

        if ("rollback".equals(savedExercise.getName())) {
            System.out.println(3/0);
        }

        return savedExercise;
    }

    public List<Exercise> findAll() {
        return exerciseRepo.findAll();
    }

    public Optional<Exercise> findById(Long aLong) {
        return exerciseRepo.findById(aLong);
    }

    public long count() {
        return exerciseRepo.count();
    }

    public void deleteById(Long aLong) {
        exerciseRepo.deleteById(aLong);

    }

    public Optional<Exercise> updateById(long id, Exercise input) {
        Optional<Exercise> optionalExercise = this.exerciseRepo.findById(id);

        if (optionalExercise.isPresent()) {
            Exercise target = optionalExercise.get();
            target.setRepetitions(input.getRepetitions());
            target.setTargetMuscle(input.getTargetMuscle());
            target.setIsolated(input.isIsolated());

            this.exerciseRepo.save(target);
        }
        return optionalExercise;
    }
}


