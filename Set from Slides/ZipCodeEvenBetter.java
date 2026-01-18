import java.util.Scanner;


class ZipCodeEvenBetter {
	
	private static boolean checkValidity(String zipcode) {
		// early returns substitute for break statements
		if (zipcode.length() != 6) {				// if length is wrong, return false immediately
			return false;
		} else {
			for (int i = 0; i < zipcode.length(); i++) { 	// iterate over all characters in a String - length() accesses the length of the String
				char toCheck = zipcode.charAt(i);	// access individual character
				int ascii = (int) toCheck;		// cast character to int - 48 corresponds to '0', 57 corresponds to '9'
				if (ascii < 48 || ascii > 57) {		// if character is invalid, return false early
					return false;
				}
			}
		}
		return true;
	}
	
	// Extracts first character of a valid string and returns its region
	private static String getRegion(String zip) {
		// break statements are omitted because return statements implicitly break execution
		// This allows for early returns to substitute for break statements
		
		char c = zip.charAt(0); // extract first character from String zip

		switch(c) {					
			case '0': case '1': case '2': case '3':		// cases that have the same outcome can be grouped together like this
				return "is on the East Coast.";
i			case '4': case '5': case '6':
				return "is in the Central Plains area.";
			case '7':
				return "is in the South.";
			case '8': case '9':
				return "is in the West.";
			default:
				return "is an invalid ZIP Code - this should never be triggered";
		}
		
		//return "is an invalid ZIP Code - this should never be triggered";

		// we don't have to have a return at the end here because the default statement handles all non-matching cases
		// The compiler is fine with this
	}

	public static void main(String[] args){
		System.out.print("Enter a ZIP Code:");
		Scanner sc = new Scanner(System.in);
		String zip = sc.next(); //next() used to get input as a String
		String region;
		
		boolean isValid = checkValidity(zip);
		
		if (!isValid) { 
			region = "is an invalid ZIP Code.";
		} else {
			region = getRegion(zip);	
		}
		System.out.println(zip + " " + region);
	}
} 
