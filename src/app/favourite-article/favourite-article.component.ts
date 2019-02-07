import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { ArticleService } from '../article.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-favourite-article',
  templateUrl: './favourite-article.component.html',
  styleUrls: ['./favourite-article.component.css']
})
export class FavouriteArticleComponent implements OnInit {
  favArticles: any = [];
  email:any;
  articleList:any;
  constructor(private service: AuthService, private articleService: ArticleService, private router: Router) { }

  ngOnInit() {
   
   
   this.email= this.service.getEmail();
    this.articleService.getFavouriteArticle(this.email).subscribe(
      data => {
        
          this.articleList = data.favouriteArticle;
         
        
      }
    )
  }
  favouriteArticleJson:any;
  removeFavouriteArticle(title,description){
    this.favouriteArticleJson=JSON.stringify({
      "email" : this.service.getEmail(),
      "favouriteArticle": [
        {
            "title": title
            
        }
      ]
    });
   
    console.log(this.favouriteArticleJson);
    this.articleService.deleteArticle(this.favouriteArticleJson).subscribe(data=>{
      console.log("delete Favourite article");
     // console.log();
     this.articleService.getFavouriteArticle(this.email).subscribe(
      data => {      
          this.articleList = data.favouriteArticle;  
      }
    )
    });
  }
  getFavourites() {
    
  }
  }


