import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { SearchComponent } from './search/search.component';
import { LoginComponent } from './login/login.component';
import { NewsArticleComponent } from './news-article/news-article.component';
import { FavouriteArticleComponent } from './favourite-article/favourite-article.component';

const routes: Routes = [
  { path:"",component:LoginComponent },
  //{ path:"login",component:LoginComponent },
  { path:"signup" ,component:SignupComponent },
  { path:"news" ,component:NewsArticleComponent },
  { path:"search" ,component:SearchComponent },
  { path:"list" ,component:FavouriteArticleComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
