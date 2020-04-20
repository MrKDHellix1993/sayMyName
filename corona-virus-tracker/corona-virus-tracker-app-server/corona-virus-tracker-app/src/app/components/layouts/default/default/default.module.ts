import { HomeInfoTableComponent } from './../../../home-info-table/home-info-table.component';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DefaultComponent } from './../default.component';
import { DashboardComponent } from '../../../../modules/dashboard/dashboard.component';
import { PostComponent } from '../../../../modules/posts/post.component';
import { SharedModule } from 'src/app/shared/shared.module';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatDividerModule} from '@angular/material/divider';
import { DemoMaterialModule } from './../../../../material.vendor/material-module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule }   from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    DefaultComponent,
    DashboardComponent,
    PostComponent,
    HomeInfoTableComponent
  ],
  
  imports: [
    CommonModule,
    RouterModule,
    SharedModule,
    MatSidenavModule,
    MatDividerModule,
    DemoMaterialModule,
    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class DefaultModule { }
