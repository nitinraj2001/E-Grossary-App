import { ProductCategoryService } from './../../../services/product-category.service';
import { Component, Input, OnInit } from '@angular/core';
import {Router } from '@angular/router';


@Component({
  selector: 'app-list-category',
  templateUrl: './list-category.component.html',
  styleUrls: ['./list-category.component.css']
})
export class ListCategoryComponent implements OnInit {

  @Input() shopId=1;
  categoryList:any=[];
  category:any={"id":"","categoryName":"","description":"","shopId":""};
  base64Data: any;
  retrievedImage: string;
  

  constructor(private productCategoryService:ProductCategoryService,private route:Router) { }

  ngOnInit(): void {
    console.log("shop id emitted by event handler is "+this.shopId);
    this.getProductCategoryDetails();
  }

  getProductCategoryDetails(){
    this.productCategoryService.getAllCategoryDetails(this.shopId).subscribe(
      (data)=>{
        console.log(data);
        this.categoryList=data;
        this.categoryList.
        forEach(element => {
          this.base64Data=element.picByte;
        this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
        element.picByte=this.retrievedImage;
        });
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  redirectaddproduct(categoryId:any){
    console.log("category id is:",+categoryId);
     this.route.navigate([`/admin-dashboard/add-product/${categoryId}`]);
  }

  redirectViewProducts(){
    this.route.navigate([`/admin-dashboard/view-products`]);
  }





}
