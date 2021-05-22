package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class selectTest02_Oracle {

	public static void main(String[] args)throws Exception {
		//gather data from endduser
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Minimum value :- ");
		float minValue=sc.nextFloat();
		System.out.println("Enter Maximum value :-");
		float maxValue=sc.nextFloat();
		//load driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","SYSTEM");
		//create statemrnt obj
		Statement st=con.createStatement();
		//preapare query here
		          //select empno,ename,job,sal from emp where sal>=2000 And sal<=5000;
       String QUERY="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL>="+minValue+" AND SAL<="+maxValue ;
       //send and exicute query in Db sw
       ResultSet rs=st.executeQuery(QUERY);
       //process rs result
       while(rs.next()) {
    	   System.out.println("EmpNo :- "+rs.getInt(1)+" \t  Ename :- "+rs.getString(2)+" \t  \t Job :- "+rs.getString(3)+" \t \t SAL :- "+rs.getFloat(4));
       }
       //close jdbc connections
       rs.close();
       st.close();
       con.close();
       sc.close();
	}//main
}//class
