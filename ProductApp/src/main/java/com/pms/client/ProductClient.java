package com.pms.client;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import com.pms.model.Product;
import com.pms.service.ProductService;
import com.pms.service.ProductServiceImpl;
public class ProductClient {
	 private static final Logger logger = Logger.getLogger("ProductClient.class");
	
	public static void main(String[] args) throws Exception {
		ProductService ps=new ProductServiceImpl();

		System.out.println(" =====Menu=====");
		System.out.println(" 1.add Product:");
		System.out.println(" 2.Delete Product:");
		System.out.println(" 3.Update Product:");
		System.out.println(" 4.View list of Product:");
		System.out.println(" 5.search Product by id:");
		logger.info(" logg started");
		
		int ch=4;
		Scanner sc=new Scanner(System.in);
		do {
			switch (ch) {
			case 1:  {   System.out.println("enter product details to be added");
			             Product p=new Product();
			             System.out.println("Please enter Product Id:");
			             p.setProductId(sc.nextInt());   sc.nextLine();
			             System.out.println("Please enter Product Name:");
			             p.setProductName(sc.nextLine());
			             System.out.println("Please Enter Product Qty:");
			             p.setQty(sc.nextDouble());
			             System.out.println("Please Enter the Price:");
			             p.setPrice(sc.nextDouble());
			             logger.info("going to service");
				         ps.addProduct(p);
				         break;
					}
			
			
			//------------------------------delete option--------------------
			case 2: {   System.out.println("enter product id to be deleted");
							int id=sc.nextInt() ;
                           ps.deleteProduct(id);
           
	         break;
	        		}
			
			//-------------------------------update option-----------------------
			
			case 3: {
				System.out.println("enter product id to be updated:");
				int id=sc.nextInt();
				ps.updateProduct(id);
				
				break;
			}
			
			//----------------------------View List of  product option--------------------
			
			case 4: {  List<Product> plist= ps.displayAllProducts();
			         //  plist.stream().forEach(p->p.getProductId() +"  "+p.getProductName()+"  "+p.getPrice()+"  "+p.getQty());
			          for(Product p:plist) {
			        	  System.out.println(p.getProductId()+"  "+p.getProductName()+"  "+p.getQty()+"  "+p.getPrice());
			          }

break;
}
			
			//------------------search Product---------------------------------
			case 5:{
				System.out.println("enter  product Id:");
				int id=sc.nextInt();
				List<Product> list=ps.searchProduct(id);
				for(Product p:list) {
					System.out.println(p);
				}
				
				break;
			}
			
			default: {System.out.println(" Wrong data");}
			}
			
			
			System.out.println("enter you option to continue(1..4)");
			ch=sc.nextInt();
		}while(ch<=5);
		
		
		
	}

}
