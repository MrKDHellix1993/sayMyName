import { Component, OnInit, Input } from '@angular/core';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-default',
  templateUrl: './default.component.html',
  styleUrls: ['./default.component.scss']
})
export class DefaultComponent implements OnInit {
  constructor(private authService: AuthService) { }
  public openSideNavBar: boolean = false;
  public localStorage: Storage;
  @Input()
  public isUserLoggedIn: boolean = false;
  ngOnInit(): void {
  }

  public ngAfterViewChecked(): void {
    if (localStorage.getItem('showDashboard') == 'true') {
      console.log('this.authService.isLoggedIn  ',this.authService.isLoggedIn)
      this.isUserLoggedIn = true;
    }
  }

  public openSideNavBarTab() {
    this.openSideNavBar = !this.openSideNavBar;
  }
}
