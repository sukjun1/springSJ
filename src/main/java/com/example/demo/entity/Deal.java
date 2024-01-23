package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_deal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Deal extends BaseEntity{ 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int no;
	@Column(length = 100, nullable = false)
	String title;
	@Column(length = 1000, nullable = false)
	String content;
	@Column(nullable = false)
	int price;
	@Column(length = 100, nullable = false)
	String seller;
	@Column(length = 100, nullable = false)
	String address;
	@Column(length = 1000, nullable = false)
	String link;
}
