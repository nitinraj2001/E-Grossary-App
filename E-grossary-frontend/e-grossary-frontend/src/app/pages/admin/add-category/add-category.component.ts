import { Router, ActivatedRoute } from '@angular/router';
import { ProductCategoryService } from './../../../services/product-category.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {

  category:any={"name":"","description":"","shopId":""};
  picByte:any;

  constructor(private productCategoryService:ProductCategoryService,private route: Router,private router:ActivatedRoute) { }

  ngOnInit(): void {
    this.category.shopId=1;
  }

  registerCategory(){
    const formdata=new FormData();
    console.log(this.category);
    formdata.append("name",this.category.name);
    formdata.append("shopId",this.category.shopId);
    formdata.append("description",this.category.description);
    formdata.append("categoryImage",this.picByte);
    this.productCategoryService.registerProductCategory(formdata).subscribe((data)=>{
      console.log(data);
    },
    (error)=>{
      console.log(error);
    })
  }

  onFileChanged(event) {
    this.picByte = event.target.files[0]
  }

}
