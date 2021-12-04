import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  public registerProduct(product:any){
    return this.http.post(`http://localhost:9091/product-category/product`,product);
  }

  public getAllProductDetails(){
    return this.http.get(`http://localhost:9091/product/getAllProducts`);
  }
}
