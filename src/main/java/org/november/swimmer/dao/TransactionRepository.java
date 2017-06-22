package org.november.swimmer.dao;

import org.november.swimmer.domain.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
