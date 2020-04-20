import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA  } from '@angular/core';
import { HTTP_INTERCEPTORS , HttpClientModule } from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
// import { FacilitiesModule } from './components/facilities/facilities.module';
import { AppComponent } from './app.component';
// import { HomeInfoTableComponent } from './components/home-info-table/home-info-table.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DemoMaterialModule } from './material.vendor/material-module';
import { NoPageFoundComponent } from './components/no-page-found/no-page-found.component';
import { DefaultModule } from './components/layouts/default/default/default.module';
import { LoginComponent } from './auth/login/login.component';
import { FormsModule }   from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthInterceptor } from './auth/http-interceptor/auth-interceptor';
@NgModule({
  declarations: [
    AppComponent,
    NoPageFoundComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    DemoMaterialModule,
    DefaultModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    {
      provide : HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi   : true,
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
