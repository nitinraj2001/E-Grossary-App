import { Product } from './../../../interface/product';
import { CartItem } from './../../../interface/cart-item';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  productId:any;
  base64Data: any;
  retrievedImage: string;
  cartItem:CartItem;

  product:any={"id":"","name":"","category":"","description":"","unitPrice":"","unitsInStock":"","picByte":""};

 

  constructor(private productService:ProductService,private cartService:CartService,private router:ActivatedRoute,private route:Router) { }

  ngOnInit(): void {
    this.productId=+this.router.snapshot.paramMap.get('id');
    console.log("product id is:"+this.productId);
    this.showProductDetails();
  }

  showProductDetails(){
    this.productService.getProductDetails(this.productId).subscribe(
      (data)=>{
        console.log(data);
        this.product=data;
        this.base64Data=this.product.picByte;
        this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
        this.product.picByte=this.retrievedImage;
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  redirectViewProducts(){
    this.route.navigate([`/user-dashboard/view-products`])
  }

  addToCartInProductDetails(){
    console.log(`product name: ${this.product.name} added to your cart it will cost u ${this.product.unitPrice}`);
    this.cartItem=new CartItem(this.product);
    console.log(this.cartItem);
    this.cartService.addToCart(this.cartItem);
    console.log("item is added in cart");
 }




}
