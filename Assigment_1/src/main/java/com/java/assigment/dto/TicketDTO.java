package com.java.assigment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private int id;
    private DepartmentDTO department;

    private String nameCustomer;
    private String phoneCustomer;
    private String description;
    private boolean status;
    private Date resolvedDate;
    private Date createdDate;
}
