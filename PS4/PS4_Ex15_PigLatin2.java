 /* and converts the it into Pig Latin.
 * Pig Latin is a language game primarily used in English.
 * It is usually used by children, who often use it to
 * converse in (perceived) privacy from adults,
 * or simply for amusement. (From Wikipedia)
 *
 * Soh Li Min
 */

import java.util.*;

class PigLatin2 {

        public static void main(String[] args) {

                System.out.print("Enter a sentence: ");
                Scanner sc = new Scanner(System.in);

                String line = sc.nextLine();
                
		String[] goo = line.split("\\s+");
		String pigL = "";
		
		for (String p : goo) {

                	pigL = pigL.concat(" " + convert(p));

		}
		
		
                System.out.println("Converted:" + pigL );

        }

  // Convert a single word.
  // For a word starting with a consonant, move that first consonant
  // to the end of the word and append "ay".
  // For a word starting with a vowel, simply append "way" to the word.
  // Return the converted word.
        public static String convert(String word) {
                //check initial letter whether if it is a vowel
                switch (word.charAt(0)) {

                        case 'A' : case 'E' : case 'I' : case 'O' : case 'U' : case 'a' : case 'e' : case 'i' : case 'o' : case 'u':

                                return word.concat("way"); //Concatenates the specified string to the end of this string.
                        default:
                                String a = Character.toString(word.charAt(0));
                                String b = word.substring(1);
                                return b.concat(a).concat("ay");
                }

        }
}
                                                      
