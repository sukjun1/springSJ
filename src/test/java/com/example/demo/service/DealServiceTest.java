package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.DealDTO;

@SpringBootTest
public class DealServiceTest {
	@Autowired
	DealService service;
	
	@Test
	public void 등록() {
		DealDTO dto = DealDTO.builder().title("aa").content("bb").price(10).seller("cc").address("dd").build();
		service.register(dto);
	}
	@Test
	public void 목록조회() {
		List<DealDTO> list = service.getList();
		System.out.println(list);
	}
	@Test
	public void 단건조회() {
		DealDTO dto = service.read(2);
		System.out.println(dto);
	}
	@Test
	public void 수정() {
		DealDTO dto = service.read(1);
		dto.setContent("aa");
		dto.setTitle("bb");
		dto.setPrice(2000);
		dto.setAddress("cc");
		service.modify(dto);
	}
	@Test
	public void 삭제() {
		service.remove(3);
	}
}
