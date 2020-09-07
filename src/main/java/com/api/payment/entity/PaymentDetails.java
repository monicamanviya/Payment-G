package com.api.payment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;




@Entity
@Table(name="t_payment_details")
public class PaymentDetails {
	

		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private	int id;

	@Column(name="AMOUNT")
	private int amount;

	@Column(name="CURRENCY")
	private String currency;

	@Column(name="CARD_TYPE")
	private String cardType;
	
	@Column(name="CARD_NUMBER")
	//@Size(min=12,max=12)
	private long number;
	
	@ManyToOne
	@JsonDeserialize()
	@JoinColumn( name="CARD_NUMBER",insertable = false, updatable = false)
	private Card card;
	
	
	public PaymentDetails() {
		
	}
	
	

	public long getNumber() {
		return number;
	}



	public void setNumber(long number) {
		this.number = number;
	}



	public Card getCard() {
		return card;
	}



	public void setCard(Card card) {
		this.card = card;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}



	@Override
	public String toString() {
		return "PaymentDetails [id=" + id + ", amount=" + amount + ", "
				+ "currency=" + currency + ", cardType=" + cardType
				+ ", card=" + card + "]";
	}

	
	
}
