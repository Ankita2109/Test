import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  json: any;
 isloggedin=false;
  success=false;
  error=false;
  login = new FormGroup({
    /* name: new FormControl(''), */
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });
  constructor(private loginService: LoginService, private service: AuthService, private router: Router) { }

  ngOnInit() {
  }
  authenticate() {

    this.loginService.toLogin(this.login.value).subscribe(
      data => {
        console.log("authenticate")
        console.log(data)
        if (data.authenticated && data.user.role.id == 2) {
          // this.service.login();
          this.service.setLoggedin(this.isloggedin);  
          this.service.setLoggedin(true);
          this.service.setEmail(data.user.email);
          // this.service.email = data.user.email;
          this.service.setRole(data.user.role.userRole.id);   
          //this.service.setLanguageCode(data.user.language.languageCode);
          this.service.languageCode=data.user.language.languageCode;
          this.service.languageId = data.user.language.id;
          // console.log(data.user.language.name);
          console.log(data.user.language.languageCode);
          this.router.navigate(['/news']);
        }
        else if (data.authenticated && data.user.role.id == 1) {
          this.service.email = data.user.email;
          this.service.setRole(data.user.role.userRole); 
          this.isloggedin=true
          this.service.setLoggedin(this.isloggedin);  
          //this.service.setLanguageCode(data.user.language.languageCode);
          this.service.languageCode=data.user.language.languageCode;
         // this.service.setLanguageId(data.user.language.languageId);
         this.service.languageId = data.user.language.languageId;
          // console.log(data.user.language.name);
          console.log(data.user.language.languageCode);
          this.router.navigate(['/search']);
            }
      },
       error => {
        this.error = error;
      });

this.login.reset();
  }
  signup(){
    this.router.navigate(['/signup']);
  }
}