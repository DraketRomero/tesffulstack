package com.testfusllstack.garrido_backend.controllers.DTO;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class PersonDTO {
    private Long id;

    private String name;

    private String lastname;

    private LocalDate birthday;

    private String position;

    private BigDecimal salary;
}
