import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { SearchComponent } from './search/search.component';
import { LoginComponent } from './login/login.component';
import { NewsArticleComponent } from './news-article/news-article.component';
import { FavouriteArticleComponent } from './favourite-article/favourite-article.component';
import { HeaderComponent } from './header/header.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { APP_BASE_HREF } from '@angular/common';
import { Routes } from '@angular/router';

fdescribe('AppComponent', () => {
  beforeEach(async(() => {
    const routes: Routes = [
      { path:"",component:LoginComponent },
      { path:"login",component:LoginComponent },
      { path:"signup" ,component:SignupComponent },
      { path:"news" ,component:NewsArticleComponent },
      { path:"search" ,component:SearchComponent },
      { path:"list" ,component:FavouriteArticleComponent }
    ];
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        SignupComponent,
        SearchComponent,
        LoginComponent,
        NewsArticleComponent,
        FavouriteArticleComponent,
        HeaderComponent,
       
      ],
      imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule
    
      ],
      providers: [ {provide : APP_BASE_HREF  , USE_VALUE:'/'}],
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'signup'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('signup');
  });

});
