package com.TutorCentres.TutorSystem.Student.repository;

import com.TutorCentres.TutorSystem.core.entity.StudentMapTutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapTutorRepository extends JpaRepository<StudentMapTutor, Integer> {
}
