/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #28: PS3_Ex28_Friendship.java
 * 
 * 2D array that can represent social connections
 * 
 * Soh Li Min
 */

import java.util.*;
import java.util.stream.IntStream;

class Friendship {
  
  	public static void main(String[] args) {
    		Scanner s = new Scanner(System.in);
    		System.out.print("Read in the number of users: ");
    		int users = s.nextInt();
		int maxIndex = users - 1; 
    		System.out.println("There are " + users + " users, indexed from 0 to " + maxIndex + ".");
		
		int[][] iLink = new int[users][users];
    		for (int i = 0 ; i < users; i++) {
			iLink[i][i] = 1;
		}
		System.out.print("Enter the number of pairs of direct friends: ");
    		int friendPairs = s.nextInt();
   		
    		System.out.println("Enter " + friendPairs + " pairs of direct friends:");
		for (int i = 0; i < friendPairs; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			iLink[a][b] = 1;
			iLink[b][a] = 1;
		}
		
    		System.out.println("The friendship matrix is: ");    
    		format(iLink);
		iSolitude(iLink);
		uFriend(iLink);	
  	}

	public static int[][] format(int[][] table) {
		System.out.println(Arrays.deepToString(table)
                                .replace("], [", "\n")
                                .replace(", ", " ")
                                .replace("[[", "")
                                .replace("]]", ""));
		return table;
	}

	//outputs a list of lonely autists
	public static void iSolitude(int[][] table) {
		
		int[] fwens = new int[table.length];
	
		for (int i = 0; i < table.length; i++) {
			int friends = IntStream.of(table[i]).sum(); 	//summing each row, gives total no of friends per user in new array
			fwens[i] = friends; 				//already ordered by user	
		}
		System.out.println("The least number of friends found is " + fwens[0]);
		List<Integer> lonelyUsers = new ArrayList<>();		//ArrayList to store...
		for (int i = 0; i < fwens.length; i++) {
			if (fwens[i] == fwens[0]) {			//...users with the minumum no of friends
				lonelyUsers.add(i); 			//no need for another Array for indices
			}
		}
		Collections.sort(lonelyUsers);				//sort their "id" in ascending order
		for (int u :lonelyUsers) {
			System.out.println("User " + u + " has the least number of friends.");
		}
	}

	public static void uFriend(int[][] table) {
		List<int[]> fofPairs = friendOfFriends(table);
			
		for (int[] pair : fofPairs) {
			String string = Arrays.toString(pair);
			System.out.println("Users " + string + " have a friend-of-friend relation.");
		}
	}

	public static List<int[]> friendOfFriends(int[][] table) {
		List<int[]> fof = new ArrayList<int[]>();
		for (int i = 0; i < table.length; i++) {
			for (int j = i + 1; j < table[i].length; j++) { // prevents duplicates cause by symmetry of matricx
				if (table[i][j] == 0 && table[j][i] == 0) { // if 2 users are NOT direct friends
					if (friendsWithSamePerson(table, i, j)){
						
						int[] pea = new int[2];
						pea[0] = i;
				       		pea[1] = j;	
						fof.add(pea);

					}
				}
			}
		}
		return fof;	
	}

	public static boolean friendsWithSamePerson(int[][] table, int a, int b) {
		for (int i = 0; i < table.length; i++) {
			if(table[a][i] == 1 && table[b][i] == 1) {
				return true;
			}
		}
		return false;
	}
}
