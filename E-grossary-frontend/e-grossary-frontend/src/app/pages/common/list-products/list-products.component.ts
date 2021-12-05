import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from './../../../services/product.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent implements OnInit {

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
