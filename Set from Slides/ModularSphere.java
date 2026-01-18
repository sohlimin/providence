import java.util.Scanner;
import java.text.DecimalFormat; //import this if u are using it

class ModularSphere {
	public static void main(String[] args){ //stop pluralising your String
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter diameter: ");
		double rad = 0.5 * sc.nextDouble(); //nextDouble is a method ,telling sc to take in next input as a double
		
		//double vol = (4.0/3.0) * Math.pow(rad,3) * Math.PI;
		double vol = calcVolume(rad);

		//double surfacearea = 4.0 * Math.pow(rad,2) * Math.PI;
	 	double area = calcSurface(rad);
		System.out.println(String.format("Area = %.3f", area)); //you werent using String.format() yourself, put a fullstop between % and number of decimal places, 
									       //site: baeldung string format d f s
		DecimalFormat df = new DecimalFormat("0.000");//REMEmBER LIMIN, this is basically oop (interaction between objects)
		System.out.println("Volume = " + df.format(vol));//passed in param vol to df's format method, and format returns a string with desired format 
	}
	
	// calculate volume of a sphere given its radius
	// input: double
	// output: double
	private static double calcVolume(double radius) {
		double volume = 4.0/3.0 * Math.PI * Math.pow(radius, 3);
		return volume;
	}

	public static double calcSurface(double radius){
		double area = 4.0 * Math.pow(radius,2) * Math.PI;
		return area;
	}
}	
