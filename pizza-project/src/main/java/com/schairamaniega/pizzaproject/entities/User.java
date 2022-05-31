package com.schairamaniega.pizzaproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "User email must not be null.")
    @NotEmpty(message = "User email must be filled.")
    private String email;

    @NotNull(message = "User name must not be null.")
    @NotEmpty(message = "User name must be filled.")
    private String name;

    @NotNull(message = "User surname must not be null.")
    @NotEmpty(message = "User surname must be filled with at least one surname.")
    private String surname;

    @NotNull(message = "Password must not be null.")
    @Size(min = 4, message = "Password must have at least 4 characters.")
    private String password;
}
