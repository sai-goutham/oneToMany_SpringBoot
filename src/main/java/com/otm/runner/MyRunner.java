package com.otm.runner;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.otm.entity.Customer;
import com.otm.entity.Loan;
import com.otm.repository.CustomerRepository;
import com.otm.repository.LoanRepository;

@Component
public class MyRunner implements CommandLineRunner {
@Autowired 
CustomerRepository custRepo;

@Autowired
LoanRepository loanRepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Customer c= new Customer();
		c.setCustomerId(1001);
		c.setCustomerName("Goutham");
		
		Loan l = new Loan();
		l.setLoanId("LN-121");
		l.setLoanType("Personal");
		l.setAmount(2000000);
		
		Loan home = new Loan();
		home.setLoanId("LN-H122");
		home.setLoanType("HOME");
		home.setAmount(9000000);
		
		Set<Loan> loans =new HashSet<Loan>();
		loans.add(home);
		loans.add(l);
		c.setLoans(loans);
		
		
		custRepo.save(c);
		
		

	}

}
