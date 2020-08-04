import { AuthService } from './../../../auth.service';
import { Component, OnInit, Output ,EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  constructor(private authService : AuthService,private router : Router) { }

  @Output()
  public toggleSideNavFromHeader : EventEmitter<Boolean> = new EventEmitter();

  ngOnInit(): void {
  }

  public toggleSideNavBar(){
    this.toggleSideNavFromHeader.emit();
  }

  public logout(){
    this.authService.logout().subscribe(res => {
      if (res) {
        sessionStorage.clear();
        this.router.navigate(['/login']);
      }
    }, (err) => {
      console.log(err);
    });
  }
}
