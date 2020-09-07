package com.api.payment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.payment.entity.Card;
import com.api.payment.entity.PaymentDetails;
import com.api.payment.exception.ResourceNotFoundException;

@Repository
public class PaymentDAOImpl implements PaymentDAO  {

	
	@Autowired
	private EntityManager entitymanager;
	
	
	Card card=new Card();
	
	@Override
	@Transactional
	public List<PaymentDetails> getdetails() {
		
		Session session = entitymanager.unwrap(Session.class);
		Query<PaymentDetails> theQuery = session.createQuery("from PaymentDetails", PaymentDetails.class);
		List<PaymentDetails> details = theQuery.getResultList();
		return details;
	}
	
	public long  saveCardDetails(Card card)
	{
		System.out.println("***\n"+card);
		Session session = entitymanager.unwrap(Session.class);
		return (Long)session.save(card);
	}
	
	@Override
	@Transactional
	public int savedetails(PaymentDetails paymentDetails) {
		System.out.println("3\n");
		System.out.println(paymentDetails);
		Session session = entitymanager.unwrap(Session.class);
	    long res= saveCardDetails(paymentDetails.getCard());
	    paymentDetails.setNumber(paymentDetails.getCard().getNumber());
		return (Integer) session.save(paymentDetails);
	
	}

	@Override
	@Transactional
	public PaymentDetails getById(int id) {
		Session session = entitymanager.unwrap(Session.class);
		PaymentDetails paymentDetails = session.get(PaymentDetails.class, id);
		if(paymentDetails==null) {
			throw new ResourceNotFoundException("PaymentDetails not found with id " +id);
		}
		return paymentDetails; 
			}
	
	
	@Override
	@Transactional
	public void updateDetails(PaymentDetails paymentDetails) {
		Session session = entitymanager.unwrap(Session.class);
		session.update(paymentDetails);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session session = entitymanager.unwrap(Session.class);
		PaymentDetails paymentDetails=getById(id);
		session.delete(paymentDetails);		
	}

			
}



