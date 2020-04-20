import { AbstractControl, ValidatorFn } from '@angular/forms';


export function perform3NumberChek(control: AbstractControl): { [key: string]: any } | null {
    let isError: boolean;
    if (control.value) {
        let val: string = control.value;
        if (val.length >= 3) {
            let numval: Number = new Number(val.substr(0, 3));
            if (numval?.toString() != 'NaN') {
                isError = false;
            } else {
                isError = true;
            }
        } else {
            isError = true;
        }
    }
    return isError ? { 'is3NumChar': { value: control.value } } : null;
}

export function performSpamRegistrationCheck(forbidon: RegExp): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } | null => {
        const forbidonName = forbidon.test(control.value);
        return forbidonName ? { 'forbidonName': { value: control.value } } : null;
    }
}

export function passwordMissmatchChecker(control: AbstractControl): { [key: string]: boolean } | null {
    const passwordField = control.get('password');
    const confirmPasswordField = control.get('confirmpassword')
    if (passwordField.pristine || confirmPasswordField.pristine) {
        return null;
    }
    return passwordField && confirmPasswordField && (passwordField?.value !== confirmPasswordField?.value ? { 'missMatch': true} : null);
}
