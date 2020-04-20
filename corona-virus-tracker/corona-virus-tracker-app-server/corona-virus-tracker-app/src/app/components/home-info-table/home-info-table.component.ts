import { Component, OnInit, ViewChild } from '@angular/core';
import { HomeInfoTableDataService } from './home-info-table-data.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'home-info-table',
  templateUrl: './home-info-table.component.html',
  styleUrls: ['./home-info-table.component.scss']
})
export class HomeInfoTableComponent implements OnInit {

  public totalNewCases: Number;
  public prevDffNewRegCasesOverGlob: Number;
  public coroVirusStatSummary: Cvt.CoronaVirsuStatSummay;
  public displayedColumns: string[] = ['srNumber', 'state', 'country', 'latestToltCases', 'newCasesFromPreviousDate'];
  public dataSource: any;

  @ViewChild(MatPaginator, { static: true })
  paginator: MatPaginator;
  constructor(private dataService: HomeInfoTableDataService) { }

  ngOnInit(): void {
    this.dataService.fetchLatestCoronaVirusRegisteredCases().subscribe(
      (res: Cvt.CoronaVirsuStatSummay) => {
        if (res) {
          console.log(res);
          this.totalNewCases = res.totalNewCasesOverGlob;
          this.prevDffNewRegCasesOverGlob = res.prevDffNewRegCasesOverGlob;
          this.coroVirusStatSummary = res;
          this.dataSource = new MatTableDataSource(this.coroVirusStatSummary.allLocationStats);
          this.dataSource.paginator = this.paginator;

        }
      }
    );
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
