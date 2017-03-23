package test;

import java.util.Scanner;

public class Elephant {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(),total=0;
		total = n/5;
		if(n%5>0)total++;
		System.out.println(total);
		
	}
}
