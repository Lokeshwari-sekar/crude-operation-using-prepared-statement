package com.studentpreparedst;

import java.util.Scanner;

public class MainStudentClass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("data base operations");
			System.out.println("enter your choice");
			System.out.println("1.to display student records");
			System.out.println("2.to insert student records");
			System.out.println("3.to update student records");
			System.out.println("4.to delete student records");
			System.out.println("5.to select with id student records");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:StudentOperationClass.diaplayStudentDetails();
					break;
			case 2:StudentOperationClass.InsertStudentDetails();
			        break;
			case 3:StudentOperationClass.UpdateStudentDetails();
			        break;
			case 4:StudentOperationClass.deleteStudentDetails();
			        break;
			case 5:StudentOperationClass.diaplaySingleStudentDetails();
			        break;
			default:
			        	System.out.println("please choose valid choice");
			        	break;
			
			}
			System.out.println("do you want to continue yes/no");
			String op=sc.next();
			if(op.equalsIgnoreCase("no"))
			{
				break;
			}
		}

	}

}
