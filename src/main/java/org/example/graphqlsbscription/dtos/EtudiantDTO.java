package org.example.graphqlsbscription.dtos;

import org.example.graphqlsbscription.enums.Genre;

public record EtudiantDTO (
        String nom,
        String prenom,
        Genre genre,
        Long centreId
){ }