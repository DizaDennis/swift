package com.sales.swift.repositories;

import com.sales.swift.entities.CardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CardDataRepo extends JpaRepository<CardData, Long> {

}
