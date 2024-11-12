package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.Admin_Service;

@RestController
@RequestMapping("/admin")
public class Admin_Controller {
	
	
	@Autowired
	private Admin_Service admin_Service;
	
	@PostMapping("/generateBill/{customerId}")
    public ResponseEntity<Double> generateBill(@PathVariable Long customerId) {
        double totalBill = admin_Service.generateBill(customerId);
        return new ResponseEntity<>(totalBill, HttpStatus.OK);
    }
	
	

}
