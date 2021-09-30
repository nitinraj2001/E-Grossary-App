import { ShopService } from './../../../services/shop.service';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit {

  username:any;

  retrievedImage: any;
  base64Data: any;

  shop:any;

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
