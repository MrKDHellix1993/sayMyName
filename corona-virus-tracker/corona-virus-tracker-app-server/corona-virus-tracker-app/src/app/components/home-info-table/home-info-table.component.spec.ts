import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeInfoTableComponent } from './home-info-table.component';

describe('HomeInfoTableComponent', () => {
  let component: HomeInfoTableComponent;
  let fixture: ComponentFixture<HomeInfoTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeInfoTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeInfoTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
