import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/auth/login/login.component';
import { HomeComponent } from './components/pages/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { PostComponent } from './components/pages/post/post.component';
import { ProfileComponent } from './components/pages/profile/profile.component';
import { NavbarComponent } from './components/pages/navbar/navbar.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { ModalComponent } from './components/modal/modal.component';


@NgModule({
  declarations: [AppComponent, LoginComponent, HomeComponent, PostComponent, ProfileComponent, NavbarComponent, RegisterComponent, ModalComponent],
  imports: [BrowserModule, AppRoutingModule, FormsModule,ReactiveFormsModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
