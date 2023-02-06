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
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity {
    private String code;
    private String note;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
