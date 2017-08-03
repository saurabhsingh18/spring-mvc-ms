package com.saurabh.sample.springmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.sample.springmvc.entity.GenreEntity;

public interface GenresRepository extends JpaRepository<GenreEntity, Long> {

}
