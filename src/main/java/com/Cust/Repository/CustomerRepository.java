package com.Cust.Repository;

import com.Cust.Entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer,Long> {

    Optional<Customer> findByCustomerId(Long Id);

    @Transactional
    void deleteByCustomerId(Long Id);


}
