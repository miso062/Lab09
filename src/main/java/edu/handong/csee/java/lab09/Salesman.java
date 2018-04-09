package edu.handong.csee.java.lab09;

/**
 * class Salesman
 * get the salesman's name and sales
 * set the salesman's name and sales
 * 
 * @author smile
 *
 */
public class Salesman {

	// define class variable
	public String mName; // salesman's name
	public double mSales; // salesman's sales

	/**
	 * method getmName
	 * get the salesman's name
	 * 
	 * @return
	 */
	public String getmName() {
		// return the salesman's name
		return mName;
	}
	
	/**
	 * method setmName
	 * set the salesman's name
	 * 
	 * @param name
	 */
	public void setmName(String name) {
		// set the entered string into salesman's name
		this.mName = name;
	}

	/**
	 * method getmSles
	 * get the salesman's sales
	 * 
	 * @return
	 */
	public double getmSales() {
		// return the salesman's sales
		return mSales;
	}
	
	/**
	 * method setmSales
	 * set the salesman's sales
	 * 
	 * @param sales
	 */
	public void setmSales(double sales) {
		// set the entered number into salesman's sales
		this.mSales = sales;
	}

}
