package com.pms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.pms.dbcon.DbConn;
import com.pms.exceptions.ProductNotFoundException;
import com.pms.model.Product;

public class ProducDaoImpl implements ProductDao{
	Scanner sc=new Scanner(System.in);
	 private static final Logger logger = Logger.getLogger("ProducDaoImpl.class");
	 public void addProduct(Product p) throws Exception {
			
	logger.info("entered into dao layed of product adding  function...");
	//productList.add(p);
	
	Connection con=DbConn.getConnection();
	PreparedStatement pst=con.prepareStatement("insert into product values(?,?,?,?)");
	Scanner sc=new Scanner(System.in);
		pst.setInt(1,p.getProductId());
		pst.setString(2,p.getProductName() );
		pst.setDouble(3, p.getQty());
		pst.setDouble(4, p.getPrice());
		pst.execute(); //insert 
		logger.info("added successfully...in db as well");
}
	 public void deleteProduct(int id) throws ClassNotFoundException, SQLException, IOException {
			logger.info("entering into deleting Function of dao layer,....");
			/*
			 * Iterator<Product> it=plist.iterator(); while(it.hasNext()) { Product
			 * p=(Product)it.next(); if(p.getProductId()==id) it.remove(); }
			 */
			Connection con=DbConn.getConnection();
			Statement s=con.createStatement();
			s.executeUpdate("delete from product where id="+id);
			logger.info("Product is deleted successfully........");
			
	 }
			
			public List<Product> displayAllProducts() throws Exception{
				logger.info("Enter into display all product function......");
				Connection con=DbConn.getConnection();
			   Statement pst=con.createStatement();
			   ArrayList<Product> plist=new ArrayList<Product>();
				
				
				ResultSet rs=pst.executeQuery("select * from product");
				logger.info("executed the query successfully ....");
				
				while(rs.next()) {
					int id=rs.getInt(1);
					String name=rs.getString(2);
					double qty=rs.getDouble(3);
					double price=rs.getDouble(4);
					Product p=new Product();
					p.setProductId(id);
					p.setProductName(name);
					p.setQty(qty);
					p.setPrice(price);
					plist.add(p);
					logger.info("Product is added into ArrayList<Product> plist.......");
				}
				
				
				
				return plist;
				
			}
			public void updatePro(int id) throws ClassNotFoundException, SQLException, IOException {
				logger.info("Entered into dao layer update Product function.....");
				Connection con=DbConn.getConnection();
				PreparedStatement pst=con.prepareStatement("update product set name=?, qty=?, price=? where id=?");
				System.out.println("Enter product name:");
				pst.setString(1,sc.nextLine());
				System.out.println("Enter the Qty:");
				pst.setDouble(2, sc.nextDouble());
				System.out.println("Enter Price:");
				pst.setDouble(3, sc.nextDouble());
				pst.setInt(4, id);
				logger.info("Product is Updated Successfully........");
				pst.executeUpdate();
				
				
			}
			public  List<Product> searchById(int id) throws ClassNotFoundException, SQLException,ProductNotFoundException, IOException {
				logger.info("Entered dao layer function search by Id  successfully.....");
				
				Connection con=DbConn.getConnection();
				List<Product> list=new ArrayList<Product>();
				Statement s=con.createStatement();
			ResultSet rs=	s.executeQuery("Select * from product where id="+id);
			
			logger.info("executed the query successfully ....");
			
			while(rs.next()) {
			int id1=rs.getInt(1);
				String name=rs.getString(2);
				double qty=rs.getDouble(3);
				double price=rs.getDouble(4);
				Product p=new Product();
				p.setProductId(id1);
				p.setProductName(name);
				p.setQty(qty);
				p.setPrice(price);
				list.add(p);
				logger.info("Product is added into ArrayList<Product> plist.......");
			}
			
			
				return list;
				
			}
			
}