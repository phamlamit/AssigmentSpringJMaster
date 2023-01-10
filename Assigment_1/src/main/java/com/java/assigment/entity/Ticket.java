package com.java.assigment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {
    private static final long serialVersionUID = -2498286535698650205L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "name_customer")
    private String nameCustomer;

    @Column(name = "phone_customer")
    private String phoneCustomer;

    private String description;

    private Boolean status;

    @Temporal(TemporalType.DATE)
    @Column(name = "resolved_date")
    private Date resolvedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;


}