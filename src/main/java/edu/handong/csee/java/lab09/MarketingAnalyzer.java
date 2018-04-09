package edu.handong.csee.java.lab09;

// Insert Scanner
import java.util.Scanner;
// Insert Salesman class
import edu.handong.csee.java.lab09.Salesman;

/**
 * class MarketingAnalyzer
 * there are three variables and four methods.
 * 
 * @author smile
 *
 */
public class MarketingAnalyzer {
	
	// define class private variable
	private Salesman[] team; // Array containing salesman information
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
		// get number of salesman from user
		System.out.print("Enter the number of salesman: ");
		// Create an object of the Scanner
		Scanner keyboard = new Scanner(System.in);
		// save the entered number as numOFSalesman
		int numOFSalesman = keyboard.nextInt();
		
		// define an array Salesman having numOFSales index units.
		team = new Salesman[numOFSalesman];

		// Get each salesman's information until the numOFSalesman is finished.
		for(int i=0; i < numOFSalesman; i++) {

			// Get the (i+1)th salseman's information (name and sales)
			System.out.println("\nEnter data for associate number " + (i+1));
			
			System.out.print("Enter name of sales associate: ");
			// Receive all entered strings by name
			String name = keyboard.nextLine();
			name = keyboard.nextLine();

			System.out.print("Enter associate's sales: $");
			// Receive entered number by sales
			double sales = keyboard.nextDouble();
			
			// Place the salesman in the i-th array.
			team[i] = new Salesman();
			// put salesman's name in mName of i-th array
			team[i].setmName(name);
			// put salesman's sales in mSales of i-th array
			team[i].setmSales(sales);			
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
		
		// Until finish the array, add the sales to sum
		for(int i=0; i < team.length; i++) {
			// add the sales of team[i] to sum
			sum = sum + team[i].getmSales();
		}
		
		// divide the sum to team.length and put this value into averageSales
		this.averageSales = sum/team.length;
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
		
		// Until finish the array, compare highestSales with team[i].getmSales
		for(int i=0; i<team.length; i++) {
			// If team[i].getmSales is greater than highestSales
			if(highestSales < team[i].getmSales())
				// set the highestSales to team[i].getmSales
				highestSales = team[i].getmSales();
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
		
		// Until finish the array, compare getmSales with highestSales
		for(int i=0; i<team.length; i++) {
			// If team[i].getSales is same highestSales
			if(team[i].getmSales() == highestSales) {
				// print out the team[i]'s name and sales
				System.out.println("* Name: " + team[i].getmName());
				System.out.println("* Sales: $" + team[i].getmSales());
				// If team[i].getSales is same averageSales
				if(team[i].getmSales() == averageSales)
					// print out the sentence showing that the two values are the same
					System.out.println("* Equal to the average.\n");
				else
					// print out the sentence showing team[i].getSales is bigger than averageSales
					System.out.println("* " + (team[i].getmSales() - averageSales)+" above the average.");
			}
		}
		
		System.out.println("\nThe rest performed as follows: ");
		
		// Until finish the array, compare getmSales with highestSales
		for (int i=0; i<team.length;i++) {
			// If team[i].getSales isn't same highestSales (other salesman)
			if(team[i].getmSales() != highestSales) {
				// print out the team[i]'s name and sales
				System.out.println("* Name: " + team[i].getmName());
				System.out.println("* Sales: $" + team[i].getmSales());
				// If team[i].getSales is bigger than averageSales
				if (team[i].getmSales() > averageSales)
					// print out the sentence showing team[i].getSales is bigger than averageSales
					System.out.println("* " + (team[i].getmSales() - averageSales)+" above the average.\n");
				// If team[i].getSales is same averageSales
				else if(team[i].getmSales() == averageSales)
					// print out the sentence showing that the two values are the same
					System.out.println("* Equal to the average.\n");
				// If team[i].getSales is smaller than averageSales
				else
					// print out the sentence showing team[i].getSales is smaller than averageSales
					System.out.println("* " + (averageSales - team[i].getmSales())+" below the average.\n");
			}
		}
	}
}
