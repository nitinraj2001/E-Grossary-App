import { ProductService } from './../../../services/product.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent implements OnInit {

  product:any={"name":"","category":"","description":"","unitPrice":"","unitsInStock":""};

  constructor(private productService:ProductService) { }

  ngOnInit(): void {
    this.showAllProducts();
  }

  showAllProducts(){
    this.productService.getAllProductDetails().subscribe(
      (data)=>{
        console.log(data);
        this.product=data;
      },
      (error)=>{
        console.log(error);
      }
    )
  }



}
