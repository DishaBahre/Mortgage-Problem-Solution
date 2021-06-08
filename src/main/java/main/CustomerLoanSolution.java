package main;
import solution.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CustomerLoanSolution {

	public static void main(String[] args) throws FileNotFoundException {

		CustomerLoanSolution customerLoanSolution= new CustomerLoanSolution();
		ArrayList<CustomerLoanProspect> customerLoanProspects =customerLoanSolution.fileReaderforCustomerData();
		for(CustomerLoanProspect ob:customerLoanProspects )
		{
			customerLoanSolution.calculateMonthlyPayment(ob);
			
		}
	
	}

	public static double myPower(double base, int exponent) {
		if (exponent == 0)
			return 1;
		else
			return base * myPower(base, exponent - 1);
	}

	public  double calculateMonthlyPayment(
			CustomerLoanProspect customerData) {
		/*
		 * E = Fixed monthly payment b = Interest on a monthly basis U = Total
		 * loan p = Number of payments E = U[b(1 + b)^p]/[(1 + b)^p - 1]
		 */
		double InterestRate = customerData.getAnnualInterestRate()/100;
		double totalLoan = customerData.getTotalLoan();
		int numberOfPayments = customerData.getYears();
		double _1plus_b_Power_P = myPower((1 + InterestRate),
				numberOfPayments); 
		double monthlyPayment = totalLoan
				* (InterestRate * (_1plus_b_Power_P))
				/ ((_1plus_b_Power_P - 1)*12);
		System.out.println(customerData.getCustomerName() + " wants to borrow "
				+ totalLoan + " for a period of " + customerData.getYears()
				+ " years and pay " + monthlyPayment + " each month");

		return monthlyPayment;
	}

	public ArrayList<CustomerLoanProspect> fileReaderforCustomerData() throws FileNotFoundException {
		ArrayList<CustomerLoanProspect> customerLoanProspects = new ArrayList<CustomerLoanProspect>();

		String fileName = "files/prospects.txt";
		InputStream is = getFileFromResourceAsStream(fileName);
		
		InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
         BufferedReader reader = new BufferedReader(streamReader);
		
		String line = "";
		boolean firstLine= true;
		try {
			while ((line = reader.readLine()) != null) {
				System.out.println("Line is "+line);
				if(firstLine)
				{

					firstLine=false;
					continue;	
				}
				String[] values = line.split(",");
				CustomerLoanProspect customerLoanProspect = new CustomerLoanProspect();
				//Customer,Total loan,Interest,Years
				customerLoanProspect.setCustomerName(values[0]);
				customerLoanProspect.setTotalLoan(Double.valueOf(values[1]));
				customerLoanProspect.setAnnualInterestRate(Double.valueOf(values[2]));
				customerLoanProspect.setYears(Integer.valueOf(values[3]));
				customerLoanProspects.add(customerLoanProspect);
			}


		}
	

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return customerLoanProspects;
	   
		
	}

	// get a file from the resources folder
    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

}
