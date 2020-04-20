import { DefaultComponent } from './components/layouts/default/default.component';
import { NoPageFoundComponent } from './components/no-page-found/no-page-found.component';
import { HomeInfoTableComponent } from './components/home-info-table/home-info-table.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FacilitiesComponent } from './components/facilities/facilities.component';
import { DashboardComponent } from './modules/dashboard/dashboard.component';
import { PostComponent } from './modules/posts/post.component';
import { AuthGuard } from './auth/authguard';
import { LoginComponent } from './auth/login/login.component';
export const routes: Routes = [
  {
    path: '',
    component : DefaultComponent,
    // canActivate: [AuthGuard],
    children : [
      {
      path: '',
      component: DashboardComponent,
      canActivate: [AuthGuard]
      },
      {
        path: 'login',
        component : LoginComponent
      },
      {
        path : 'posts',
        component : PostComponent
      },
      {
        path: 'home',
        component: HomeInfoTableComponent
      },
      {
        path: '**',
        component: NoPageFoundComponent
      },
    ]
  } ,
  {
    path: 'feature',
    loadChildren: () => import('./components/feature/feature.module').then(m => m.FeatureModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'facilities',
    component: FacilitiesComponent,
    loadChildren: () => import('./components/facilities/facilities.module').then(m => m.FacilitiesModule),
    canActivate: [AuthGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
