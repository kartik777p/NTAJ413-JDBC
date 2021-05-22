package com.nit.jdbc;
/*
  CREATE TABLE `ntaj415db`.`student` (
  `sno` INT NOT NULL,
  `sname` VARCHAR(20) NULL,
  `saddrs` VARCHAR(20) NULL,
  `avrg` FLOAT NULL);
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest_MYSQL{

	public static void main(String[] args)throws Exception {
		//load jdbc driver
		//Class.forName("com.mysql.jdbc.Driver"); //deprected
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish the connection
		Connection con=DriverManager.getConnection("jdbc:mysql:///NTAJ415DB","root", "root");
		//create statement obj
		Statement st=con.createStatement();
		//prepare sql query
		String QUERY="SELECT * FROM STUDENT";
		ResultSet rs=st.executeQuery(QUERY);
		//process the record
		while(rs.next()) {
			System.out.println("sno ="+rs.getInt(1)+"\t  \t Sname :"+rs.getString(2)+"\t    \t   Adress :"+rs.getString(3)+"\t \t Avrage :"+rs.getFloat(4));
		   }//while
		//close objs
		rs.close();
		st.close();
		con.close();

	}//main
}//class
