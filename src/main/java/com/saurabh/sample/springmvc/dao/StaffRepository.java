package com.saurabh.sample.springmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.sample.springmvc.entity.StaffEntity;

public interface StaffRepository extends JpaRepository<StaffEntity, Long>{

}
