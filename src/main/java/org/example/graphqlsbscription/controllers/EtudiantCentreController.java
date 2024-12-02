package org.example.graphqlsbscription.controllers;

import org.example.graphqlsbscription.dao.Centre;
import org.example.graphqlsbscription.dao.Etudiant;
import org.example.graphqlsbscription.dtos.EtudiantDTO;
import org.example.graphqlsbscription.services.CentreService;
import org.example.graphqlsbscription.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
@Controller
public class EtudiantCentreController {
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    CentreService centreService;
    @QueryMapping
    public List<Centre> getAllCentres(){
        return centreService.centres();
    }
    @QueryMapping
    public List<Etudiant> getAllEtudiants(){
        return etudiantService.getStudents();
    }
    @QueryMapping
    public Centre getCentre(@Argument Long id){
        return centreService.getCentre(id);
    }
    @QueryMapping
    public Etudiant getEtudiant(@Argument Long id){
        return etudiantService.getEtudiant(id);
    }
    @MutationMapping
    public Etudiant addEtudiant(@Argument EtudiantDTO etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }
    @MutationMapping
    public String suppEtudiant(@Argument Long id){
        return etudiantService.deleteEtudiant(id);
    }
    @MutationMapping
    public Etudiant updateEtudiant(@Argument Long id, @Argument EtudiantDTO etudiant){
        return etudiantService.updateEtudiant(id,etudiant);
    }




    // Mutation pour ajouter un étudiant


    // Mutation pour ajouter un centre
    @MutationMapping
    public Centre addCentre(@Argument String nom, @Argument String adresse) {
        return centreService.addCentre(nom, adresse);
    }

    // Mutation pour mettre à jour un centre
    @MutationMapping
    public Centre updateCentre(@Argument Long id, @Argument String nom, @Argument String adresse) {
        return centreService.updateCentre(id, nom, adresse);
    }

    // Mutation pour supprimer un centre
    @MutationMapping
    public String deleteCentre(@Argument Long id) {
        return centreService.deleteCentre(id);
    }
}