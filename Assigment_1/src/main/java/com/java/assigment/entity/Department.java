package com.java.assigment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department implements Serializable {
    private static final long serialVersionUID = -2498286535698650205L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    Date createdDate;

}