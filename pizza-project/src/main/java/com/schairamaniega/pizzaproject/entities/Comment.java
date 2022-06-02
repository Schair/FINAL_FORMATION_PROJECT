
package com.schairamaniega.pizzaproject.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Comment must have a text.")
    @NotEmpty(message = "Comment text must be filled, not empty.")
    private String body;

    @Min(value = 0, message = "Score must be higher than 0.")
    @Max(value = 10, message = "Score must be lower than 10.")
    private Double score;

    @NotNull(message = "Comment must be posted by an user.")
    private String user;

    // TODO: Complete relation
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @NotNull(message = "Comment pizza must not be null.")
    private Pizza pizza;

}
