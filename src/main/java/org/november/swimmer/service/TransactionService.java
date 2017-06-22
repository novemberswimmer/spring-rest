package org.november.swimmer.service;

import java.util.ArrayList;
import java.util.List;

import org.november.swimmer.dao.TransactionRepository;
import org.november.swimmer.domain.Transaction;
import org.november.swimmer.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository repository;
	
	public void saveTransaction(Transaction transaction) {
		repository.save(transaction);
	}

	public List<Transaction> getAllTransactions() {
		List<Transaction> target = new ArrayList<Transaction>();
		repository.findAll().forEach(target::add);
		return target;
	}
}
