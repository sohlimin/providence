import java.util.Scanner;
import java.text.DecimalFormat;

class DistancetoOrigin {
	public static void main(String[] args){
		System.out.print("Enter x- and y- coordinates: ");
		Scanner sc = new Scanner(System.in);
		double xcoord = sc.nextDouble();
		double ycoord = sc.nextDouble();
		
		//double dist = Math.sqrt(Math.pow(xcoord,2)+Math.pow(ycoord,2));
		double dist = compDist(xcoord,ycoord);

		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("Distance of ("+df.format(xcoord)+" , "+df.format(ycoord)+") to origin is "+df.format(dist));
		System.out.println(String.format("Distance of (%.2f , %.2f) to origin is %.2f", xcoord, ycoord, dist));
	}

	private static double compDist(double x, double y){
		double distance = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
		return distance;
	}
}
