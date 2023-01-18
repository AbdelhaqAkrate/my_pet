import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css'],
})
export class PostComponent implements OnInit {
  constructor(private http: HttpClient, private postService: PostService) {}

  formGroupComment: FormGroup = new FormGroup({
    comment: new FormControl('', [Validators.required]),
    post_id: new FormControl(''),
    person_id: new FormControl(''),
    date: new FormControl(''),
    time: new FormControl(''),
  });

  posts: any = [];
  comments: any = [];
  replies: any = [];
  mycomment: string = '';
  title: string = '';
  content: string = '';
  showComments = false;
  showReplies = false;
  id = localStorage.getItem('id');
  ngOnInit(): void {
    this.getPosts();
  }

  getPosts() {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      Authorization: 'Bearer ' + token,
    });
    console.log(token);
    this.http
      .get('http://localhost:8080/comments/all', { headers: headers })
      .subscribe((data) => {
        this.comments = data;
        console.log("comment",this.comments);
      });
    this.http
      .get('http://localhost:8080/post/all', { headers: headers })
      .subscribe((data) => {
        this.posts = data;
        console.log(this.posts);
      });
    this.http
      .get('http://localhost:8080/replay/all', { headers: headers })
      .subscribe((data) => {
        this.replies = data;
        console.log(this.replies);
      });
  }
  addComment(formGroupComment: FormGroup, postId: string) {
    const date = new Date();
    const time = date.toLocaleTimeString();
    const month = date.toLocaleString('default', { month: 'long' });
    const day = date.getDate();
    const dateString = month + ' ' + day;
    const token = localStorage.getItem('token');


    const body = formGroupComment.value;
    body.post_id = postId;
    body.person_id = localStorage.getItem('id');
    body.date = dateString;
    body.time = time;
    console.log('body => ', body);
    this.postService.addComment(body.comment, postId).subscribe(
      (data) => {
        console.log('comment added', data);
        this.getPosts();
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
