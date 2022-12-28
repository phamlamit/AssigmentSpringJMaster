package com.java.assigment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketCreateRequest {
    @NotNull
    @NotBlank
    public String nameCustomer;

    @NotNull
    @NotBlank
    public String phoneCustomer;

    @NotNull
    @NotBlank
    public String description;

    @NotNull
    @NotBlank
    public int departmentId;
}
