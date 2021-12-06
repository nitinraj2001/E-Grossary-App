package com.hack.abes.productmicroservice.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
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
@RequestMapping(value="/product",produces="application/json")
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@PostMapping(value="/",headers = "content-type=multipart/*")
	public ResponseEntity<?> registerCategory(@RequestParam("productImage") MultipartFile file,@RequestParam("name") String name,@RequestParam("unitsInStock") int unitsInStock,@RequestParam("categoryId") Long categoryId,@RequestParam("description") String description,@RequestParam("unitPrice") BigDecimal unitPrice) throws IOException{
	   System.out.println(description+" "+unitsInStock);
		
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
	
       @GetMapping("/getAllProducts")
       public List<Product> getAllProducts(){
    	   List<Product> products=this.productService.getAllProducts();
    	   for(Product product:products) {
			   product.setPicByte(decompressBytes(product.getPicByte()));
		   }
    	   return this.productService.getAllProducts();
       }
       
       @GetMapping("/getProductDetails/{productId}")
       public Product getProductDetails(@PathVariable Long productId) {
    	   Product product=this.productService.getProductDetail(productId);
    	   product.setPicByte(decompressBytes(product.getPicByte()));
    	   return product;
       }
       
       //get all recommended products
       @GetMapping("recommendations")
       public List<RecommendedItem> getRecommendedProducts(){
    	   List<RecommendedItem> recommendations=null;
    	   try {
			DataModel datamodel = new FileDataModel(new File("F:\\nitinraj document\\data-analytic-files\\gapminder-FiveYearData.csv"));
			UserSimilarity similarity = new PearsonCorrelationSimilarity(datamodel);
			UserNeighborhood neighborhood = new ThresholdUserNeighborhood(3.0, similarity, datamodel);
			UserBasedRecommender recommender = new GenericUserBasedRecommender(datamodel, neighborhood, similarity);
			recommendations = recommender.recommend(5, 1);
			System.out.println(recommendations+" "+recommender+" "+recommender.recommend(5,2));

			for (RecommendedItem recommendation : recommendations) {
				System.out.println("recommendated items are"+recommendation);
			   System.out.println(recommendation);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
    	   return recommendations;
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
