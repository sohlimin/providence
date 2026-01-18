import java.util.Scanner;

public int findQtyVowels (String s) {
	int vowelCount = 0;
	for (int i = 0; i < s.length(); i++) {
		int x = toUnicode(s.charAt(i));
		if (isVowel(x)) {
			vowelCount++;
		}
	} 
	return vowelCount;
}	

public int toUnicode(char c) {
	int uni = (int) c;
	return uni;
}	

public boolean isVowel(int uni){
	
//AEIOU aeiou is 65 69 73 79 85   97 101 105 111 117

	switch (uni) {
		
		case 65 : case 69 : case 73 : case 79 : case 85 : case 97 : case 101 : case 105 : case 111 : case 117:
		      	return true;
	      	
		default	:
			return false;      
	}
}



void main(){
 	Scanner sc = new Scanner(System.in);
	System.out.print("Enter a string: ");
	String str = sc.nextLine();
	int noOfV = findQtyVowels(str);
	System.out.println("Number of vowels: " + noOfV);
}
