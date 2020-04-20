import { EnrollmentService } from './../users/services/enrollment.service';
import { Component, OnInit } from '@angular/core';
// import { FormGroup, FormControl } from '@angular/forms';
import { FormBuilder, Validators, FormGroup, FormArray } from '@angular/forms';
import { performSpamRegistrationCheck, perform3NumberChek, passwordMissmatchChecker } from '../../common-validations/validation-function';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
  isFromSubmitted: boolean;
  successMsg: string;
  errorMsg: string;

  constructor(private formBuilder: FormBuilder, private enrollmentService : EnrollmentService) { }

  /*  public registrationForm = new FormGroup(
     {
       username: new FormControl('Kalidas'),
       password: new FormControl(''),
       confirmpassword: new FormControl(''),
       address: new FormGroup(
         {
           street: new FormControl(''),
           city: new FormControl(''),
           state: new FormControl(''),
         })
     });
  */

  public registrationForm: FormGroup;

  get userName() {
    return this.registrationForm.get('userName');
  }

  get email() {
    return this.registrationForm.get('email');
  }

  get alternateEmail() {
    return this.registrationForm.get('alternateEmail') as FormArray;
  }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group(
      {
        userName: ['', [Validators.required, Validators.minLength(3), performSpamRegistrationCheck(/admin/), , performSpamRegistrationCheck(/password/), perform3NumberChek]],

        password: [''],
        confirmpassword: [''],
        email: [''],
        subscribe: [''],
        address: this.formBuilder.group(
          {
            street: [''],
            city: [''],
            state: [''],
          }
        ),
        alternateEmail: this.formBuilder.array([])

      }, { validator: passwordMissmatchChecker });

    this.registrationForm.get('subscribe').valueChanges.subscribe(
      isSubscribe => {
        if (isSubscribe) {
          this.registrationForm.get('email').setValidators(Validators.required);
        } else {
          this.registrationForm.get('email').clearValidators();
        }
        this.registrationForm.get('email').updateValueAndValidity();
      }
    );
  }

  public addalternateEmailField() : void{
    this.alternateEmail.push(this.formBuilder.control(''));
  }
  
  public loadDataOnDemand() {
    this.registrationForm.setValue(
      {
        userName: 'Kalidas',
        password: '123',
        confirmpassword: '123',
        email: 'kalidas@gmil.com',
        subscribe: true,
        address:
        {
          street: 'Mumbai',
          city: 'Mumbai',
          state: '400750',
        }
      })
  }

  public onSubmit(){
    this.enrollmentService.performUserDataEnrollment(this.registrationForm.value).subscribe(
      (res) => {
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
