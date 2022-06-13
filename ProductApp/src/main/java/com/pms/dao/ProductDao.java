package com.pms.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.pms.exceptions.ProductNotFoundException;
import com.pms.model.Product;

public interface ProductDao {
	public void addProduct(Product p) throws Exception;
	public void deleteProduct(int id) throws ClassNotFoundException, SQLException, IOException;
	public List<Product> displayAllProducts() throws Exception;
	public void updatePro(int id) throws ClassNotFoundException, SQLException, IOException;
	public List<Product> searchById(int id)  throws ClassNotFoundException, SQLException, IOException, ProductNotFoundException;

}
