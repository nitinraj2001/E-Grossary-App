import { ProductService } from './../../../services/product.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  picByte: any;
  categoryId:any;

  product:any={"name":"","category":"","description":"","unitPrice":"","unitsInStock":""};

  constructor(private router:ActivatedRoute,private productService:ProductService) { }

  ngOnInit(): void {
    this.categoryId=+this.router.params['id'];
    console.log("categoryId is:"+this.categoryId);
  }

  onFileChanged(event) {
    this.picByte = event.target.files[0]
  }

  registerProduct(){
    const formdata=new FormData();
    console.log(this.product);
    formdata.append("name",this.product.name);
    formdata.append("categoryId",this.categoryId);
    formdata.append("description",this.product.description);
    formdata.append("unitPrice",this.product.unitPrice);
    formdata.append("unitsInStock",this.product.unitsInStock);
    formdata.append("categoryImage",this.picByte);
    this.productService.registerProduct(this.product).subscribe(
      (data)=>{
        console.log(data);
      },
      (error)=>{
        console.log(error);
      }
    )

  }

}
