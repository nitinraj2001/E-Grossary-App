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
import {MatTableModule} from '@angular/material/table';
import { AddProductComponent } from './pages/admin/add-product/add-product.component';
import { UserViewShopComponent } from './pages/user/user-view-shop/user-view-shop.component';
import { UserViewCategoryComponent } from './pages/user/user-view-category/user-view-category.component';
import { ProductDetailsComponent } from './pages/user/product-details/product-details.component';
import { SearchComponent } from './components/search/search.component';
import { CartDetailsComponent } from './pages/user/cart-details/cart-details.component';
import { AdminProductDetailsComponent } from './pages/admin/admin-product-details/admin-product-details.component';
import { UserViewProductsComponent } from './pages/user/user-view-products/user-view-products.component';

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
    AddProductComponent,
    UserViewShopComponent,
    UserViewCategoryComponent,
    ProductDetailsComponent,
    SearchComponent,
    CartDetailsComponent,
    AdminProductDetailsComponent,
    UserViewProductsComponent,
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
    MatCardModule,
    MatTableModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
