import { Injectable } from '@angular/core';
import { HttpClient, ɵHttpInterceptingHandler} from '@angular/common/http';
import baseUrl from './helper';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  currentUserLoginStatusSubject$ = new BehaviorSubject<boolean>(false);

  constructor(private http:HttpClient) { }

  public login(user:any){
    return this.http.post(`${baseUrl}/user/authenticate`,user,{responseType: 'text'});
  }
  public fetchUserByUsername(username:any){
   return this.http.get(`${baseUrl}/user/fetchByUsername/${username}`);
  }

  getLoggedInUserDetails(){
    return localStorage.getItem("user");
  }

  getUserLoggedInStatus(){
    return this.currentUserLoginStatusSubject$.asObservable();
  }

  dologout(){
     localStorage.clear();
     this.currentUserLoginStatusSubject$.next(false);

  }

  isLoggedIn(){
    let user=localStorage.getItem("user");
    if(user==null||user==''||user==undefined){
      return false;
    }
    return true;
  }
  
}
