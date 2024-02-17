package com.TutorCentres.TutorSystem.Student.repository;

import com.TutorCentres.TutorSystem.core.entity.StudentCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCaseRepository extends JpaRepository<StudentCase, Integer> {
}
