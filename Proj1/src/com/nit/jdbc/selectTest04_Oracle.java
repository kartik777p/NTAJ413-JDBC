//write a JDBC program to dept details from DEPT table based on given dept number range
/*
 
 */
package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class selectTest04_Oracle {

	public static void main(String[] args) throws Exception{
		//gather data from enduser
		Scanner sc=new Scanner(System.in);
		System.out.println(" Enter Min DeptNo :-");
		int minDeptNo=sc.nextInt();
		System.out.println(" Enter Max DeptNo :-");
		int maxDeptNo=sc.nextInt();
		//load jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//established the conn
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","SYSTEM");
       //create statement to send and exdcute query
		Statement st=con.createStatement();
		 // prepare sql Query here
		          //select deptno,dname,loc from dept where deptno>=20 and deptno<=50;
		String QUERY="SELECT DEPTNO,DNAME,LOC from DEPT WHERE DEPTNO>="+minDeptNo+" AND DEPTNO<="+maxDeptNo;
	//execute query
		ResultSet rs=st.executeQuery(QUERY);
		//process the resultset
		while(rs.next()) {
			System.out.println("DeptNo :-"+rs.getInt(1)+" \t  \tDname :-"+rs.getString(2)+" \t  \tLoc :-"+rs.getString(3));
		}
		//close jdbc obj here
		rs.close();
		st.close();
		con.close();
		sc.close();
	}

}
