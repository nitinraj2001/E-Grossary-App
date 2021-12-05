import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductCategoryService } from 'src/app/services/product-category.service';

@Component({
  selector: 'app-user-view-category',
  templateUrl: './user-view-category.component.html',
  styleUrls: ['./user-view-category.component.css']
})
export class UserViewCategoryComponent implements OnInit {

  @Input() shopId=1;
  categoryList:any=[];
  category:any={"id":"","categoryName":"","description":"","shopId":"","picByte":""};
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
    this.route.navigate([`/user-dashboard/view-products`]);
  }





}
