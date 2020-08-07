import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.scss']
})
export class SideBarComponent implements OnInit {
  
  public links = ['/', '/home' , '/articles'];
  constructor( private router: Router) { }

  ngOnInit(): void {
  }

  public navigate() : void{
    this.router.navigate(['/articles' , "1" ]);
  }
}
