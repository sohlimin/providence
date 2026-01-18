import java.util.Scanner;

class BookCase {
	public static void main(String[] args){
		System.out.print("Key your score:");
		
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		if (score > 100 || score < 0) {
		       System.out.println("Your score is invalid! Key your score again: ");
		} else if (score < 50) {
			System.out.println("U");
		} else if (score < 55) {
			System.out.println("E");
		} else if (score < 60) {
			System.out.println("D");
		} else if (score < 65) {
			System.out.println("C");
		} else if (score < 70) {
			System.out.println("B");
		} else {
			System.out.println("A");
		}
	}
}


