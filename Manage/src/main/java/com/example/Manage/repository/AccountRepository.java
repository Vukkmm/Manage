package com.example.Manage.repository;

import com.example.Manage.entity.Account;
import com.example.Manage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
