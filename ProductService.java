package org.services;
import java.util.*;
import java.sql.SQLException;
import java.util.List;

import org.productApp.ProductDataAdd;
import org.productRepository.Repository;


public class ProductService {
	Repository r=new Repository();
	public boolean isProdSave(ProductDataAdd p) throws SQLException  {
		
		boolean b=r.isAddProduct(p);
		return b;
		
	}
	public List<ProductDataAdd> getAllProducts(){
		return r.getAllProducts();
	}
	
	 public boolean isDeleteProduct(int prodid) {
		return r.isDeleteProduct(prodid);
		 
	 }
	 //for update
	 public boolean isFinalUpdate(ProductDataAdd p) {
		 return r.isFinalUpdate(p); 
	 }
}

