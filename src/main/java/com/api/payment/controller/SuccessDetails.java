package com.api.payment.controller;

import java.time.LocalDateTime;

import com.api.payment.entity.Card;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

public class SuccessDetails {

	public int amount;
	public String currency;
	public String type;
	public Card card;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	public String status;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="SDSD-NN")
	public String authorization_code;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	LocalDateTime timestamp;
	public SuccessDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SuccessDetails(int amount, String currency, String type, Card card, String status, String authorization_code,
			LocalDateTime timestamp) {
		super();
		this.amount = amount;
		this.currency = currency;
		this.type = type;
		this.card = card;
		this.status = status;
		this.authorization_code = authorization_code;
		this.timestamp = timestamp;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAuthorization_code() {
		return authorization_code;
	}
	public void setAuthorization_code(String authorization_code) {
		this.authorization_code = authorization_code;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "SuccessDetails [amount=" + amount + ", currency=" + currency + ", type=" + type + ", card=" + card.getNumber()
				+ ", status=" + status + ", authorization_code=" + authorization_code + ", timestamp=" + timestamp
				+ "]";
	}
	
	
}
