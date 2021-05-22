package com.nit.jdbc;
/*
  CREATE TABLE  "STUDENT" 
   (	"SNO" NUMBER NOT NULL ENABLE, 
	"SNAME" VARCHAR2(20 BYTE), 
	"COLUMN1" VARCHAR2(20 BYTE), 
	"COLUMN2" FLOAT(126)
   );
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest_Oracle{

	public static void main(String[] args)throws Exception {
		//load jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM", "SYSTEM");
		//create statement obj
		Statement st=con.createStatement();
		//prepare sql query
		String QUERY="SELECT * FROM STUDENT";
		ResultSet rs=st.executeQuery(QUERY);
		//process the record
		while(rs.next()) {
			System.out.println("sno ="+rs.getInt(1)+"\t  Sname :"+rs.getString(2)+"\t  Adress :"+rs.getString(3)+"\t Avrage :"+rs.getFloat(4));
		   }//while
		//close objs
		rs.close();
		st.close();
		con.close();

	}//main
}//class
