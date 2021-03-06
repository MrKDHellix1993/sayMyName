import { UsersComponent } from './users/users.component';
import { AdminComponent } from './admin/admin.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'users',
        component : UsersComponent,
        loadChildren: () => import('./users/users.module').then(m => m.UsersModule)
      },
      {
        path : 'admin',
        component : AdminComponent
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FacilitiesRoutingModule { }
