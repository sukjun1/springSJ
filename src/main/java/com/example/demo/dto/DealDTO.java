package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DealDTO {
	int no;
	String title;
	String content;
	int price;
	String seller;
	String address;
	LocalDateTime regDate;
	LocalDateTime modDate;
}
