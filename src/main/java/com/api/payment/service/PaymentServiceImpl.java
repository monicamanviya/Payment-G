package com.api.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.payment.dao.PaymentDAO;
import com.api.payment.dao.PaymentDAOImpl;
import com.api.payment.entity.PaymentDetails;
import com.api.payment.exception.ResourceNotFoundException;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentDAO paymentDAO;
	
	
	public PaymentServiceImpl(PaymentDAOImpl paymentDAOImpl) {
		paymentDAO = paymentDAOImpl;
	}

	@Override
	public List<PaymentDetails> getdetails() {
		
		List<PaymentDetails> paymentDetails = paymentDAO.getdetails();
		return paymentDetails;
	}

	@Override
	public PaymentDetails getById(int id) {
		PaymentDetails paymentDetail = paymentDAO.getById(id);
		return paymentDetail;
	}

	@Override
	public int savedetails(PaymentDetails paymentDetails) {
		System.out.println("2\n"+paymentDetails);
		paymentDetails.setNumber(paymentDetails.getCard().getNumber());
		
		if((paymentDetails.getCardType().equalsIgnoreCase("Credit")||paymentDetails.getCardType().equalsIgnoreCase("Debit"))
				&& (paymentDetails.getCurrency().equalsIgnoreCase("USD")||paymentDetails.getCurrency().equalsIgnoreCase("INR")))
		{
			paymentDetails.setCardType(paymentDetails.getCardType().toUpperCase());
			paymentDetails.setCurrency(paymentDetails.getCurrency().toUpperCase());
			return  (Integer)paymentDAO.savedetails(paymentDetails);
		}
		else {
			throw new ResourceNotFoundException("Invalid Card Type:Card is either Credit or Debit OR Invalid currency:Card is either USD or INR ");
		}
	}

	@Override
	public void updateDetails(PaymentDetails paymentDetails) {
		paymentDetails.setNumber(paymentDetails.getCard().getNumber());
		 paymentDAO.updateDetails(paymentDetails);
		
	}

	@Override
	public void deleteById(int id) {
		paymentDAO.deleteById(id);
	}

}
