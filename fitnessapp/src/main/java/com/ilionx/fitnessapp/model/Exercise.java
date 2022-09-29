package com.ilionx.fitnessapp.model;

import javax.persistence.*;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private double repetitions;
    private String targetMuscle;
    private boolean isolated;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(double repetitions) {
        this.repetitions = repetitions;
    }

    public String getTargetMuscle() {
        return targetMuscle;
    }
    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    public boolean isIsolated() {
        return isolated;
    }

    public void setIsolated(boolean isolated) {
        this.isolated = isolated;
    }
}
