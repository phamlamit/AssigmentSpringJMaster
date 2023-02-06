package com.java.realestatemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingEntity extends BaseEntity{
    private String name;
    private String ward;
    private String street;
    private String district;
    private String structure;
    @Column(name = "number_of_basement")
    private Integer numberOfBasement;
    @Column(name = "floor_area")
    private Integer floorArea;
    private String direction;
    private String level;
    @Column(name = "rent_price")
    private Integer rentPrice;
    @Column(name = "rent_price_description")
    private String rentPriceDescription;
    @Column(name = "service_fee")
    private String serviceFee;
    @Column(name = "car_fee")
    private String carFee;
    @Column(name = "moto_fee")
    private String motoFee;
    @Column(name = "over_timefee")
    private String overtimeFee;
    @Column(name = "water_fee")
    private String waterFee;
    @Column(name = "electricity_fee")
    private String electricityFee;
    private String deposit;
    private String payment;
    @Column(name = "rent_time")
    private String rentTime;
    @Column(name = "decoration_time")
    private Double decorationTime;
    @Column(name = "brokerage_fee")
    private Double brokerageFee;
    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "building", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<RentAreaEntity> rentAreas = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "assignment_building",
            joinColumns = @JoinColumn(name = "building_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id"))
    private List<UserEntity> staffs = new ArrayList<>();
}
