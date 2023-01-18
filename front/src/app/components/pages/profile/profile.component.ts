import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { PostService } from 'src/app/services/post.service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  ids: string = '';
  formGroupProfil: FormGroup = new FormGroup({
    address: new FormControl('', [Validators.required]),
    phone: new FormControl('', [Validators.required]),
    id: new FormControl(''),
  });
  constructor(private route: ActivatedRoute, private http: HttpClient, private postService: PostService) {
    this.route.params.subscribe((params) => {
      this.ids = params['id'];
    });
  }
  ngOnInit(): void {
    console.log(this.ids);
  }
  update(formGroupProfil: FormGroup) {
    const body = formGroupProfil.value;
    body.id = localStorage.getItem('id');
    console.log(body);
    this.postService.update(body.phone, body.address,body.id).subscribe((data) => {
      console.log("phone",body.phone);
      console.log("address",body.address);
      console.log("id",body.id);
      console.log(data);
    },
    (error) => {
      console.log(error);
    });
  }
}
