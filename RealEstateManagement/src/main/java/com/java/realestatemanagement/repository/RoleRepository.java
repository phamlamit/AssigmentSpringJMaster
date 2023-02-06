package com.java.realestatemanagement.repository;

import com.java.realestatemanagement.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
