import java.util.Scanner;

class circlearea {
	public static void main(String[] args){
		System.out.println("Hey u there. Got a square in a circle? Type in the length of your square below then enter!");
		
		Scanner inputsquarelength; //declaration of a variable that hold object of type Scanner 
	        inputsquarelength = new Scanner(System.in);//assignment of new object to put into that variable (LIMIN 13 MAY: Nah, 
		
		double squarelength = inputsquarelength.nextDouble();
		
		System.out.println("We gib u the circle area now, see:");
		
		double area = squarelength*squarelength*0.5*Math.PI;
		System.out.println(area);
	}
}
