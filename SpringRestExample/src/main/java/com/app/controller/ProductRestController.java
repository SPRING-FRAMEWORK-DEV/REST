package com.app.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.model.Product;

/*
 * URL
 /dummy,
 /allproducts,/addproduct,product-{id},/update-product-{id},delete-product-{id}
 * 
 */
@Controller
public class ProductRestController {

	Map<String, Product> productData;

	public ProductRestController() {
		super();
		productData = new HashMap<String, Product>();

		for (int i = 0; i < 10; i++) {
			Product p = new Product(String.valueOf(new Random().hashCode()),
					"S5", 9875.00F);
			productData.put(p.getProductSlnum(), p);
		}
		// TODO Auto-generated constructor stub
	}

	// sample json response test
	@RequestMapping(method = RequestMethod.GET, value = "dummy", produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public @ResponseBody
	Product getDummyProduct(@RequestHeader HttpHeaders headers) {
		return new Product("X23456", "SAMSUNG S6", 35000.78F);
	}

	// get all products
	@RequestMapping(method = RequestMethod.GET, value = "allproducts", produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public @ResponseBody
	Map<String, Product> getAllProducts() {

		return productData;
	}

	// add a product
	@RequestMapping(value = "add-product", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<Void> addProduct(@RequestBody Product product,
			UriComponentsBuilder builder) {
		HttpHeaders headers = new HttpHeaders();
		Product p = new Product(product.getProductSlnum(),
				product.getProductName(), product.getProductPrice());// create/save
		productData.put(p.getProductSlnum(), p);
		headers.setLocation(builder.path("product-{id}")
				.buildAndExpand(p.getProductSlnum()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// show a product
	@RequestMapping(value = "product-{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductById(@PathVariable("id") String id) {
		if (productData.containsKey(id) == false)
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Product>(productData.get(id), HttpStatus.OK);// retrieve
	}

	// update a product
	@RequestMapping(value = "update-product-{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<Product> updateProductById(
			@PathVariable("id") String id, @RequestBody Product product) {
		if (productData.containsKey(id) == false)
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		productData.put(product.getProductSlnum(), product);// update
		return new ResponseEntity<Product>(productData.get(id), HttpStatus.OK);
	}

	// delete a product
	@RequestMapping(value = "delete-product-{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> deleteProductById(
			@PathVariable("id") String id) {
		if (productData.containsKey(id) == false)
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		productData.remove(id);// delete
		return new ResponseEntity<Product>(productData.get(id),
				HttpStatus.NO_CONTENT);
	}
}
