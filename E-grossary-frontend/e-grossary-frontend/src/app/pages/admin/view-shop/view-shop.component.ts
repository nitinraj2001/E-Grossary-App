import { ShopService } from './../../../services/shop.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-shop',
  templateUrl: './view-shop.component.html',
  styleUrls: ['./view-shop.component.css']
})
export class ViewShopComponent implements OnInit {

  shop:any;
  id:any;
  base64Data: any;
  retrievedImage: string;

  constructor(private shopService:ShopService,private router:ActivatedRoute) { }

  ngOnInit(): void {
   this.id=+this.router.snapshot.paramMap.get("id");
   this.getShopDetails();
  }
 
  getShopDetails(){
    this.shopService.getShopDetail(this.id).subscribe(
      (data)=>{
        this.shop=data;
        this.base64Data=this.shop.picByte;
        this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
      }
    )
  }



}
