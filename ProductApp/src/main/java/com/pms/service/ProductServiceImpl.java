package com.pms.service;

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

import com.pms.dao.ProducDaoImpl;
import com.pms.dao.ProductDao;
import com.pms.dbcon.DbConn;
import com.pms.exceptions.ProductNotFoundException;
import com.pms.model.Product;

public class ProductServiceImpl implements ProductService {
	 private static final Logger logger = Logger.getLogger("ProductServiceImpl.class");

	static ArrayList<Product> productList=new ArrayList<Product>();
	ProductDao pd=new ProducDaoImpl();
	
	//---------------------------------------------Add product function -------------------
	public void addProduct(Product p) throws Exception {
		logger.info("adding...");
		pd.addProduct(p);
		
		logger.info("added successfully...in db as well");
	}
	
	//-----------------------------------------------Delete Product -----------------------------
	
	public void deleteProduct(int id) throws ClassNotFoundException, SQLException, IOException {
		logger.info("entering into product service Impl deleting function ,....");
		/*
		 * Iterator<Product> it=productList.iterator(); while(it.hasNext()) { Product
		 * p=(Product)sit.next(); if(p.getProductId()==id) it.remove(); }
		 */
		pd.deleteProduct(id);
	}
	//----------------------------------------Update All Product---------------------------
	public void updateProduct(int id) throws ClassNotFoundException, SQLException, IOException {
		pd.updatePro(id);
	}
	
	
	//-----------------------------Display All Product-------------------------------------------
	public List<Product> displayAllProducts() throws Exception{
		logger.info("returning all the product list");
	 List<Product> plist=pd.displayAllProducts();
			return plist;
		
	}
	
	//-------------------------Search By Id--------------------------------
	public List<Product> searchProduct(int id) throws ClassNotFoundException, SQLException, IOException,ProductNotFoundException{
		logger.info("Entered service Impl function search by Id....");
		List<Product> list=pd.searchById(id);
		return list;
	
		
	}

}
