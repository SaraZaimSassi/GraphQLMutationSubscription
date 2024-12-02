package org.example.graphqlsbscription.repositories;

import org.example.graphqlsbscription.dao.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
}
