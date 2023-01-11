import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import { LoginComponent } from './components/auth/login/login.component';
import { AuthGuardService } from './services/auth-guard.service';

const routes: Routes = [];
routes.push({ path: '', component: HomeComponent });

@NgModule({
  imports: [
    RouterModule.forRoot(
      [
        { path: '', component: HomeComponent, canActivate: [AuthGuardService] },
        { path: 'login', component: LoginComponent },
      ],
      { scrollPositionRestoration: 'enabled' }
    ),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}
