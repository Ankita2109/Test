import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { DebugElement } from '@angular/core';
import { By, BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { LoginService } from '../login.service';
import { SignupComponent } from '../signup/signup.component';
import { Routes } from '@angular/router';

fdescribe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let de : DebugElement;
  let dl : DebugElement;
  let df : DebugElement;
  let el : HTMLElement;


  beforeEach(async(() => {
    const routes: Routes = [
      { path : "", component: LoginComponent},
      { path : "login", component: LoginComponent},
      { path : "signup", component: SignupComponent},
     ];
     
    TestBed.configureTestingModule({
      declarations: [ LoginComponent, SignupComponent ],
      imports : [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        RouterTestingModule
      ],
       providers : [
    { provide : LoginService }
  ]
    })
    .compileComponents().then(() =>{
      fixture = TestBed.createComponent(LoginComponent);
      component = fixture.componentInstance;

      de = fixture.debugElement.query(By.css('form'));
      dl = fixture.debugElement.query(By.css('a'));
      df = fixture.debugElement.query(By.css('input'));
      el = de.nativeElement;

    });
  }));

 /*  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }); */

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form should valid when field is not empty',async(()=> {
    //accessing controls
    component.login.controls['email'].setValue('kakakkakaka@gmail.com');
    component.login.controls['password'].setValue('kakakkaka');
    expect(component.login.valid).toBeTruthy();
  }));

  it('form should invalid when field is empty',async(()=> {
    //accessing controls
    component.login.controls['email'].setValue('');
    component.login.controls['password'].setValue('');
    expect(component.login.valid).toBeFalsy();
  }));

  it('should call the authenticate method', async(()=> {
    fixture.detectChanges();
    spyOn(component, 'authenticate');
    el =fixture.debugElement.query(By.css('input')).nativeElement;
    el.click();
    expect(component.authenticate).toHaveBeenCalledTimes(0);
  }));

});
