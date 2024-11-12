package serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;

import repository.Admin_Repository;
import service.Admin_Service;

public class AdminServiceImpl implements Admin_Service{

	@Autowired
	private Admin_Repository admin_Repository;
	
	@Override
	public double generateBill(Long customerId) {
		return 0;
	}
}
