import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { FooterComponent } from './components/footer/footer.component';
import { RegisterComponent } from './pages/register/register.component';
import { LoginComponent } from './pages/login/login.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import Swal from 'sweetalert2';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdmindashboardComponent } from './pages/admin/admindashboard/admindashboard.component';
import { UserdashboardComponent } from './pages/user/userdashboard/userdashboard.component';
import { CartStatusComponent } from './pages/user/cart-status/cart-status.component';
import {MatCardModule} from '@angular/material/card';
import { ShopRegistrationComponent } from './pages/admin/shop-registration/shop-registration.component';
import { ViewShopComponent } from './pages/admin/view-shop/view-shop.component';
import { ListProductsComponent } from './pages/common/list-products/list-products.component';
import { ListCategoryComponent } from './pages/common/list-category/list-category.component';
import { AddCategoryComponent } from './pages/admin/add-category/add-category.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    FooterComponent,
    RegisterComponent,
    LoginComponent,
    AdmindashboardComponent,
    UserdashboardComponent,
    CartStatusComponent,
    ShopRegistrationComponent,
    ViewShopComponent,
    ListProductsComponent,
    ListCategoryComponent,
    AddCategoryComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatFormFieldModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    BrowserAnimationsModule,
    MatCardModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
