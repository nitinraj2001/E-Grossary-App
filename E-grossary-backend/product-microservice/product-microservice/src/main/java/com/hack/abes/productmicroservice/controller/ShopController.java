package com.hack.abes.productmicroservice.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

import com.hack.abes.productmicroservice.model.Shop;
import com.hack.abes.productmicroservice.service.ShopService;

@RestController
@RequestMapping(value="/shop")
@CrossOrigin("*")
public class ShopController {
	
   @Autowired
   private ShopService shopService;
   
   @PostMapping(value="/",headers = "content-type=multipart/*")
	public ResponseEntity<?> registerShop(@RequestParam("shopImage") MultipartFile file,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("address") String address) throws IOException{
	   System.out.println(file.getBytes()+" "+name+" "+email+" "+address);
	   Shop theShop=new Shop();
	   theShop.setAddress(address);
	   theShop.setEmail(email);
	   theShop.setName(name);
	   try {
	     theShop.setPicByte(compressBytes(file.getBytes()));
	   }catch(Exception e) {
		   e.printStackTrace();
		   
	   }
	   Shop shop=this.shopService.registerShop(theShop);
	   return ResponseEntity.ok(shop);
   }
   
   @GetMapping("/getAllShops")
   public ResponseEntity<?> getAllShopsDetails(){
	   List<Shop> allShops=this.shopService.getAllShops();
	   for(Shop shop:allShops) {
		   shop.setPicByte(decompressBytes(shop.getPicByte()));
	   }
	   return ResponseEntity.ok(allShops);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<?> getShopDetail(@PathVariable Long id){
	   Shop theShop=this.shopService.getShopDetail(id);
	   theShop.setPicByte(decompressBytes(theShop.getPicByte()));
	   return ResponseEntity.ok(theShop);
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

