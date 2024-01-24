package com.example.demo.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.example.demo.dto.DealDTO;
import com.example.demo.entity.Deal;

import jakarta.transaction.Transactional;

public interface DealService {
	// 게시물 등록
	int register(DealDTO dto);

	List<DealDTO> getList();

	DealDTO read(int no);

	

	default Deal dtoToEntity(DealDTO dto) {
		Deal entity = Deal.builder().no(dto.getNo()).price(dto.getPrice()).title(dto.getTitle())
				.content(dto.getContent()).seller(dto.getSeller()).address(dto.getAddress()).build();
		return entity;
	}
	
	default DealDTO entityToDto(Deal entity) {
		DealDTO dto = DealDTO.builder().no(entity.getNo()).title(entity.getTitle())
				.content(entity.getContent()).price(entity.getPrice()).seller(entity.getSeller())
				.address(entity.getAddress()).regDate(entity.getRegDate()).modDate(entity.getModDate()).build();
		return dto;
	}
	void modify(DealDTO dto);

	int remove(int no);
	
}
