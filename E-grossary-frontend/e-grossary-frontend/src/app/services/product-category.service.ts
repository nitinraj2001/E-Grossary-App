import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductCategoryService {

  constructor(private http:HttpClient) { }

  public registerProductCategory(category:any){
    return this.http.post(`http://localhost:9091/product-category/`,category);
  }
}
