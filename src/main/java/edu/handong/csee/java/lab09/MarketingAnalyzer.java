package edu.handong.csee.java.lab09;

// Insert Scanner, ArrayList
import java.util.Scanner;
import java.util.ArrayList;

/**
 * class MarketingAnalyzer
 * there are three variables and four methods.
 * 
 * @author smile
 *
 */
public class MarketingAnalyzer {
	
	// define class private variable
	ArrayList<String> nameList = new ArrayList<String>();
	ArrayList<Double> salesList = new ArrayList<Double>();// ArrayList containing salesman information
	private double highestSales; // The highest sales
	private double averageSales; // The average amount sold
	
	/**
	 * main program
	 * 
	 * get the salesman information from the user.
	 * compute the average of sales and highest sales.
	 * print the highest sales and the salesman. 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Instantiate an object of class MarketingAnalyzer
		MarketingAnalyzer marketingAnalyzer = new MarketingAnalyzer();

		// call the method in marketingAnalyzer
		marketingAnalyzer.getData(); // get the salesman information from the user
		marketingAnalyzer.computeAverage(); // compute the average of sales
		marketingAnalyzer.computeHighestSales(); // compute the highest sales
		marketingAnalyzer.printResultes(); // print the highest sales and the salesman
	}
	
	/**
	 * method getData
	 * 
	 * get the number represent the salesman's number from the user
	 * and get the salesman information (name and sales) 
	 * 
	 */
	// method get the salesman information
	public void getData()
	{
		boolean done = false;
		Scanner keyboard = new Scanner(System.in);
		int i = 0;

		// Get each salesman's information until the numOFSalesman is finished.
		while(!done) {

			// Get the (i+1)th salseman's information (name and sales)
			System.out.println("Enter data for associate number " + (i+1));
			
			System.out.print("Enter name of sales associate: ");
			// Receive all entered strings by name
			String name = keyboard.nextLine();

			System.out.print("Enter associate's sales: $");
			// Receive entered number by sales
			double sales = keyboard.nextDouble();
			keyboard.nextLine();
			
			System.out.print("\nDo you want to enter more salesman? ");
			String ans = keyboard.nextLine();
			
			if(!ans.equalsIgnoreCase("yes"))
				done = true;
			
			// put salesman's name in name list 
			this.nameList.add(name);
			// put salesman's sales in sales list
			this.salesList.add(sales);		
			
			System.out.println();
			i++;
		}
	}

	/**
	 * method computeAverage
	 * calculate the average of sales
	 * 
	 */
	// method that calculate the average of sales
	public void computeAverage() {
		
		// initialize the sum by 0
		double sum = 0;

		// Until finish the array list, add the sales to sum
		for(int i=0; i < salesList.size(); i++) {
			// add value of index i in salesList to sum
			sum = sum + salesList.get(i);
		}
		
		// divide the sum to salesList size and put this value into averageSales
		this.averageSales = sum/salesList.size();
	}	
	
	/**
	 * method computeHighestSales
	 * find the highest sales
	 * 
	 */
	// method that find the highest sales
	public void computeHighestSales() {
		
		// initialize the highestSales by 0;
		double highestSales = 0;
		
		// Until finish the array list, compare highestSales with value of index i of salseList
		for(int i=0; i<salesList.size(); i++) {
			// If value of the index i is greater than highestSales
			if(highestSales < salesList.get(i))
				// set the highestSales to value of the index i
				highestSales = salesList.get(i);
		}
		
		// Set the highestSales to class value
		this.highestSales = highestSales;
	}

	/**
	 * method printResultes
	 * print the highest sales and salesman
	 * and other salesman's sales
	 */
	// method that print the result
	public void printResultes() {
		
		// print out the averageSlaes, highestSales and the salesman who records the highest sales.
		System.out.println("\nAverage sales per associate is $" + this.averageSales);
		System.out.println("The highest sales figure is $" + this.highestSales);
		System.out.println("\n\nThe following had the highest sales: ");
		
		// Until finish the array list, compare sales list with highestSales
		for(int i=0; i<salesList.size(); i++) {
			// check value of the salesList's index i is same highestSales
			if(salesList.get(i) == highestSales) {
				// print out the value of index i in nameList and saleList
				System.out.println("* Name: " + nameList.get(i));
				System.out.println("* Sales: $" + salesList.get(i));
				// If value of the salesList's index i is same averageSales
				if(salesList.get(i) == averageSales)
					// print out the sentence showing that the two values are the same
					System.out.println("* Equal to the average.\n");
				else
					// print out the sentence showing the value is bigger than averageSales
					System.out.println("* " + (salesList.get(i) - averageSales)+" above the average.");
			}
		}
		
		System.out.println("\nThe rest performed as follows: ");
		
		// Until finish the array list, compare getmSales with highestSales
		for (int i=0; i<salesList.size();i++) {
			// If the value of index i in salseList isn't same highestSales (other salesman)
			if(salesList.get(i) != highestSales) {
				// print out the the value of index i in nameList and saleList
				System.out.println("* Name: " + nameList.get(i));
				System.out.println("* Sales: $" + salesList.get(i));
				// If the value of index i in salseList is bigger than averageSales
				if (salesList.get(i) > averageSales)
					// print out the sentence showing the value is bigger than averageSales
					System.out.println("* " + (salesList.get(i) - averageSales)+" above the average.\n");
				// If the value of index i in salseList is same averageSales
				else if(salesList.get(i) == averageSales)
					// print out the sentence showing that the two values are the same
					System.out.println("* Equal to the average.\n");
				// If the value of index i in salseList is smaller than averageSales
				else
					// print out the sentence showing the value is smaller than averageSales
					System.out.println("* " + (averageSales - salesList.get(i))+" below the average.\n");
			}
		}
	}
}
