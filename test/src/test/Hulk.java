package test;

import java.util.Scanner;

public class Hulk {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			if(i>0)System.out.print("that ");
			if((i+1)%2>0)System.out.print("I hate ");
			else System.out.print("I love ");
			if(i==n-1)System.out.print("it");
		}
	}
}
