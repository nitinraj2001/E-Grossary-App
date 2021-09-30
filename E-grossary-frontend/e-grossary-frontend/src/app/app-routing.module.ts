import { ShopRegistrationComponent } from './pages/admin/shop-registration/shop-registration.component';
import { AdmindashboardComponent } from './pages/admin/admindashboard/admindashboard.component';
import { RegisterComponent } from './pages/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { UserdashboardComponent } from './pages/user/userdashboard/userdashboard.component';
import { ViewShopComponent } from './pages/admin/view-shop/view-shop.component';

const routes: Routes = [
  {path:'',component:HomeComponent,pathMatch:'full'},
  {path:'register',component:RegisterComponent,pathMatch:'full'},
  {path:'login',component:LoginComponent,pathMatch:'full'},
  {path:'user-dashboard',component:UserdashboardComponent,pathMatch:'full'},
  {path:'admin-dashboard',component:AdmindashboardComponent,children:[
    {path:'shop-register',component:ShopRegistrationComponent},
    {path:'view-shop/:id',component:ViewShopComponent}
  ]}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }
