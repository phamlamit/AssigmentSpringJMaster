package com.java.assigment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketCreateRequest {
    @NotEmpty
    public String nameCustomer;

    @NotEmpty
    public String phoneCustomer;

    @NotEmpty
    public String description;

    public int departmentId;
}
