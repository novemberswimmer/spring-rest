package org.november.swimmer.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.november.swimmer.domain.Transaction;
import org.november.swimmer.dto.TransactionDto;
import org.november.swimmer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value="/saveTransaction", method=RequestMethod.POST)
	public void saveTransaction(@RequestBody TransactionDto dto) {
		Transaction transaction = new Transaction(new Date(), dto.getPurchaseAmount(), dto.getMerchantName(), dto.getBuyerName());
		transactionService.saveTransaction(transaction);
	}
	
	@RequestMapping(value="/getAllTransactions", method=RequestMethod.GET)
	public List<TransactionDto> getAllTransactions() {
		List<TransactionDto> transactionDtoList = new ArrayList();		
		for(Transaction transaction : transactionService.getAllTransactions()) {
			transactionDtoList.add(new TransactionDto(transaction.getId(), transaction.getTransactionDate(),
					transaction.getPurchaseAmount(), transaction.getMerchantName(), transaction.getBuyerName()));
		}
		return transactionDtoList;
	}
}
