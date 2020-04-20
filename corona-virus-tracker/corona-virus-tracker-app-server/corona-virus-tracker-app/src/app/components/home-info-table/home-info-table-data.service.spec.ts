import { TestBed } from '@angular/core/testing';

import { HomeInfoTableDataService } from './home-info-table-data.service';

describe('HomeInfoTableDataService', () => {
  let service: HomeInfoTableDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HomeInfoTableDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
