package org.example.graphqlsbscription.services;

import org.example.graphqlsbscription.dao.Centre;
import org.example.graphqlsbscription.dao.Etudiant;
import org.example.graphqlsbscription.repositories.CentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CentreService {
    @Autowired
    private CentreRepository centreRepository;

    // Récupérer tous les centres
    public List<Centre> centres() {
        return centreRepository.findAll();
    }

    // Ajouter un centre
    public Centre addCentre(String nom, String adresse) {
        Centre centre = new Centre();
        centre.setNom(nom);
        centre.setAdresse(adresse);
        return centreRepository.save(centre);
    }

    // Mettre à jour un centre
    public Centre updateCentre(Long id, String nom, String adresse) {
        Optional<Centre> centreOptional = centreRepository.findById(id);
        if (centreOptional.isPresent()) {
            Centre centre = centreOptional.get();
            centre.setNom(nom);
            centre.setAdresse(adresse);
            return centreRepository.save(centre);
        }
        return null; // Retourne null si le centre n'existe pas
    }

    // Supprimer un centre
    public String deleteCentre(Long id) {
        if (centreRepository.findById(id).isPresent()) {
            centreRepository.deleteById(id);
            return String.format("Le centre %s a été supprimé avec succès !", id);
        }
        return String.format("Le centre %s n'existe pas !", id);
    }

    // Récupérer un centre par ID
    public Centre getCentre(Long id) {
        return centreRepository.findById(id).orElse(null);
    }

    // Récupérer les étudiants d'un centre
    public List<Etudiant> getEtudiantsByCentre(Long id) {
        Centre centre = centreRepository.findById(id).orElse(null);
        if (centre != null) {
            return centre.getListEtudiants();
        }
        return null;
    }
}
