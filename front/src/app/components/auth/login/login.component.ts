import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService],
})
export class LoginComponent {
  email = '';
  password = '';
  constructor(private loginService: LoginService, private router: Router) {}
  login() {
    this.loginService.login(this.email, this.password).subscribe(
      (data) => {
        console.log('login success');
        //store id and name and token at localstorage
        localStorage.setItem('id', data.id);
        localStorage.setItem('name', data.name);
        localStorage.setItem('token', data.token);
        //redirect to home page using router
        this.router.navigate(['/']);
      },

      (error) => {
        console.log(error);
      }
    );
  }
}
