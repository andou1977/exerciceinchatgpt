package com.example.exerciceinchatgpt.repository;



import com.example.exerciceinchatgpt.entite.FirstEntite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FirstRepository extends JpaRepository<FirstEntite,Integer> {
    List<FirstEntite> findByName(String name);


}
