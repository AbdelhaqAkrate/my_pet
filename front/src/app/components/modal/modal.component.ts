import { Component, Input } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { PostService } from 'src/app/services/post.service';
@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css'],
})
export class ModalComponent {
  @Input() isOpen: boolean = false;
  constructor(private http: HttpClient, private postService: PostService) {}
  posts: any = [];
  closeModal() {
    this.isOpen = false;
  }
  openModal() {
    this.isOpen = true;
  }

  formGroupPost: FormGroup = new FormGroup({
    title: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
    person_id: new FormControl(''),
    date: new FormControl(''),
    time: new FormControl(''),
  });
  getPosts() {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      Authorization: 'Bearer ' + token,
    });
     this.http
       .get('http://localhost:8080/post/all', { headers: headers })
       .subscribe((data) => {
         this.posts = data;
         console.log(this.posts);
       });
  }
  addPost(formGroupPost: FormGroup) {
    const date = new Date();
    const time = date.toLocaleTimeString();
    const month = date.toLocaleString('default', { month: 'long' });
    const day = date.getDate();
    const dateString = month + ' ' + day;
    const token = localStorage.getItem('token');

    const body = formGroupPost.value;
    body.person_id = localStorage.getItem('id');
    body.date = dateString;
    body.time = time;
    console.log('body => ', body);
    this.postService.addPost(body.title, body.description).subscribe(
      (data) => {
        console.log('post added', data);
        this.getPosts();
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
