import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, config } from 'rxjs';
//import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LanguageService {
  url: string = "/signupService/signup/language";
  constructor(private http: HttpClient) { }
  getAllLanguage (): Observable<any> {
    return this.http.get<any>(this.url);
  }
  }

