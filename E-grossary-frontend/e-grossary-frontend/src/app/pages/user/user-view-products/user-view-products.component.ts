import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-user-view-products',
  templateUrl: './user-view-products.component.html',
  styleUrls: ['./user-view-products.component.css']
})
export class UserViewProductsComponent implements OnInit {

  products:any=[];

  base64Data: any;
  retrievedImage: string;

  product:any={"name":"","category":"","description":"","unitPrice":"","unitsInStock":""};

  constructor(private productService:ProductService,private router:ActivatedRoute,private route:Router) { }

  ngOnInit(): void {
    this.showAllProducts();
  }

  showAllProducts(){
    this.productService.getAllProductDetails().subscribe(
      (data)=>{
        console.log(data);
        this.products=data;
        this.products.forEach(element => {
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

  redirectProductDetail(id:any){
    this.route.navigate([`/user-dashboard/product-details/${id}`]);
  }



}
