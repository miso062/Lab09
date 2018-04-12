package edu.handong.csee.java.lab09;

// Insert HashMap, Scanner, Salesman class
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

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
	HashMap<String, Double> team = new HashMap<String, Double>(); // HashMap for salesman information
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
		team = new HashMap<>();

		Scanner keyboard = new Scanner(System.in);
		
		boolean done = false;
		int i = 0;
		
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
			
			// Check the user want to enter other salesman
			System.out.print("\nDo you want to enter other salesman? ");
			// get the user's answer
			String ans = keyboard.nextLine();
			
			// if the answer is not yes
			if(!ans.equalsIgnoreCase ("yes"))
				done = true; // change done from false to true
			
			System.out.println();
			// enter the name and sales to hashmap team
			team.put(name, sales);
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
		
		// Until finish the hash map, add the sales to sum
		for(String sales : team.keySet()) {
			sum = sum + team.get(sales);
		}
		
		// divide the sum to team size and put this value into averageSales
		this.averageSales = sum/team.size();
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
		
		// Until finish the hash map, compare highestSales with team value
		for(String curruentValue : team.keySet()) {
			// If team value is greater than highestSales
			if(highestSales < team.get(curruentValue))
				// set the highestSales to team value
				highestSales = team.get(curruentValue);
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
		
		// Until finish the hash map, compare getmSales with highestSales
		for(String key : team.keySet()) {
			// If team value is same highestSales
			if(team.get(key) == highestSales) {
				// print out the team's key and value
				System.out.println("* Name: " + key);
				System.out.println("* Sales: $" + team.get(key));
				// If team value is same averageSales
				if(team.get(key) == averageSales)
					// print out the sentence showing that the two values are the same
					System.out.println("* Equal to the average.\n");
				else
					// print out the sentence showing team value is bigger than averageSales
					System.out.println("* " + (team.get(key) - averageSales)+" above the average.");
			}
		}
		
		System.out.println("\nThe rest performed as follows: ");
		
		// Until finish the hash map, compare team value with highestSales
		for (String key : team.keySet()) {
			// If team value isn't same highestSales (other salesman)
			if(team.get(key) != highestSales) {
				// print out the team's key and value
				System.out.println("* Name: " + key);
				System.out.println("* Sales: $" + team.get(key));
				// If team value is bigger than averageSales
				if (team.get(key) > averageSales)
					// print out the sentence showing team value is bigger than averageSales
					System.out.println("* " + (team.get(key) - averageSales)+" above the average.\n");
				// If team value is same averageSales
				else if(team.get(key) == averageSales)
					// print out the sentence showing that the two values are the same
					System.out.println("* Equal to the average.\n");
				// If team value is smaller than averageSales
				else
					// print out the sentence showing team value is smaller than averageSales
					System.out.println("* " + (averageSales - team.get(key))+" below the average.\n");
			}
		}
	}
}
