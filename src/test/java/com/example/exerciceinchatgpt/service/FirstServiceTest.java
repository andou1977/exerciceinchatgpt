package com.example.exerciceinchatgpt.service;

import com.example.exerciceinchatgpt.entite.FirstEntite;
import com.example.exerciceinchatgpt.repository.FirstRepository;
import com.example.exerciceinchatgpt.role.Activer;
import com.example.exerciceinchatgpt.role.RoleUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FirstServiceTest {

    @Mock
    FirstRepository firstRepository;
    @InjectMocks
    FirstService firstService;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void factorielservice() {
        FirstService firstService = mock(FirstService.class);

        when(firstService.factoriel(6)).thenReturn(120);
        assertEquals(120, firstService.factoriel(6));

    }


    @Test
    void firstSave() {
        FirstEntite firstEntite=new FirstEntite(1,"andou",89.9,new Date(),RoleUser.ADMIN,"andou","pass",Activer.True,4);

        when(firstRepository.save(firstEntite)).thenReturn(firstEntite);

        FirstEntite result=firstService.FirstSave(firstEntite);
        assertEquals(firstEntite.getName(),result.getName());

    }

    @Test
    void deletebyid() {
        FirstEntite firstEntite=new FirstEntite(1,"andou",89.9,new Date(),RoleUser.ADMIN,"andou","pass",Activer.True,4);
firstService.deletebyid(firstEntite.getId());
verify(firstRepository,times(1)).deleteById(firstEntite.getId());
    }

    @Test
    void listbyid() {
        FirstEntite firstEntite=new FirstEntite(1,"andou",89.9,new Date(),RoleUser.ADMIN,"andou","pass",Activer.True,4);

        when(firstRepository.findById(firstEntite.getId())).thenReturn(Optional.of(firstEntite));
        FirstEntite result=firstService.listbyid(firstEntite.getId());
        assertEquals(firstEntite.getName(),result.getName());
        verify(firstRepository).findById(1);
    }

    @Test
    void depot() {
        FirstEntite firstEntite=new FirstEntite();
        firstEntite.setId(1);
        firstEntite.setCompte(4000);

        when(firstRepository.findById(1)).thenReturn(Optional.of(firstEntite));

        FirstEntite result=firstService.listbyid(1);
        assertEquals(4000,firstEntite.getCompte());
    }
}

