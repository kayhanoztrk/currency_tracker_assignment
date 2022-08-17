package com.currencytracker.assignment.currencytracker.repository;

import com.currencytracker.assignment.currencytracker.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
