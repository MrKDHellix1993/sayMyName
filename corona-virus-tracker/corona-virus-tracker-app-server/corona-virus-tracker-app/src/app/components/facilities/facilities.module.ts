import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FacilitiesRoutingModule } from './facilities-routing.module';
import { FacilitiesComponent } from './facilities.component';
import { UsersModule } from './users/users.module';
import { DemoMaterialModule } from '../../material.vendor/material-module';
import { AdminComponent } from './admin/admin.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [FacilitiesComponent, AdminComponent],
  imports: [
    CommonModule,
    UsersModule,
    FacilitiesRoutingModule,
    ReactiveFormsModule,
    DemoMaterialModule
  ],
  exports : [
    UsersModule
  ]
})
export class FacilitiesModule { }
