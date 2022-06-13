package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class CallableDemo {

	public static void main(String[] args) throws Exception {
				Class.forName("com.mysql.cj.jdbc.Driver");//"com.mysql.jdbc.Driver"
				
				Connection con=
				DriverManager.getConnection("jdbc:mysql://localhost:3307/cbs1", "root", "root");
				
				CallableStatement cst=con.prepareCall("CALL sqr(?,?)");
				System.out.println("enter x  ");
				Scanner sc=new Scanner(System.in);
				int id=sc.nextInt();
				cst.setInt(1, id);
				cst.registerOutParameter(2, Types.INTEGER);
				cst.execute();
				System.out.println(cst.getInt(2));
				

	}

}
