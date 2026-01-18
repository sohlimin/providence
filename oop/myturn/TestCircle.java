import java.util.Scanner;

class TestCircle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Circle cir1 = readCircle(scanner);
		Circle cir2 = readCircle(scanner);
	
	//	toString(Circle circle) {
	//		return "[" + r + " , " + c + "]"; 	
	//	}
	
		System.out.println("Circle 1:" + cir1);
		System.out.println("Circle 2:" + cir2);
	
		if(cir1.equals(cir2)) {
			System.out.println("Circle 1 and circle 2 are identical.");
		}

		cir1.enlarge();
		System.out.println("Circle 1:" + cir1);
	}

	public static Circle readCircle(Scanner sc) {
	
       		System.out.print("Enter radius: ");
		int r = sc.nextInt();
		System.out.print("Enter colour: ");
		String c = sc.next();
		return new Circle(r, c);
	}	
}	
