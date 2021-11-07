import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {

  category:any={"name":"","description":"","shopId":""};
  picByte:any;

  constructor() { }

  ngOnInit(): void {
  }

  registerCategory(){

  }

  onFileChanged(event) {
    this.picByte = event.target.files[0]
  }

}
