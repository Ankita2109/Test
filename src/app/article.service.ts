import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })
};

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  url: string = "/signupService/signup/articleList";
  url1: string = "/signupService/signup/getArticleList/";
  url2: string = "/signupService/signup/deleteArticles/";
  constructor(private http: HttpClient) { }
  apiKey: string = "57dba18fadf846b8b8be767eff96c3b5";

  articleNews(languageCode): Observable<any> {
    let newsUrl: string = "https://newsapi.org/v2/top-headlines?language="+languageCode+"&apiKey="+this.apiKey;
     return this.http.get(newsUrl);

  }

  favouriteArticleAdd(json): Observable<any> {
    return this.http.post<any>(this.url,json,httpOptions);

  }

  deleteArticle(json): Observable<any> {
    return this.http.post<any>(this.url2,json,httpOptions);

  }

  getFavouriteArticle(email):Observable<any>{
    return this.http.get<any>(this.url1+email);
  }

  articleSearch(keyword): Observable<any> {
    let newsUrl: string = "https://newsapi.org/v2/everything?q="+keyword+"&apiKey="+this.apiKey;
     return this.http.get(newsUrl);

  }
}
