/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #25: PS1_Ex25_Packing.java
 * 
 * Soh Li Min
 */

import java.util.Scanner;

class Packing {
  
  	public static void main(String[] args) {
    
    		Scanner s = new Scanner(System.in);
    	
    		System.out.print("Enter size of tray: ");
    		int hTray = s.nextInt();
		int wTray = s.nextInt();
    
    		System.out.print("Enter size of slab: ");
    		int hSlab = s.nextInt();
    		int wSlab = s.nextInt();
    		int areaTray = hTray * wTray;	
		int area1 = findPackingArea(hTray, wTray, hSlab, wSlab);
		int area2 = findPackingArea(hTray, wTray, wSlab, hSlab);
		int minUnusedArea = areaTray - Math.max(area1, area2);
    		System.out.println("Minimum unused area = " + minUnusedArea);
	
	}

	public static int findPackingArea(int hTray, int wTray, int hSlab, int wSlab) {
		int rowsFit = hTray / hSlab;
		int colsFit = wTray / wSlab;
		int areaFit = rowsFit * hSlab * colsFit * wSlab;
		return areaFit;
	}
}
