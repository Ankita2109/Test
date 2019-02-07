import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { ArticleService } from '../article.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-news-article',
  templateUrl: './news-article.component.html',
  styleUrls: ['./news-article.component.css']
})
export class NewsArticleComponent implements OnInit {

  constructor(private articleservice:ArticleService , private service: AuthService,private router:Router) { }

  languageCode:any;
  articleList:any;
  articles:any;
  ngOnInit() {
    this.languageCode =  this.service.getLanguageCode();
    // this.code="en"
    this.articleservice.articleNews(this.languageCode).subscribe(data=>{
     console.log(data)
     this.articleList=data.articles;
   //this.article=data;
  })
  }
favouriteArticleJson:any;
  SavingFavouriteArticle(title,description){
    this.favouriteArticleJson=JSON.stringify({
      "email" : this.service.email,
      "favouriteArticle": [
        {
            "title": title,
            "description": description,
            "language": {
                "id": this.service.languageId
            }
        }
      ]
    });
   
    console.log(this.favouriteArticleJson);
    this.articleservice.favouriteArticleAdd(this.favouriteArticleJson).subscribe(data=>{
      console.log("Added to Favourites");
     // console.log();
      
    });
  }

  removeFavouriteArticle(title,description){
    this.favouriteArticleJson=JSON.stringify({
      "email" : this.service.email,
      "favouriteArticle": [
        {
            "title": title,
            "description": description,
            "language": {
                "id": this.service.languageId
            }
        }
      ]
    });
   
    console.log(this.favouriteArticleJson);
    this.articleservice.deleteArticle(this.favouriteArticleJson).subscribe(data=>{
      console.log("delete Favourite article");
     // console.log();
      
    });
  }
  favourite(){
    this.router.navigate(['/list'])
  }
  searchOnKeyword(keyword){
    this.articleservice.articleSearch(keyword).subscribe(data=>{
      console.log(data);
      this.articleList=data.articles;
      
    });
  }
}
