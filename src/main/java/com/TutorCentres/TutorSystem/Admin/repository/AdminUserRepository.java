package com.TutorCentres.TutorSystem.Admin.repository;

import com.TutorCentres.TutorSystem.core.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Integer> {
}
