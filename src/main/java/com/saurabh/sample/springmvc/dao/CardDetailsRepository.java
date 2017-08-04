package com.saurabh.sample.springmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saurabh.sample.springmvc.entity.CardDetailsEntity;

@Repository
public interface CardDetailsRepository extends JpaRepository<CardDetailsEntity, Long> {

}
