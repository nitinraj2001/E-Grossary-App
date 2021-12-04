import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  picByte: any;

  product:any={"name":"","category":"","description":"","unitPrice":"","unitsInStock":""};

  constructor() { }

  ngOnInit(): void {
  }

  onFileChanged(event) {
    this.picByte = event.target.files[0]
  }

  registerProduct(){

    console.log(this.product.name);

  }

}
