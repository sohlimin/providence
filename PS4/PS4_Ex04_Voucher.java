/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #04: PS4_Ex04_Voucher.java
 * 
 * A voucher has three attributes: name (word),
 * face value (int) and amount of vouchers (int)
 * 
 *Soh Li Min
 */

class Voucher {
  
  	// Attributes
	private String name;
  	private int faceValue;
 	private int amountOfVouchers;
	
	// Constructor
 	public Voucher(String voucherName, int voucherValue, int voucherAmt) {
    		this.name = voucherName;
		this.faceValue = voucherValue;
		this.amountOfVouchers = voucherAmt;    
  	}
  
  	// Return name of a voucher
	public String getName() {
		return this.name;
  	}
  
	// Return face value of a voucher
	public int getValue() {
    		return this.faceValue; 
  	}
  
  	// Return the number of vouchers
  	public int getAmt() {
    		return this.amountOfVouchers; 
 	}
  
  	// Compute the number of vouchers to use given a price such that there is no overpay
  	public int useVoucher(int price) {
    		if (price > this.faceValue) {
			return  price / this.faceValue;
		} else {
			return 0;
		}
	}


  }
