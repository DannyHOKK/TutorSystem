package com.TutorCentres.TutorSystem.core.dto;

import java.util.List;

public class TutorSearchDTO {
    private List<String> tutorContent;
    private List<String> tutorAreas;
    private List<String> tutorLevel;
    private Integer lowestSalary;
    private Integer maxSalary;



    public TutorSearchDTO(List<String> tutorContent, List<String> tutorAreas, List<String> tutorLevel, Integer lowestSalary, Integer maxSalary) {
        this.tutorContent = tutorContent;
        this.tutorAreas = tutorAreas;
        this.tutorLevel = tutorLevel;
        this.lowestSalary = lowestSalary;
        this.maxSalary = maxSalary;
    }

    public List<String> getTutorContent() {
        return tutorContent;
    }

    public void setTutorContent(List<String> tutorContent) {
        this.tutorContent = tutorContent;
    }

    public List<String> getTutorAreas() {
        return tutorAreas;
    }

    public void setTutorAreas(List<String> tutorAreas) {
        this.tutorAreas = tutorAreas;
    }

    public List<String> getTutorLevel() {
        return tutorLevel;
    }

    public void setTutorLevel(List<String> tutorLevel) {
        this.tutorLevel = tutorLevel;
    }

    public Integer getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(Integer lowestSalary) {
        this.lowestSalary = lowestSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }
}
