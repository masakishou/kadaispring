
package com.example.ginkou2.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.ginkou2.model.GakuseiHyou;
import com.example.ginkou2.repository.GakuseiRepository;

import jakarta.transaction.Transactional;


 
@Service
@Transactional
public class  GakuseiService{
 
    @Autowired
    private GakuseiRepository repository;
 
 
    public void save(@NonNull GakuseiHyou gakusei) {
        this.repository.save(gakusei);
    }

}