package com.digency.dao;


import com.digency.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneDao  extends JpaRepository<Personne,Integer>
{
}
