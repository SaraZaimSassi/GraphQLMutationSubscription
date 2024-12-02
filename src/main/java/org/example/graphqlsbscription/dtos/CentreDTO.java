package org.example.graphqlsbscription.dtos;

import java.util.List;

public record CentreDTO(
        String nom,
        String adresse,
        List<EtudiantDTO> listEtudiants
) {
}