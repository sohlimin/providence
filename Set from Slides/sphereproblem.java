import java.util.Scanner;
import java.text.DecimalFormat; //import this if u are using it

class sphereproblem {
	public static void main(String[] args){ //stop pluralising your String
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter diameter: ");
		double rad = 0.5 * sc.nextDouble(); //nextDouble is a method ,telling sc to take in next input as a double
		double vol = (4.0/3.0) * Math.pow(rad,3) * Math.PI;
		double surfacearea = 4.0 * Math.pow(rad,2) * Math.PI;
	 	System.out.println(String.format("Area = %.3f", surfacearea)); //you werent using String.format() yourself, put a fullstop between % and number of decimal places, 
									       //site: baeldung string format d f s
		DecimalFormat df = new DecimalFormat("0.000");//REMEmBER LIMIN, this is basically oop (interaction between objects)
		System.out.println("Volume = " + df.format(vol));//passed in param vol to df's format method, and format returns a string with desired format 
	}
}	
