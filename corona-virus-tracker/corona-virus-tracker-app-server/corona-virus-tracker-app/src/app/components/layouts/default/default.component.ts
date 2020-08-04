import { Component, OnInit, Input } from '@angular/core';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-default',
  templateUrl: './default.component.html',
  styleUrls: ['./default.component.scss']
})
export class DefaultComponent implements OnInit {

  public openSideNavBar: boolean = false;
  @Input()
  public isUserLoggedIn: boolean = false;

  constructor(private authService: AuthService) { }
  ngOnInit(): void {
  }

  public ngAfterViewChecked(): void {
    if(sessionStorage && sessionStorage.getItem('token')){
      this.isUserLoggedIn = true;
    }else{
      this.isUserLoggedIn = false;
      sessionStorage.setItem('showDashboard', 'false');
    }
  }

  public openSideNavBarTab() {
    this.openSideNavBar = !this.openSideNavBar;
  }
}
