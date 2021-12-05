import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ShopService } from 'src/app/services/shop.service';

@Component({
  selector: 'app-user-view-shop',
  templateUrl: './user-view-shop.component.html',
  styleUrls: ['./user-view-shop.component.css']
})
export class UserViewShopComponent implements OnInit {

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

  viewCategory(){
    this.route.navigate([`/user-dashboard/view-shop/view-category/${this.id}`]);
    
  }



}
