import { CartItem } from './../interface/cart-item';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartItem:CartItem[]=[];

  totalPrice : Subject<number>=new Subject<number>();

  totalQuantity : Subject<number>=new Subject<number>();

  constructor() { }

  addToCart(theCartItem:CartItem){
    console.log("cart service is going to start just for debugging");
    let cartExistingItem:CartItem=undefined;
    let isExitInCart: boolean=false;
    console.log("declartion completed"+this.cartItem);
    if(this.cartItem.length){
      console.log("moving inside if condition in cart service");
     cartExistingItem= this.cartItem.find(tempCartItem=>tempCartItem.id==theCartItem.id);

     isExitInCart=(cartExistingItem!=undefined);

    }

    if(isExitInCart){
      cartExistingItem.quantity++;
    }
    else{
      console.log("item is added in the cart");
      this.cartItem.push(theCartItem);
    }

    this.calculateTotalPrice();
    
  }
  calculateTotalPrice() {
    let totalPriceValue: number=0;

    let totalQuantityValue: number=0;

    for(let currentcartItem of this.cartItem){
      totalPriceValue+=currentcartItem.quantity*currentcartItem.unitPrice;
      totalQuantityValue+=currentcartItem.quantity;
    }
    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(totalQuantityValue);

    console.log(`total price in cart is :${totalPriceValue} and total quantity in cart is :${totalQuantityValue}`)
  }

  decrementQuantity(cartItem:CartItem) {
    cartItem.quantity--;
    if(cartItem.quantity==0){
      this.remove(cartItem);
    }
    this.calculateTotalPrice();
  }

  remove(cartItem:CartItem){

    const cartItemIndex=this.cartItem.findIndex((tempCartItem)=>tempCartItem.id==cartItem.id);

    if(cartItemIndex>-1){
      this.cartItem.splice(cartItemIndex,1);
      this.calculateTotalPrice();
    }

  }

}
