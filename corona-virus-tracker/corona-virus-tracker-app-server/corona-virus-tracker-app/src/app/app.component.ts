import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MatTabChangeEvent } from '@angular/material/tabs';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'corona-virus-tracker-app';

  constructor(private router: Router) { }

  public OnTabChange(event: MatTabChangeEvent) {
    if (event.index === 0) {
      this.router.navigate(["home"]);
    }
    else if (event.index === 1) {
      this.router.navigate(["facilities"]);
    }
    else if (event.index === 2) {
      this.router.navigate(["feature"]);
    }
  }
}
