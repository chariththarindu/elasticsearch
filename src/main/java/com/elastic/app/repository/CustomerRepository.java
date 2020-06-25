package com.elastic.app.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.elastic.app.model.Customer;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

	List<Customer> findByFirstName(String firstname);

}
