package com.example.exerciceinchatgpt.service;


import com.example.exerciceinchatgpt.entite.FirstEntite;
import com.example.exerciceinchatgpt.repository.FirstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FirstService {
    @Autowired
    FirstRepository firstRepository;

//    public FirstService() {
//    }
//
//    public FirstService(FirstRepository firstRepository) {
//        this.firstRepository = firstRepository;
//    }

    public FirstEntite FirstSave(FirstEntite firstEntite) {
        return firstRepository.save(firstEntite);
    }

    public FirstEntite FirstSavewithparam(String name, double compte, int number) {
        FirstEntite firstEntite = new FirstEntite();
        firstEntite.setName(name);
        firstEntite.setCompte(compte);
        firstEntite.setNumber(number);
        firstEntite.setDate(new Date());
        return firstRepository.save(firstEntite);
    }

    public List<FirstEntite> searchbyname(String name) {
        return firstRepository.findByName(name);
    }

    public FirstEntite update(int id, FirstEntite firstEntite) {
        FirstEntite entite = firstRepository.findById(id).orElse(null);
        entite.setName(firstEntite.getName());
        entite.setCompte(firstEntite.getCompte());
        entite.setNumber(firstEntite.getNumber());
        firstEntite.setDate(firstEntite.getDate());
        return firstRepository.save(entite);
    }

    public FirstEntite updatewith(int id, String name, double compte, int number) {
        FirstEntite firstEntite = firstRepository.findById(id).orElse(null);
        firstEntite.setName(name);
        firstEntite.setCompte(compte);
        firstEntite.setDate(firstEntite.getDate());
        return firstRepository.save(firstEntite);

    }


    @Scheduled(fixedRate = 10000) // Définir l'intervalle en millisecondes (ici, toutes les 10 secondes)
    public void myScheduledTask() {
        // Le code à exécuter à intervalles réguliers
        System.out.println("Tâche planifiée exécutée à intervalles réguliers.");
    }

    public List<FirstEntite> listall() {
        return firstRepository.findAll();
    }

    public FirstEntite listbyid(int id) {
        return firstRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
    }


    public void deletebyid(int id) {
        firstRepository.deleteById(id);
    }


    public int factorielservice(int id) {
        FirstEntite entite = firstRepository.findById(id).orElse(null);
        int fact = factoriel(entite.getNumber());
        return fact;
    }

    public int factoriel(int value) {
        if (value <= 1) {
            return 1;
        }
        return (value * factoriel(value - 1));
    }

    public void depot(int id, double montant) {
        if(montant>20) {
            FirstEntite entite = firstRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
            entite.setCompte(entite.getCompte() + montant);
            firstRepository.save(entite);
        }
        if(montant==100){
            throw new RuntimeException("ne doit pas etre egale a 100");
        }
            else {
            throw new RuntimeException("montant doit etre superieur a 20");
        }
    }





    public void retrait(int id, double amount) {
       FirstEntite firstEntite = firstRepository.findById(id).orElseThrow(()->new RuntimeException("id not found"));
       if(firstEntite.getCompte()>=amount) {
           firstEntite.setCompte(firstEntite.getCompte() - amount);
           firstRepository.save(firstEntite);
       }else {
           throw new RuntimeException("insufficient account");
       }

    }

    }













