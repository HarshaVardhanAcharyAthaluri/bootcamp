package com.bootcamp.product.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.product.dao.Product;
import com.bootcamp.product.dao.ProductRepository;
import com.bootcamp.product.exceptions.ProductNotFoundException;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	
	
	public List<Product> getAllProdcuts(){
		return (List<Product>) productRepo.findAll();
	}
	
	
	public Product getProductById(Long prodcutId) {
		return productRepo.findById(prodcutId)
				.orElseThrow(()->new ProductNotFoundException("oroduct not found wuth id :"+ prodcutId));
		
	}
	
	
	public Product saveProduct(Product product) {
		return productRepo.save(product);
		
	}
	
	public String deleteProduct(Long productId) {
		Product exitingProduct = productRepo.findById(productId)
		.orElseThrow(()->new ProductNotFoundException("poroduct not found wuth id :"+ productId));
		
		if(exitingProduct!=null) 
		productRepo.deleteById(productId);
		
		return "Product Deleted SUccfully";
		
	}
	
	
	public Product updateProduct(Product product,Long prodcutId) {
		
		Product exitingProduct =productRepo.findById(prodcutId)
		.orElseThrow(()->new ProductNotFoundException("poroduct not found wuth id :"+ prodcutId));
		
		if(exitingProduct!=null) {
			exitingProduct.setProductName(product.getProductName()!=null?product.getProductName():exitingProduct.getProductName());
			exitingProduct.setProductQuantity(product.getProductQuantity()!=exitingProduct.getProductQuantity()?product.getProductQuantity():exitingProduct.getProductQuantity());
		productRepo.save(exitingProduct);
		}
		
		return exitingProduct;
	}
	
	
}
