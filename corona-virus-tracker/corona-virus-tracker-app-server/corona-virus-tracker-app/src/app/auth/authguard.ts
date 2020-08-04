import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    const url: string = state.url;
    return this.checkLogin(url);
  }

  checkLogin(url: string): boolean {
    /* if (this.authService.isLoggedIn) {
      sessionStorage.setItem('showDashboard', JSON.stringify(this.authService.isLoggedIn));
      return true;
    } */
    if (sessionStorage && sessionStorage.getItem('token')) {
      sessionStorage.setItem('showDashboard', 'true');
      return true;
    } else {
      // Store the attempted URL for redirecting
      this.authService.redirectUrl = url;
      // Navigate to the login page with extras
      sessionStorage.setItem('showDashboard', JSON.stringify(this.authService.isLoggedIn));
      this.router.navigate(['/login']);
      return false;
    }
  }
}
