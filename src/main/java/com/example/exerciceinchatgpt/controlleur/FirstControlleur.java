package com.example.exerciceinchatgpt.controlleur;

import com.example.exerciceinchatgpt.entite.FirstEntite;
import com.example.exerciceinchatgpt.repository.FirstRepository;
import com.example.exerciceinchatgpt.service.FirstService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/first")
public class FirstControlleur {


    @Value("${mon.application.version}")
    public String version;
    @Value("${mon.application.name}")
    public String name;
    @Value("${mon.application.mode}")
    public String mode;

    public void afficher(){
        System.out.println(version);
    }

   FirstRepository firstRepository;
    FirstService firstService;

    public FirstControlleur(FirstRepository firstRepository, FirstService firstService) {
        this.firstRepository = firstRepository;
        this.firstService = firstService;
    }




@PostMapping("/save")
public Object savedata(@RequestBody @Valid  FirstEntite firstEntite){
        if(firstEntite.getCompte()<20){
            return new ResponseEntity<>(" solde ne doit pas etre inferieur a 20", HttpStatus.OK);

        }
       return firstService.FirstSave(firstEntite);
}
    @PostMapping("/savewith")
    public FirstEntite savedatawithparam(String name, double compte,int number ){
        return firstService.FirstSavewithparam(name,compte,number);
    }

    @GetMapping("/search")
    public List<FirstEntite> searchbyname(@Valid String name){
        return firstService.searchbyname(name);

    }
    @PutMapping("/update")
    public FirstEntite update(@Valid int id, FirstEntite firstEntite){
        return firstService.update(id,firstEntite);
    }

    @PutMapping("/updatewith")
    public FirstEntite updatewith(@Valid int id,String name,double compte,int number){
        return firstService.updatewith(id,name,compte,number);
    }

    @GetMapping("/list")
    public List<FirstEntite> listall() {
        return firstService.listall();
    }

    @GetMapping("/list/{id}")
    public FirstEntite listbyid(@PathVariable int id) {
        return firstService.listbyid(id);
    }

    @GetMapping("/factoriel/{id}")
    public int factoriel(@PathVariable int id) {
        return firstService.factorielservice(id);
    }

    @GetMapping("/delete/{id}")
    public void delete(int id) {
        firstService.deletebyid(id);
    }


    @PutMapping("/depot/{id}")
    public void depot(@RequestParam int id,double montant){
    firstService.depot(id,montant);
    }

    @PutMapping("/retrait/{id}")
    public void retraitclient(int id,double montant){
        firstService.retrait(id,montant);
    }
}
