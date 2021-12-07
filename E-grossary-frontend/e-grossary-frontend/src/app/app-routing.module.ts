import { UserViewProductsComponent } from './pages/user/user-view-products/user-view-products.component';
import { AdminProductDetailsComponent } from './pages/admin/admin-product-details/admin-product-details.component';
import { CartDetailsComponent } from './pages/user/cart-details/cart-details.component';
import { ProductDetailsComponent } from './pages/user/product-details/product-details.component';
import { UserViewCategoryComponent } from './pages/user/user-view-category/user-view-category.component';
import { UserViewShopComponent } from './pages/user/user-view-shop/user-view-shop.component';
import { AddProductComponent } from './pages/admin/add-product/add-product.component';
import { AddCategoryComponent } from './pages/admin/add-category/add-category.component';
import { ListProductsComponent } from './pages/common/list-products/list-products.component';
import { ShopRegistrationComponent } from './pages/admin/shop-registration/shop-registration.component';
import { AdmindashboardComponent } from './pages/admin/admindashboard/admindashboard.component';
import { RegisterComponent } from './pages/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { UserdashboardComponent } from './pages/user/userdashboard/userdashboard.component';
import { ViewShopComponent } from './pages/admin/view-shop/view-shop.component';
import { ListCategoryComponent } from './pages/common/list-category/list-category.component';

const routes: Routes = [
  {path:'',component:HomeComponent,pathMatch:'full'},
  {path:'register',component:RegisterComponent,pathMatch:'full'},
  {path:'login',component:LoginComponent,pathMatch:'full'},
  {path:'user-dashboard',component:UserdashboardComponent,children:[
    {path:'',component:UserViewProductsComponent},
    {path:'view-shop/:id',component:UserViewShopComponent},
    {path:'view-shop/view-category/:id',component:UserViewCategoryComponent},
    
    {path:'cart-details',component:CartDetailsComponent},
    {path:'product-details/:id',component:ProductDetailsComponent},
  ]},
  {path:'admin-dashboard',component:AdmindashboardComponent,children:[
    {path:'shop-register',component:ShopRegistrationComponent},
    {path:'shop/:id/add-category',component:AddCategoryComponent},
    {path:'view-shop/:id',component:ViewShopComponent},
    {path:'view-products',component:ListProductsComponent},
    {path:'add-product/:id',component:AddProductComponent},
    {path:'view-shop/:id/view-category',component:ListCategoryComponent},
    {path:'product-details/:id',component:AdminProductDetailsComponent},

  ]}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }
