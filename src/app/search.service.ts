import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  url: string = "/signupService/signup/analystDetail/";
  url1: string = "/signupService/signup/saveUserStatus/";
  constructor(private http: HttpClient) { }

  getAnalyst (email): Observable<any> {
    return this.http.get<any>(this.url+email);
  }

  analystStatus(email): Observable<any>{    
    console.log(email)
    return this.http.get<any>(this.url1+email);
  }
}
