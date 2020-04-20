import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment'
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private http: HttpClient) { }

  public fetchLatestCoronaVirusRegisteredCases() : Observable<Cvt.CoronaVirsuStatSummay>
  {
    let url: string = environment.apiUrl + "/home";
        return this.http.get<Cvt.CoronaVirsuStatSummay>(url).pipe(((res) => res));
  }

  public getDashboardChartData() {
    /*  let url: string = environment.apiUrl + "/home";
         return this.http.get<Cvt.CoronaVirsuStatSummay>(url).pipe(((res) => res)); */
    let areaReport = {};

    areaReport = {
      name: 'Asia',
      data: [502, 635, 809, 947, 1402, 3634, 5268]
    }, {
      name: 'Africa',
      data: [106, 107, 111, 133, 221, 767, 1766]
    }, {
      name: 'Europe',
      data: [163, 203, 276, 408, 547, 729, 628]
    }, {
      name: 'America',
      data: [18, 31, 54, 156, 339, 818, 1201]
    }, {
      name: 'Oceania',
      data: [2, 2, 2, 6, 13, 30, 46]
    }
    , {
      name: 'India',
      data: [12, 20, 20, 68, 13, 30, 46]
    }


    return areaReport;
  }
}
