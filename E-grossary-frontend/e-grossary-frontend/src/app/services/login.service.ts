import { Injectable } from '@angular/core';
import { HttpClient, ɵHttpInterceptingHandler} from '@angular/common/http';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  public login(user:any){
    return this.http.post(`${baseUrl}/user/authenticate`,user,{responseType: 'text'});
  }
}
