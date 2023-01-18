import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  constructor(private http: HttpClient) {}
  getAuthHeaders() {
    return new HttpHeaders().set(
      'Authorization',
      'Bearer ' + localStorage.getItem('token')
    );
  }

  addComment(comment: string, postId: string, ): Observable<any> {
    const date = new Date();
    const time = date.toLocaleTimeString();
    const month = date.toLocaleString('default', { month: 'long' });
    const day = date.getDate();
    const dateString = month + ' ' + day;
    return this.http.post<any>(
      'http://localhost:8080/comments/add',
      {
        comment,
        post_id: postId,
        person_id: localStorage.getItem('id'),
        date: dateString,
        time: time,
      },
      { headers: this.getAuthHeaders() }
    );
  }

  addPost(title: string, description: string): Observable<any> {
    const date = new Date();
    const time = date.toLocaleTimeString();
    const month = date.toLocaleString('default', { month: 'long' });
    const day = date.getDate();
    const dateString = month + ' ' + day;
    return this.http.post<any>(
      'http://localhost:8080/post/new',
      {
        title,
        description,
        person_id: localStorage.getItem('id'),
        date: dateString,
        time: time,
      },
      { headers: this.getAuthHeaders() }
    );
  }
  update(phone: string, address: string, id: string): Observable<any> {
    return this.http.post<any>(
      'http://localhost:8080/auth/update',
      {
        phone,
        address,
        id,
      }
    );
  }

}
