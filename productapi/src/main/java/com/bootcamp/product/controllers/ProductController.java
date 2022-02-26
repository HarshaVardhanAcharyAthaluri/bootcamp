package com.bootcamp.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.product.dao.Product;
import com.bootcamp.product.sevices.ProductService;

@CrossOrigin({"*"})
@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	
	@GetMapping("/product/list")
	public ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity(productService.getAllProdcuts(),HttpStatus.OK);
	}

	@GetMapping("/product/find/{id}")
	public ResponseEntity<Product> getSIngleProduct(@PathVariable Long id){
		return new ResponseEntity<Product>(productService.getProductById(id),HttpStatus.OK);
		
	}

	@PostMapping("/prodcut")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.saveProduct(product),HttpStatus.CREATED);
		
	}

	
	@PutMapping("/productupdate/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long productId,@RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProduct(product, productId),HttpStatus.CREATED);
	}

	@DeleteMapping("/productdlete/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long productId){
		return new ResponseEntity<String>(productService.deleteProduct(productId),HttpStatus.OK);
		
	}

}
