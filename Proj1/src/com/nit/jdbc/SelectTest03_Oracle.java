// Write a JDBC program to getstudent details from student tablebased on the given avrg range
/*
  student (sno,sname,saddrs,avrg)
 */
package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest03_Oracle {

	public static void main(String[] args)throws Exception {
		//read data from enduser
		Scanner sc=new Scanner(System.in);
		System.out.println(" Enter Minimum Avrage :- ");
		float minAvg=sc.nextFloat();
        System.out.println(" Enter Maximun Avrage :- ");		
       float maxAvg=sc.nextFloat();
       //load jdbc driver
       Class.forName("oracle.jdbc.driver.OracleDriver");
       //establish the connection
       Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","SYSTEM");
       //create st obj
       Statement st=con.createStatement();
         //Prepare query here
                //select sno,sname,saddrs,avrg from student where avrg>=30 AND avrg<=50;
       String QUERY="SELECT SNO,SNAME,SADDRS,AVRG FROM STUDENT WHERE AVRG>="+minAvg+" AND AVRG<="+maxAvg;
	   //send and exicute query
       ResultSet rs=st.executeQuery(QUERY);
       //process the resultset
       while(rs.next()) {
    	   System.out.println("Sno :-"+rs.getInt(1)+" \t Sname :-"+rs.getString(2)+" Saddrs :-"+rs.getString(3)+" Avrg :-"+rs.getFloat(4));
       }
       //close all jdbc objs
       rs.close();
       st.close();
       con.close();
       sc.close();
	}//main
}//class
