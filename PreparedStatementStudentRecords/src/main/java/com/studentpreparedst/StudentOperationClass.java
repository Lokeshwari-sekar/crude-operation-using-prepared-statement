package com.studentpreparedst;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentOperationClass 
{
	static Connection scon=null;
	static PreparedStatement pst=null;
	static ResultSet rs=null;
	static  Scanner sc=new Scanner(System.in);

	//display all students records
	public static void diaplayStudentDetails()//all details display 
	{

		try {
			scon=DbconnectClass.getConnection();
			String sql="select * from studentdetail";
			pst=scon.prepareStatement(sql);
			rs=pst.executeQuery();
			System.out.println("id\tname\tplace");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t");
			}

		} catch (Exception e) 
		{

			e.printStackTrace();
		}
	}

	//insert record with new id
	public static void InsertStudentDetails() 
	{

		try {
			scon=DbconnectClass.getConnection();
			String sql="select * from studentdetail where id=?";
			pst=scon.prepareStatement(sql);
			System.out.println("Enter id");
			int id=sc.nextInt();
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(!rs.next())
			{System.out.println("Enter name");
			String n=sc.next();
			System.out.println("Enter place");
			String c=sc.next();
			String sqlch="insert into studentdetail values(?,?,?)";
			pst=scon.prepareStatement(sqlch);
			pst.setInt(1, id);
			pst.setString(2, n);
			pst.setString(3, c);
			int i=pst.executeUpdate();
			if(i>0)
			{
				System.out.println("updated");
			}
			}
			else
			{
				System.out.println("already id is exists");
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}	

	//update student records
	public static void UpdateStudentDetails() {
		System.out.println("Enter id to update record");
		int id=sc.nextInt();
		try {

			scon=DbconnectClass.getConnection();
			String sel="select * from studentdetail where id=?";
			pst=scon.prepareStatement(sel);
			pst.setInt(1, id);
			rs=pst.executeQuery();

			if(rs.next()) {
				System.out.println("Which field you want to update");
				System.out.println("1.to update name");
				System.out.println("2.to update place");
				System.out.println("3.to update name and place");

				int choice=sc.nextInt();

				switch(choice) {
				case 1:System.out.println("Enter the name to change");
				String n=sc.next();
				String cn="update studentdetail set name=? where id=?";
				pst=scon.prepareStatement(cn);
				pst.setString(1, n);
				pst.setInt(2, id);
				int i=pst.executeUpdate();

				if(i>0) {
					System.out.println("Name is changed");
				}
				break;
				case 2:System.out.println("Enter the place to change");
				String c=sc.next();
				String csql="update studentdetail set place=? where id=?";
				pst=scon.prepareStatement(csql);
				pst.setString(1, c);
				pst.setInt(2, id);
				int j=pst.executeUpdate();

				if(j>0) {
					System.out.println("course is changed");
				}
				break;
				case 3:System.out.println("Enter name ");
				String un=sc.next();
				System.out.println("Enter course name ");
				String couch=sc.next();

				String cnchange="update studentdetail set name=?, place=? where id=?";
				pst = scon.prepareStatement(cnchange);
				pst.setString(1, un);
				pst.setString(2, couch);
				pst.setInt(3, id);
				int k=pst.executeUpdate();
				if(k>0) {
					System.out.println("Name and course is changed");
				}

				}
			}else {
				System.out.println(id+" not exists");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
//delete student record
	public static void deleteStudentDetails() {

		try {
			scon=DbconnectClass.getConnection();
			String sql="select * from studentdetail where id=?";
			pst=scon.prepareStatement(sql);
			System.out.println("Enter id");
			int id=sc.nextInt();
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next())
			{ 

				String sqlch="delete from studentdetail where id=?";
				pst=scon.prepareStatement(sqlch);
				pst.setInt(1, id);

				int i=pst.executeUpdate();
				if(i>0)
				{
					System.out.println("deleted");
				}
			}
			else
			{
				System.out.println(" id is not exists");

			}}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}	

public static void diaplaySingleStudentDetails() {
		try {
				scon=DbconnectClass.getConnection();
				String sql="select * from studentdetail where id=?";
				pst=scon.prepareStatement(sql);
				System.out.println("Enter id");
				int id=sc.nextInt();
				pst.setInt(1, id);
				rs=pst.executeQuery();
				if(rs.next())
				{ 
					String sqlch="select * from studentdetail where id=?";
					pst=scon.prepareStatement(sqlch);
					pst.setInt(1, id);
					rs=pst.executeQuery();
					while(rs.next())
					{
						System.out.println("id\tname\tplace");
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t");
					}
				}}
			catch (Exception e)
			{
				e.printStackTrace();
			}
}}


