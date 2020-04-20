import { EnrollmentService } from './services/enrollment.service';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  constructor(private enrollmentService: EnrollmentService) { }
  public timePreference: string = 'morning';
  public successMsg: string;
  public errorMsg: string;
  public userData: User;
  public isErrorInSelection = true;
  public isFromSubmitted = false;
  public symptomsList = ['Respiratory Symptoms', 'Fever', 'Shortness of Breath'];
  ngOnInit(): void {
    this.userData = {
      username: 'Kalidas',
      email: 'kd@outlook.com',
      telephone: 98556663,
      symptom: 'default',
      timePreference: 'morning',
      subscribe: true
    }
  }

  public validateSymptonSelection(value: String) {
    this.isErrorInSelection = (value === 'default') ? true : false;
  }

  public onSubmit() {
    this.enrollmentService.performUserDataEnrollment(this.userData).subscribe(
      (res : User) => {
        if (res) {
          this.isFromSubmitted = true;
          console.log('Success', res);
          this.successMsg = 'Form Submitted Successfully'
        }
      },
      (error : HttpErrorResponse) => {
       this.errorMsg = error.statusText;
        console.log(error);
      }
    )
  }
}

export class User {
  constructor(
    public username: string,
    public email: string,
    public telephone: number,
    public symptom: string,
    public timePreference: string,
    public subscribe: boolean
  ) { }
}
