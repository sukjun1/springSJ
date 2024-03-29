package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Deal;

public interface DealRepository extends JpaRepository<Deal, Integer>{
	List<Deal> findByTitleContaining(String title);
}
