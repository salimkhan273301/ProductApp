package com.pms.dbcon;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DbConn {
	 private static final Logger logger = Logger.getLogger("DatabaseConnction.class");
	
	public static Connection getConnection() throws ClassNotFoundException,SQLException,IOException
	{
		logger.info("Connection is going to be Stablish with database");
		
		
        Class.forName("com.mysql.cj.jdbc.Driver");//"com.mysql.jdbc.Driver"
		
		//2 creating connection
		
        Connection con=DriverManager.getConnection(  
        		"jdbc:mysql://localhost:3306/data1","root","12345");  
        
		logger.info("connected successfully.......");
		return con;
	}

}
