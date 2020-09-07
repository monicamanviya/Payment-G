package com.api.payment.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.payment.entity.PaymentDetails;
import com.api.payment.service.PaymentService;

@RestController
@Validated
@RequestMapping("/")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	

	@CrossOrigin("*")
	@GetMapping("/paymentDetails")
	public ResponseEntity<List<PaymentDetails>> findAll() {
		
		List<PaymentDetails> details=paymentService.getdetails();
		return new ResponseEntity<List<PaymentDetails>>(details,HttpStatus.OK);
	}
	
	@CrossOrigin("*")
	@GetMapping("/paymentDetails/viewbyId/{id}")
	public ResponseEntity<?> getDetail(@PathVariable int id) {
	
		PaymentDetails paymentDetail=paymentService.getById(id);
		return new ResponseEntity<>(paymentDetail,HttpStatus.OK);	
	}
	
	@CrossOrigin("*")
	@PostMapping("/paymentDetails/add")
	public ResponseEntity<?> saveDetails(@RequestBody PaymentDetails paymentDetails) {
		System.out.println("1"+paymentDetails);
	int id=	paymentService.savedetails(paymentDetails);
	SuccessDetails successDetails=new SuccessDetails(paymentDetails.getAmount(),paymentDetails.getCurrency(),paymentDetails.getCardType(),paymentDetails.getCard(),
			"success","SDSD234235",LocalDateTime.now());
	return new  ResponseEntity<>(successDetails,HttpStatus.CREATED);

	}
	
	@CrossOrigin("*")
	@PutMapping("/paymentDetails/update")
	public ResponseEntity<?> updateDetails(@RequestBody PaymentDetails paymentDetails) {
		System.out.println("1"+paymentDetails);
	    paymentService.updateDetails(paymentDetails);
	SuccessDetails successDetails=new SuccessDetails(paymentDetails.getAmount(),paymentDetails.getCurrency(),paymentDetails.getCardType(),paymentDetails.getCard(),
			"success","SDSD234235",LocalDateTime.now());
	return new  ResponseEntity<>(successDetails,HttpStatus.CREATED);

	}
	
	@CrossOrigin("*")
	@DeleteMapping("/paymentDetails/delete/{id}")
	public ResponseEntity<Void> deletePaymentDetails(@PathVariable int id) {
		paymentService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}
