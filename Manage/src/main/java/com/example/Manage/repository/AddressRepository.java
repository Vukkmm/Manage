package com.example.Manage.repository;

import com.example.Manage.entity.Address;
import com.example.Manage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
