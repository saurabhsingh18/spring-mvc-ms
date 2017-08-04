package com.saurabh.sample.springmvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saurabh.sample.springmvc.entity.GenreEntity;

@Repository
public interface GenresRepository extends JpaRepository<GenreEntity, Long> {

	@Query("SELECT g FROM GenreEntity g where g.genreName IN :nameList")
	List<GenreEntity> findByGenreName(@Param("nameList") List<String> nameList);
}
