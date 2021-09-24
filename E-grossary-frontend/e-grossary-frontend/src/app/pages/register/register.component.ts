import { MatSnackBar } from '@angular/material/snack-bar';
import { RegistrationService } from './../../services/registration.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user:any={"username":"","firstname":"","lastname":"","email":"","phonenumber":"","password":"","address":""};


  constructor(private registrationService:RegistrationService,private router:Router,private snackBar:MatSnackBar) { }

  ngOnInit(): void {
  }

  registerUser(){

    if(this.user.username==null||this.user.username==''){
      this.snackBar.open("username can't be empty or null!!","ok",{duration:3000});
      return;
    }
    if(this.user.email==null||this.user.email==''){
      this.snackBar.open("useremail can't be empty or null!!","ok",{duration:3000});
      return;
    }
    if(this.user.firstname==null||this.user.firstname==''){
      this.snackBar.open("user first name can't be empty or null!!","ok",{duration:3000});
      return;
    }
    if(this.user.lastname==null||this.user.lastname==''){
      this.snackBar.open("user lastname can't be empty or null!!","ok",{duration:3000});
      return;
    }
    if(this.user.phonenumber==null||this.user.phonenumber==''){
      this.snackBar.open("user phone number can't be empty or null!!","ok",{duration:3000});
      return;
    }
    if(this.user.address==null||this.user.address==''){
      this.snackBar.open("user address can't be empty or null!!","ok",{duration:3000});
      return;
    }

    this.registrationService.doregistration(this.user).subscribe(
      (data)=>{
        //console.log("user data from db register is"+data);
        Swal.fire("success","You have successfully registered,verify your account before login","success");
        this.router.navigate(['/login']);
      },
      (error)=>{
        console.log(error);
        Swal.fire("error","You can't be registered,try again!!","error");
      }
    )
     
  }

}
