package com.schairamaniega.pizzaproject.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pizza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Pizza must not be null.")
    @NotEmpty(message = "Pizza must have a name.")
    private String name;

    @NotNull(message = "Pizza must receive an image source.")
    @NotEmpty(message = "Pizza must have a filled image source.")
    private String img;

    // TODO: Complete relation
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "pizza")
    private List<Comment> comments;

    @NotNull(message = "Pizza price must not be null.")
    @NotEmpty(message = "Pizza price must be filled.")
    @Min(value = 0, message = "Pizza price cannot be negative.")
    private Double price;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable
    private List<Ingredient> ingredients;


}
