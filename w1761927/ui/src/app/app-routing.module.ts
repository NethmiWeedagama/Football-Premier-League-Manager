import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { ClubDetailsComponent } from './club-details/club-details.component';
import { MatchDetailsComponent } from './match-details/match-details.component';


const routes: Routes = [
  { path: '', redirectTo: 'home-page', pathMatch: 'full'},
  { path: 'club-details', component: ClubDetailsComponent },
  { path: 'match-details', component: MatchDetailsComponent },
  { path: 'home-page', component: HomePageComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

