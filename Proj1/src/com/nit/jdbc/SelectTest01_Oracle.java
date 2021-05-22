package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
 * emp table empno,ename,job,sal
 */

public class SelectTest01_Oracle {

	public static void main(String[] args) throws Exception {
		//load jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//get connection obj
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","SYSTEM");
       //create statement obj
		Statement st=con.createStatement();
		//prepare SQL query here
		 //select empno,ename,job,sal from emp;
		String QUERY="SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
		//send and exicute query in DB sw
		ResultSet rs=st.executeQuery(QUERY);
		//process the record 
		while(rs.next()) {
			System.out.println("EMPNO :- "+rs.getInt(1)+" \t ENAME :- "+rs.getString(2)+" \t JOB :- "+rs.getString(3)+" \t SAL :-"+rs.getFloat(4));
		}
		//close jdbc objs here
		rs.close();
		st.close();
		con.close();
	}//main
}//class
