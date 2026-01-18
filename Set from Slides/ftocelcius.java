import java.util.Scanner;
import java.text.DecimalFormat;

class ftocelcius{
	public static void main(String[] args){
		System.out.print("Enter temperature in Fahrenheit: ");
		Scanner ftemperature = new Scanner(System.in);
		double fahrenheit = ftemperature.nextDouble();

		double celcius = 5.0/9.0 * (fahrenheit - 32); //5 and 9 were int but subtracting int from double gives a double
		
		DecimalFormat df = new DecimalFormat("0.00");

		System.out.println("That equals "+df.format(celcius) +" Celsius.");

		String output = String.format("That equals %.2f Celsius.", celcius); //f for double, d for int, s for strings
	
		System.out.println(output);
	}
}
