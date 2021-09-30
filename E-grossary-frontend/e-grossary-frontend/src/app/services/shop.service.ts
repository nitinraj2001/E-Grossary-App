import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  constructor(private http:HttpClient) { }

  public registerShop(shop:any){
    return this.http.post(`http://localhost:9091/shop/`,shop);
  }

  public getAllShopDetails(){
    return this.http.get(`http://localhost:9091/shop/getAllShops`);
  }
  public getShopDetail(id:any){
    return this.http.get(`http://localhost:9091/shop/${id}`);
  }
}
