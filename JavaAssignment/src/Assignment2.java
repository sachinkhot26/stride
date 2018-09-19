
import java.util.HashMap;
import java.util.Scanner;


public class Assignment2 {

	public static void main(String[] args) {
		System.out.println("Enter a number");
		Scanner scn= new Scanner(System.in);
		int number = scn.nextInt();
	    
		HashMap map = new HashMap();
		
		for(int i=1;i<=number;i++) {
			map.put(i, i*i);
		}
		System.out.println(map.toString().replaceAll("=",":"));
		
	}

}
