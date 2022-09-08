import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { map, Observable } from 'rxjs';
import { InscriptionService } from 'src/app/services/inscription.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  form: FormGroup;
  password: FormControl;

  constructor(
    private inscriptionService: InscriptionService,
    private router: Router
  ) {
    this.password = new FormControl('', [
      Validators.required,
      Validators.pattern(
        /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[*?.@!=+#]).{4,20}$/
      ),
    ]);

    this.form = new FormGroup({
      loginCtrl: new FormControl('', Validators.required, this.checkLogin()),
      passwordGroup: new FormGroup(
        {
          passwordCtrl: this.password,
          confirmCtrl: new FormControl(''),
        },
        this.equals
      ),
    });
  }

  checkLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.inscriptionService.checkUtilisateurExist(control.value).pipe(
        map((result) => {
          return result ? { notUnique: true } : null;
        })
      );
    };
  }

  equals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    return group.get('passwordCtrl')?.value == group.get('confirmCtrl')?.value
      ? null
      : { notequals: true };
  }

  ngOnInit(): void {}

  submit() {
    let utilisateur = {
      login: this.form.get('loginCtrl')?.value,
      pass: this.form.get('passwordGroup.passwordCtrl')?.value,
    };
    this.inscriptionService.inscription(utilisateur).subscribe({
      next: (result) => {
        this.router.navigateByUrl('/home');
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
        this.form.get('loginCtrl')?.setErrors({ notUnique: true });
      },
    });
  }
}
