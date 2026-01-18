import java.util.Scanner;


class ZipCode {
	public static void main(String[] args){
		System.out.print("Enter a ZIP Code:");
		Scanner sc = new Scanner(System.in);
		int zip = sc.nextInt();
		int firstnumber = zip / 100000;
		String region;// Caps 
		switch (firstnumber) {
			case 0: case 1: case 2: case 3:
				region = "is on the East Coast";
				break;

			case 4: case 5: case 6:
				region = "is in the Central Plains area.";
				break;

			case 7:
				region = "is in the South.";
				break;

			case 8: case 9:
				region = "is in the West.";
				break;
			default:
				region = "is an invalid ZIP Code.";
		}
		System.out.println(zip + " " + region);
	}
} // take as string, check string length  or check first character charAt(integer) (take look at string API)
