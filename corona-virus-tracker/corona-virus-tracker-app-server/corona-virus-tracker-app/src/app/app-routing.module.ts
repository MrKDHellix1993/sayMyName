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
import { ArticleComponent } from './modules/article/article.component';
export const routes: Routes = [
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full'
  },
  {
    path: '',
    component: DefaultComponent,
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'login',
        component: LoginComponent,
      },
      {
        path: 'posts',
        component: PostComponent
      },
      {
        path: 'home',
        component: HomeInfoTableComponent
      },
      {
        path: 'register',
        component: FacilitiesComponent,
        loadChildren: () => import('./components/facilities/facilities.module').then(m => m.FacilitiesModule)
      },
      {
        path: 'articles/:id',
        component: ArticleComponent
      },
      {
        path: '**',
        component: NoPageFoundComponent
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
