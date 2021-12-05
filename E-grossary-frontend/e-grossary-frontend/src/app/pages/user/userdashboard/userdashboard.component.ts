import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from './../../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ShopService } from 'src/app/services/shop.service';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {
  retrievedImage: any;
  base64Data: any;

  shop:any;

  username:any;
  loggedInStatus: number;

  constructor(private loginService:LoginService,private route:Router,private snackbar:MatSnackBar,private shopService:ShopService) { }

  ngOnInit(): void {
    this.username=localStorage.getItem("username");
    this.getAllRegisteredShops();
  }

  getAllRegisteredShops(){
    this.shopService.getAllShopDetails().subscribe(
      (data)=>{
        this.shop=data;
        this.base64Data=this.shop[0].picByte;
        this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
        console.log(this.shop);
      }
    );
  }

  logout(){
    this.loginService.dologout();
    this.route.navigate(['/login']);
    this.snackbar.open("you have successfully logout!!","ok",{duration:3000});
  }

}
