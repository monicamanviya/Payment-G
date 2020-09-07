package com.api.payment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="t_card")
public class Card {

	


@Id
@Column(name="CARD_NUMBER")
//@Size(min=12,max=12)
private	long number;

@Column(name="EXPIRATION_MONTH")
private int expirationMonth;

@Column(name="EXPIRATION_YEAR")
private int expirationYear;

@Column(name="CVV")
private int cvv;
public Card() {
	}


public long getNumber() {
	return number;
}
public void setNumber(long number) {
	this.number = number;
}
public int getExpirationMonth() {
	return expirationMonth;
}
public void setExpirationMonth(int expirationMonth) {
	this.expirationMonth = expirationMonth;
}
public int getExpirationYear() {
	return expirationYear;
}
public void setExpirationYear(int expirationYear) {
	this.expirationYear = expirationYear;
}
public int getCvv() {
	return cvv;
}
public void setCvv(int cvv) {
	this.cvv = cvv;
}
@Override
public String toString() {
	return "Card [number=" + number + ", expirationMonth=" + expirationMonth + ", expirationYear=" + expirationYear
			+ ", cvv=" + cvv + "]";
}
	

}
