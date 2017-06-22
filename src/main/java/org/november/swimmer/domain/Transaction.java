package org.november.swimmer.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date transactionDate;
	private BigDecimal purchaseAmount;
	private String merchantName;
	private String buyerName;
	
	public Transaction() {
		super();
	}

	public Transaction(Date transactionDate, BigDecimal purchaseAmount, String merchantName,
			String buyerName) {
		this.transactionDate = transactionDate;
		this.purchaseAmount = purchaseAmount;
		this.merchantName = merchantName;
		this.buyerName = buyerName;
	}
	
	public Long getId() {
		return id;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public BigDecimal getPurchaseAmount() {
		return purchaseAmount;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public String getBuyerName() {
		return buyerName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buyerName == null) ? 0 : buyerName.hashCode());
		result = prime * result + ((merchantName == null) ? 0 : merchantName.hashCode());
		result = prime * result + ((purchaseAmount == null) ? 0 : purchaseAmount.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (buyerName == null) {
			if (other.buyerName != null)
				return false;
		} else if (!buyerName.equals(other.buyerName))
			return false;
		if (merchantName == null) {
			if (other.merchantName != null)
				return false;
		} else if (!merchantName.equals(other.merchantName))
			return false;
		if (purchaseAmount == null) {
			if (other.purchaseAmount != null)
				return false;
		} else if (!purchaseAmount.equals(other.purchaseAmount))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		return true;
	}
	
	
}
