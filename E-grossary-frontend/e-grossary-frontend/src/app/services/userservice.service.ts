import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  constructor(private http:HttpClient) { }

  public getUserRole(id:any){
    return this.http.get(`${baseUrl}/user/getRole/${id}`);
  }
}
