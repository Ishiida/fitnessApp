package com.ilionx.fitnessapp.persistance;

import com.ilionx.fitnessapp.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepo extends JpaRepository <Exercise, Long> { }
