package com.schairamaniega.pizzaproject.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Ingredient name must not be null.")
    @NotEmpty(message = "Ingredient name must have a name.")
    private String name;

    @NotNull(message = "Ingredient price must not be null.")
    // @NotEmpty(message = "Ingredient price must have a price.")
    @Min(value = 0, message = "Ingredient price must not be negative.")
    private Double price;

    // TODO: Check relation
    // @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "ingredients")
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "ingredients")
    private List<Pizza> pizzas;
}
