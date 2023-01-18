import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  constructor(private http: HttpClient) {}

  register(name: string, address: string, phone: string, email: string, password: string): Observable<any> {
    return this.http.post<any>('http://localhost:8080/auth/register', {
      name,
      address,
      phone,
      email,
      password,
    });
  }
}
