import java.util.Scanner;


class ZipCodeBetter {
	
	private static boolean checkValidity(String zipcode) {
		boolean isValid = true;

		if (zipcode.length() != 6) {
			isValid = false;
		} else {
			for (int i = 0; i < zipcode.length(); i++) {
				char toCheck = zipcode.charAt(i);
				int ascii = (int) toCheck;
				if (ascii < 48 || ascii > 57) {
					isValid = false;
					break;
				}
			}
		}
		return isValid;
	}


	public static void main(String[] args){
		System.out.print("Enter a ZIP Code:");
		Scanner sc = new Scanner(System.in);
		String zip = sc.next(); //next() used to get input as a String
		String region;
		
		boolean isValid = checkValidity(zip);
		
		// Input Validation
		if (!isValid) {
			region = "is an invalid ZIP Code.";
		} else {
			char firstnumber = zip.charAt(0);
		
			switch (firstnumber) {
				case '0':
				case '1':
				case '2':
				case '3':
					region = "is on the East Coast";
					break;
	
				case '4':
				case '5':
				case '6':
					region = "is in the Central Plains area.";
					break;

				case '7':
					region = "is in the South.";
					break;

				case '8':
				case '9':
					region = "is in the West.";
					break;
				default:
					region = "is an invalid ZIP Code.";
			}
		}
		System.out.println(zip + " " + region);
	}
} // take as string, check string length  or check first character charAt(integer) (take look at string API)
