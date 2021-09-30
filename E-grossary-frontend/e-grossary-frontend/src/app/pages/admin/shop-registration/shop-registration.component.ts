import { ShopService } from './../../../services/shop.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-shop-registration',
  templateUrl: './shop-registration.component.html',
  styleUrls: ['./shop-registration.component.css']
})
export class ShopRegistrationComponent implements OnInit {

  shop:any={"name":"","address":"","email":""};
  picByte:any;

  constructor(private shopService:ShopService) { }

  ngOnInit(): void {
  }

  onFileChanged(event) {
    this.picByte = event.target.files[0]
  }

  registerShop(){
    const formdata=new FormData();
    console.log(this.shop);
    formdata.append("name",this.shop.name);
    formdata.append("email",this.shop.email);
    formdata.append("address",this.shop.address);
    formdata.append("shopImage",this.picByte);
    this.shopService.registerShop(formdata).subscribe(
      (data)=>{
        console.log(data);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

}
