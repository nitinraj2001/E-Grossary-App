import { ShopService } from './../../../services/shop.service';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-view-shop',
  templateUrl: './view-shop.component.html',
  styleUrls: ['./view-shop.component.css']
})
export class ViewShopComponent implements OnInit {
  
  @Output() public shopId=new EventEmitter<any>();
  shop:any;
  id:any;
  base64Data: any;
  retrievedImage: string;

  constructor(private shopService:ShopService,private router:ActivatedRoute,private route:Router) { }

  ngOnInit(): void {
   this.id=+this.router.snapshot.paramMap.get("id");
   console.log("shop Id is:",this.id);
   this.shopId.emit(this.id);
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

  showProducts(){
    this.route.navigate([`/admin-dashboard/view-shop/${this.id}/view-category`]);
    
  }

  addCategory(){
    this.route.navigate([`/admin-dashboard/shop/${this.id}/add-category`]);
  }



}
