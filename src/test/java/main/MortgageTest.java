package main;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import solution.CustomerLoanProspect;

class MortgageTest {

	@Test
	void test() throws IOException {
		CustomerLoanSolution customerLoanSolution= new CustomerLoanSolution();
	    ArrayList<CustomerLoanProspect> customerLoanProspects =customerLoanSolution.fileReaderforCustomerData();
	    for(CustomerLoanProspect ob:customerLoanProspects )
		{
			customerLoanSolution.calculateMonthlyPayment(ob);
			
		}
	   
	}

}
