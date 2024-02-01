package com.example.exerciceinchatgpt.entite;

import com.example.exerciceinchatgpt.role.Activer;
import com.example.exerciceinchatgpt.role.RoleUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.management.relation.Role;
import java.util.Date;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="webtry")
@Entity
public class FirstEntite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty(message = "name ne doit pas etre vide")
    @Size(min=3,message = "ne doit pas etre inferieur a 3 caracteres")
    private String name;
    private double compte;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private Date date;
    @Enumerated(EnumType.STRING)
    private RoleUser roleuser;
    @NotEmpty(message ="username ne doit pas etre vide" )
    private String username;
    @NotEmpty(message = "password ne doit pas etre vide")
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private Activer activer;
    public int number;

}
