package com.api.payment.service;

import java.util.List;

import com.api.payment.entity.PaymentDetails;

public interface PaymentService {

	public List<PaymentDetails> getdetails();
	public PaymentDetails getById(int id);
	public int savedetails(PaymentDetails paymentDetails);
	public void updateDetails(PaymentDetails paymentDetails);
	public void deleteById(int id);

}
