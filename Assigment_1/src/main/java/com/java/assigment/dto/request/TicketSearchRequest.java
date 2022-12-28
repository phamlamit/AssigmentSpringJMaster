package com.java.assigment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketSearchRequest {
    private String keyWorld;
    private String departmentId;
    private Date from;
    private Date to;
}
