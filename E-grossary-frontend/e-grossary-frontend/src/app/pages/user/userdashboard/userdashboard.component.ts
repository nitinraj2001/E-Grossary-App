import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from './../../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {

  username:any;
  loggedInStatus: number;

  constructor(private loginService:LoginService,private route:Router,private snackbar:MatSnackBar) { }

  ngOnInit(): void {
    this.username=localStorage.getItem("username");
  }

  logout(){
    this.loginService.dologout();
    this.route.navigate(['/login']);
    this.snackbar.open("you have successfully logout!!","ok",{duration:3000});
  }

}
