import { Component, OnInit, ViewChild } from '@angular/core';
import { DefaultComponent } from 'src/app/components/layouts/default/default.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor() { }
  @ViewChild(DefaultComponent)
  private defaultComponent : DefaultComponent;

  ngOnInit(): void {
    if(localStorage.getItem('showDashboard')){
      console.log('showDB in db COMPONENT' , localStorage.getItem('showDashboard'));
      if(localStorage.getItem('showDashboard')=='true')
      {
        if(this.defaultComponent){
          this.defaultComponent.isUserLoggedIn = true;
        }
      }
    }
  }

}
