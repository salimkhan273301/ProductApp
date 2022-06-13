package com.pms.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.pms.exceptions.ProductNotFoundException;
import com.pms.model.Product;

public interface ProductService {

	public void addProduct(Product p) throws Exception;
	public void deleteProduct(int id) throws ClassNotFoundException, SQLException, IOException;
	public List<Product> displayAllProducts() throws Exception;
	public void updateProduct(int id) throws ClassNotFoundException, SQLException, IOException;
	public List<Product> searchProduct(int id) throws ClassNotFoundException, SQLException, IOException, ProductNotFoundException;
	
}
