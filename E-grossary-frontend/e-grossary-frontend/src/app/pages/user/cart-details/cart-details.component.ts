import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { CartItem } from 'src/app/interface/cart-item';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent implements OnInit {

  cartItems:CartItem[]=[];

  totalPrice: number;

  totalQuantity: number;

  constructor(private cartService: CartService,private route:Router) { }

  ngOnInit(): void {
    this.showcartdetails();
  }
  showcartdetails() {
    this.cartItems=this.cartService.cartItem;
    this.cartService.totalPrice.subscribe(data=>this.totalPrice=data);
    this.cartService.totalQuantity.subscribe(data=>this.totalQuantity=data);
    this.cartService.calculateTotalPrice();
  }

  incrementQuantity(cartItem:CartItem){
    console.log("cartItem is added in your cart",cartItem);
    this.cartService.addToCart(cartItem);
  }

  decrementQuantity(cartItem:CartItem){
    this.cartService.decrementQuantity(cartItem);
  }

  remove(cartItem:CartItem){
    this.cartService.remove(cartItem);
  }

  redirectViewProducts(){
    this.route.navigate(['/user-dashboard/view-products']);
  }

}
