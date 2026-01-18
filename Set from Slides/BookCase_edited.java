import java.util.Scanner;

class BookCase {
	public static void main(String[] args){
		System.out.print("Key your score:");
		
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		String output;

		if (score > 100 || score < 0) {
		       output = "Your score is invalid! Key your score again: ";
		} else if (score < 50) {
			output = "U";
		} else if (score < 55) {
			output = "E";
		} else if (score < 60) {
			output = "D";
		} else if (score < 65) {
			output = "C";
		} else if (score < 70) {
			output = "B";
		} else {
			output = "A";
		}
		
		System.out.println(output);
	}
}


