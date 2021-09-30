import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { UserserviceService } from 'src/app/services/userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  theUser:any={"userId":0,"username":"","firstname":"","lastname":"","email":"","phonenumber":"","password":"","address":""};
  username:any;
  loggedInStatus=false;

  constructor(private userService:UserserviceService,private loginService:LoginService,private route:Router,private snackbar:MatSnackBar) { }

  ngOnInit(): void {
    if(localStorage.length>0){
      if(localStorage.getItem("user")!=null){
       // this.theUser=localStorage.getItem("user");
        this.theUser=this.loginService.getLoggedInUserDetails();
        this.theUser=JSON.parse(JSON.stringify(this.theUser));
        this.username=localStorage.getItem("username");
        this.loginService.currentUserLoginStatusSubject$.asObservable().subscribe(
          (data)=>{
            this.loggedInStatus=this.loginService.isLoggedIn();
            console.log("loggedIn status of user is "+this.loggedInStatus);
          }
        )
        console.log(this.theUser.username);
      }
    }
   
  }
  


  

}
