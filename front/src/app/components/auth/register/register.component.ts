import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService } from 'src/app/services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  email = '';
  password = '';
  name = '';
  address = '';
  phone = '';
  constructor(private registerService: RegisterService, private router: Router) {}
  register() {
    this.registerService.register(this.name,this.address,this.phone,this.email,this.password).subscribe(
      (data) => {
        console.log('account created successfully');
      
        //navigate to login page
        this.router.navigate(['/login']);
      },

      (error) => {
        console.log(error);
      }
    );
  }
}
