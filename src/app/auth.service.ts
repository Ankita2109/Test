import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
  // loggedIn = false;
  role: string;
  email: any;
  isDefaultAdmin=false;
  language:any;
  languageCode:any;
  languageId:any;
loggedin:boolean;
  getisDefaultAdmin() {
    return this.isDefaultAdmin;
  }
  setisDefaultAdmin(isDefaultAdmin:any) {
    this.isDefaultAdmin = isDefaultAdmin;
  }
  // login() {
  //   console.log("Inside auth service login()");
  //   this.loggedIn = true;
  // }

  // logout() {
  //   console.log("Inside auth service logout()");
  //   this.loggedIn = false;
  // }

  getLoggedin() {
    return this.loggedin;
  }
  setLoggedin(loggedin:boolean) {
    this.loggedin = loggedin;
  }

  getRole() {
    return this.role;
  }

  setRole(role: string) {
    this.role = role;
  }
  

  getEmail() {
    return this.email;
  }

  setEmail(email: any) {
    this.email = email;
  } 
   
  getLanguageCode(){
    return  this.languageCode;
   }
 
   setLanguageCode(languageCode:string){
       this.languageCode=languageCode;
    }

    getLanguageId(){
      return  this.languageId;
    }
     setLanguageId(languageId:string){
         this.languageId=languageId;
      }
}


  


