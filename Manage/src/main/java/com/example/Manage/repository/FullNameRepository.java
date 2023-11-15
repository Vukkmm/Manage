package com.example.Manage.repository;

import com.example.Manage.entity.FullName;
import com.example.Manage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullNameRepository extends JpaRepository<FullName, Long> {
}
