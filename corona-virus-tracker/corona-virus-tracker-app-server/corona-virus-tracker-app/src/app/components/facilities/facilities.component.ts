import { MatTabChangeEvent } from '@angular/material/tabs';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-facilities',
  templateUrl: './facilities.component.html',
  styleUrls: ['./facilities.component.scss']
})
export class FacilitiesComponent implements OnInit {

  constructor(private router : Router) { }

  ngOnInit(): void {
  }

  public OnTabChange(event: MatTabChangeEvent) {
    if (event.index === 0) {
      this.router.navigate(["facilities/users"]);
    }
    else if (event.index === 1) {
      this.router.navigate(["facilities/admin"]);
    }
  }
}
