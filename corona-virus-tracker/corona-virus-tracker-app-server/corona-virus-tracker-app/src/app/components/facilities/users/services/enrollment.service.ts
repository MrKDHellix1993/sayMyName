import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { User } from '../users.component';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {

  constructor(private http: HttpClient) { }

  public performUserDataEnrollment(user: User) : Observable<User> {
    let url: string = 'http://localhost:3000/enroll';
     return this.http.post<User>(url, user).pipe(catchError(this.errorHandler));
  }

  public errorHandler(error: HttpErrorResponse) {
    return throwError(error); 
  }
}
