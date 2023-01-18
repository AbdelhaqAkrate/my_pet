import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import { LoginComponent } from './components/auth/login/login.component';
import { AuthGuardService } from './services/auth-guard.service';
import { ProfileComponent } from './components/pages/profile/profile.component';
import { RegisterComponent } from './components/auth/register/register.component';

const routes: Routes = [];
routes.push({ path: '', component: HomeComponent });

@NgModule({
  imports: [
    RouterModule.forRoot(
      [
        { path: '', component: HomeComponent, canActivate: [AuthGuardService] },
        { path: 'login', component: LoginComponent },
        { path: 'register', component: RegisterComponent},
        {path: 'profile/:id', component: ProfileComponent, canActivate: [AuthGuardService] },
      ],
      { scrollPositionRestoration: 'enabled' }
    ),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}
