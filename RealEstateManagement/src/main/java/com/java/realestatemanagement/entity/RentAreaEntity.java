package com.java.realestatemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "rentarea")
public class RentAreaEntity extends BaseEntity {
    private Integer value;
    @ManyToOne
    @JoinColumn(name = "building_id")
    private BuildingEntity building;

}
