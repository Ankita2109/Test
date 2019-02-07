import { Component, OnInit } from '@angular/core';
import { SearchService } from '../search.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private status:SearchService) { }
  analyst:any;
  isUser=false;
  ngOnInit() {}
    getAnalystDetail(email){
      this.status.getAnalyst(email).subscribe(
        data => {
          if(data!=null){
           this.isUser=true;
            this.analyst=data;
          }
   
      
          console.log(this.analyst)
        }
      );
    }
     changeAnalystStatus(email){
       this.status.analystStatus(email).subscribe(
         data=>{
           console.log(data);
           this.analyst=data;
         }
       )
  
     }
  
}