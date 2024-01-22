package com.example.demo.repository;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Deal;

@SpringBootTest

public class DealRepositoryTest {
	@Autowired
	DealRepository repository;
	
	@Test
	public void 등록() {
		Deal deal = Deal.builder().title("a").content("b").price(10).seller("c").address("d").build();
		repository.save(deal);
	}
	@Test
	public void 목록조회() {
		List<Deal> list = repository.findAll();
		for(Deal deal : list) {
			System.out.println(deal);
		}
	}
	@Test
	public void 단건조회() {
		Optional<Deal> optional = repository.findById(1);
		System.out.println(optional);
	}
	@Test
	public void 수정() {
		Optional<Deal> optional = repository.findById(1);
		Deal deal = optional.get();
		deal.setAddress("aa");
		deal.setContent("bb");
		deal.setPrice(20000);
		deal.setTitle("cc");
		repository.save(deal);
	}
	@Test
	public void 삭제() {
		repository.deleteById(1);
	}
}
