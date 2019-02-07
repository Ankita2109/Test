import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })
};
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  url: string = "/signupService/authenticate";
  constructor(private http: HttpClient) { }
  toLogin (user): Observable<any> {
    return this.http.post<any>(this.url,user, httpOptions);
  }
}
