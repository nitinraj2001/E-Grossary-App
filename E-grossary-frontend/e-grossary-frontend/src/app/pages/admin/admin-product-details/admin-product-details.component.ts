import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartItem } from 'src/app/interface/cart-item';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-admin-product-details',
  templateUrl: './admin-product-details.component.html',
  styleUrls: ['./admin-product-details.component.css']
})
export class AdminProductDetailsComponent implements OnInit {

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
    this.route.navigate([`/admin-dashboard/view-products`])
  }

  addToCartInProductDetails(){
    console.log(`product name: ${this.product.name} added to your cart it will cost u ${this.product.unitPrice}`);
    this.cartItem=new CartItem(this.product);
    console.log(this.cartItem);
    this.cartService.addToCart(this.cartItem);
    console.log("item is added in cart");
 }

 deleteProduct(){
   
 }




}

