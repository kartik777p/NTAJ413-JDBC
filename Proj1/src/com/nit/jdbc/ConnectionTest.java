package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

	public static void main(String[] args) throws Exception {
		//load oracle driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","SYSTEM");
            //check conn Established or not
				if(con!=null) {
					System.out.println("Connection Established Sucessfully :-");
				}
				else
					System.out.println(" COnnection not Established  :");
		//close the connection
		con.close();
	}

}
