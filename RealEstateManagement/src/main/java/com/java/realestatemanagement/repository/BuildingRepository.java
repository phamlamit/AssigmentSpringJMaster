package com.java.realestatemanagement.repository;

import com.java.realestatemanagement.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<BuildingEntity,Long> {
}
