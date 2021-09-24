import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:any={"username":'',"password":""};

  theUser:any={"username":"","firstname":"","lastname":"","email":"","phonenumber":"","password":"","address":""};


  constructor(private snackbar:MatSnackBar,private loginService:LoginService) { }

  ngOnInit(): void {
  }

  login(){
    //console.log("loging service is uploading");
    if(this.user.username==null||this.user.username==''){
        this.snackbar.open("Username can't be empty or null","ok",{duration:3000});
       // console.log(this.user);
        return;
    }
    if(this.user.password==null||this.user.password==''){
      this.snackbar.open("Password can't be empty or null","ok",{duration:3000});
      return;
    }
    
    this.loginService.fetchUserByUsername(this.user.username).subscribe(
      (data)=>{
        this.theUser=JSON.stringify(data);
        this.theUser=JSON.parse(this.theUser);
        console.log(this.theUser);
        console.log("status of user account is:" +this.theUser.enabled);
        if(!this.theUser.enabled){
          Swal.fire("error","Sorry!! First verify your account","error");
        }
        else{
          this.loginService.login(this.user).subscribe(
            (data)=>{
              console.log(data);
             Swal.fire("success","You have successfully login","success");
            },
            (error)=>{
              console.log(error);
              Swal.fire("error","You can't logged In try again!!","error");
            }
          )
        }
      }
    )
   
  }

}
