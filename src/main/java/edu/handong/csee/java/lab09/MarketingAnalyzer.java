package edu.handong.csee.java.lab09;

import java.util.Scanner;
import edu.handong.csee.java.lab09.Salesman;

public class MarketingAnalyzer {
	
	private Salesman[] team;
	private double highestSalse;
	private double averageSalse;
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		Salesman salesman = new Salesman();
		MarketingAnalyzer marketingAnalyzer = new MarketingAnalyzer();

		marketingAnalyzer.getData();
		marketingAnalyzer.computeAverage();
		marketingAnalyzer.computeHighestSalse();
		marketingAnalyzer.printResultes();
	}
	
	public void getData()
	{
		System.out.print("Enter the number of salesman: ");
		Scanner keyboard = new Scanner(System.in);
		
		int numOFSalesman = keyboard.nextInt();
		
		team = new Salesman[numOFSalesman];
				
		for(int i=0; i < numOFSalesman; i++) {

			System.out.println("\nEnter data for associate number " + (i+1));
			
			System.out.print("Enter name of sales associate: ");
			String name = keyboard.nextLine();
			name = keyboard.nextLine();

			team[i] = new Salesman();
			team[i].setmName(name);
			
			System.out.print("Enter associate's sales: $");
			double sales = keyboard.nextDouble();
			team[i].setmSales(sales);			
		}
	}

	public void computeAverage() {
		
		double sum = 0;
		
		for(int i=0; i < team.length; i++) {
			sum = sum + team[i].getmSales();
		}
		
		averageSalse = sum/team.length;
	}	
	
	public void computeHighestSalse() {
		
		double highestSalse = 0;
		
		for(int i=0; i<team.length; i++) {
			if(highestSalse < team[i].getmSales())
				highestSalse = team[i].getmSales();
		}
		
		this.highestSalse = highestSalse;
	}

	public void printResultes() {
		
		System.out.println("\nAverage sales per associate is $" + this.averageSalse);
		System.out.println("The highest sales figure is $" + this.highestSalse);
		System.out.println("\n\nThe following had the highest sales: ");
		
		for(int i=0; i<team.length; i++) {
			if(team[i].getmSales() == highestSalse) {
				System.out.println("* Name: " + team[i].getmName());
				System.out.println("* Sales: $" + team[i].getmSales());
				if(team[i].getmSales() == averageSalse)
					System.out.println("* Equal to the average.\n");
				else
					System.out.println("* " + (team[i].getmSales() - averageSalse)+" above the average.");
			}
		}
		
		System.out.println("\nThe rest performed as follows: ");
		
		for (int i=0; i<team.length;i++) {
			if(team[i].getmSales() != highestSalse) {
				System.out.println("* Name: " + team[i].getmName());
				System.out.println("* Sales: $" + team[i].getmSales());
				if (team[i].getmSales() > averageSalse)
					System.out.println("* " + (team[i].getmSales() - averageSalse)+" above the average.\n");
				else if(team[i].getmSales() == averageSalse)
					System.out.println("* Equal to the average.\n");
				else
					System.out.println("* " + (averageSalse - team[i].getmSales())+" below the average.\n");
			}
		}
	}
}
