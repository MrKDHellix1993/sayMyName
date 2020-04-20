import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {environment} from '../../../environments/environment'
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class HomeInfoTableDataService {

  constructor(private http : HttpClient) { }

  public fetchLatestCoronaVirusRegisteredCases() : Observable<Cvt.CoronaVirsuStatSummay>
  {
    let url: string = environment.apiUrl + "/home";
    this
        return this.http.get<Cvt.CoronaVirsuStatSummay>(url).pipe(((res) => res));
  }
}
