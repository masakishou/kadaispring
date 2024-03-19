package com.example.ginkou2.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ginkou2.model.GakuseiHyou;
 
@Repository
public interface GakuseiRepository  extends JpaRepository<GakuseiHyou, Long>{
 
}