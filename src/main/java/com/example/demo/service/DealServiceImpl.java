package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DealDTO;
import com.example.demo.entity.Deal;
import com.example.demo.repository.DealRepository;

@Service
public class DealServiceImpl implements DealService{
	@Autowired
	private DealRepository repository;

	@Override
	public int register(DealDTO dto) {
		
		Deal entity = dtoToEntity(dto);
		repository.save(entity);
		return entity.getNo();
	}

	@Override
	public List<DealDTO> getList() {
		List<Deal> deals = repository.findAll();
		List<DealDTO> list = new ArrayList<>();
		list = deals.stream().map(entity -> entityToDto(entity)).collect(Collectors.toList());
		return list;
	}

	@Override
	public DealDTO read(int no) {
		Optional<Deal> optional = repository.findById(no);
		if(optional.isPresent()) {
		Deal deal = optional.get();
		DealDTO dto = entityToDto(deal);
		return dto;
		}else {
			return null;
		}
	}

	@Override
	public void modify(DealDTO dto) {
		Optional<Deal> optional = repository.findById(dto.getNo());
		Deal deal = optional.get();
		deal.setContent(dto.getContent());
		deal.setTitle(dto.getTitle());
		deal.setPrice(dto.getPrice());
		deal.setAddress(dto.getAddress());
		repository.save(deal);
		
	}

	@Override
	public int remove(int no) {
		Optional<Deal> optional = repository.findById(no);
		if(optional.isPresent()) {
			repository.deleteById(no);
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<Deal> search(String title) {
		List<Deal> list = repository.findByTitleContaining(title);
		return list;
	}

}
