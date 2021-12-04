package com.hack.abes.productmicroservice.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hack.abes.productmicroservice.model.Product;
import com.hack.abes.productmicroservice.model.ProductCategory;
import com.hack.abes.productmicroservice.service.ProductCategoryService;
import com.hack.abes.productmicroservice.service.ProductService;


@RestController
@RequestMapping(value="/product-category")
@CrossOrigin("*")
public class ProductCategoryController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	
	@PostMapping(value="/",headers = "content-type=multipart/*")
	public ResponseEntity<?> registerCategory(@RequestParam("categoryImage") MultipartFile file,@RequestParam("name") String name,@RequestParam("description") String description,@RequestParam("shopId") Long shopId) throws IOException{
	   
	   ProductCategory productCategory= new ProductCategory();
	   productCategory.setShopId(shopId);
	   productCategory.setCategoryName(name);
	   productCategory.setDescription(description);
	   try {
		   productCategory.setPicByte(compressBytes(file.getBytes()));
	   }catch(Exception e) {
		   e.printStackTrace();
		   
	   }
	   this.productCategoryService.registerProductCategory(productCategory);
	   return ResponseEntity.ok("category is added succesfully");
   }
	
	@PostMapping(value="/product",headers = "content-type=multipart/*")
	public ResponseEntity<?> registerProduct(@RequestParam("productImage") MultipartFile file,@RequestParam("name") String name,@RequestParam("unitsInStock") int unitsInStock,@RequestParam("categoryId") Long categoryId,@RequestParam("description") String description,@RequestParam("unitPrice") BigDecimal unitPrice) throws IOException{
	   System.out.println(description+" "+unitsInStock+categoryId);
		
	   ProductCategory productCategory=this.productCategoryService.getProductCategoryDetails(categoryId);
	   Product product=new Product();
	   product.setShopId(productCategory.getShopId());
	   product.setCategory(productCategory);
	   product.setDescription(description);
	   product.setName(name);
	   product.setUnitPrice(unitPrice);
	   product.setUnitsInStock(unitsInStock);
	   try {
		   product.setPicByte(compressBytes(file.getBytes()));
	   }catch(Exception e) {
		   e.printStackTrace();
		   
	   }
	   this.productService.registerProduct(product);
	   return ResponseEntity.ok("product is added succesfully");
   }
	
	
	
	 @GetMapping("/getAllProductCategory/{id}")
	   public ResponseEntity<?> getAllCategoryDetails(@PathVariable Long id){
		   List<ProductCategory> allCategory=this.productCategoryService.getAllProductCategoryInShop(id);
		   for(ProductCategory category:allCategory) {
			   category.setPicByte(decompressBytes(category.getPicByte()));
		   }
		   return ResponseEntity.ok(allCategory);
	   }
	
	// compress the image bytes before storing it in the database
		public static byte[] compressBytes(byte[] data) {
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
			return outputStream.toByteArray();
		}
		// uncompress the image bytes before returning it to the angular application
		public static byte[] decompressBytes(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}

}
