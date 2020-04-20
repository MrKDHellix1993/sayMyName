import { Component, OnInit, Output ,EventEmitter } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  constructor() { }

  @Output()
  public toggleSideNavFromHeader : EventEmitter<Boolean> = new EventEmitter();

  ngOnInit(): void {
  }
  public toggleSideNavBar(){
    this.toggleSideNavFromHeader.emit();
  }
}
