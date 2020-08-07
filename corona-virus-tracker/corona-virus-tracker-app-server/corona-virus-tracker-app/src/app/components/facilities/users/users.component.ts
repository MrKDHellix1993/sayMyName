import { EnrollmentService } from './services/enrollment.service';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { FormGroup, FormBuilder } from '@angular/forms';
import { passwordMissmatchChecker } from '../../common-validations/validation-function';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  constructor(private formBuilder: FormBuilder ,private enrollmentService: EnrollmentService) { }
  public timePreference: string = 'morning';
  public successMsg: string;
  public errorMsg: string;
  public userData: User;
  public isErrorInSelection = true;
  public isFromSubmitted = false;
  public symptomsList = ['Respiratory Symptoms', 'Fever', 'Shortness of Breath'];
  public registrationForm: FormGroup;
  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group(
      {
        password: [''],
        confirmpassword: [''],
      }, { validator: passwordMissmatchChecker });

    this.userData = {
      username: 'Kalidas',
      email: 'kd@outlook.com',
      password : "kd@123",
      telephone: 9855666399,
      symptom: 'default',
      timePreference: 'morning',
      subscribe: true
    }
  }

  public validateSymptonSelection(value: String) {
    this.isErrorInSelection = (value === 'default') ? true : false;
  }

  public onSubmit() {
    let password : string = this.registrationForm.get('password').value;
    if(password){
      this.userData.password = password;
    }
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
    public password: string,
    public telephone: number,
    public symptom: string,
    public timePreference: string,
    public subscribe: boolean
  ) { }
}
