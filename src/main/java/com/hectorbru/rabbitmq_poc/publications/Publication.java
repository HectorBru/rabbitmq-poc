package com.hectorbru.rabbitmq_poc.publications;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "publications")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String title;

    @Column
    private int numberOfLikes;

/*
    @ManyToOne
    private User creator;
*/

}