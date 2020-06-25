package com.elastic.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "saviya_customer" , type = "customer" , shards = 2)
public class Customer {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private int age;
	
}
