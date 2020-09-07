package com.api.payment.dao;

import java.util.List;

import com.api.payment.entity.PaymentDetails;

public interface PaymentDAO {

	public List<PaymentDetails> getdetails();
	public PaymentDetails getById(int id);
	public int savedetails(PaymentDetails paymentDetails);
	public void updateDetails(PaymentDetails paymentDetails);
	public void deleteById(int id);
}
