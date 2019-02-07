import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class SearchUser{
    getTitle(){
        return element(by.css('h2'));
    }
    
    getSearchBox(){
        return element(by.className('search-query form-control'));
    }

    getSearchButton(){
        return element(by.className('btn btn-danger'));
    }

  /*   getError(){
        return element(by.css('label'));
    }

    getUserName(){
        return element(by.className('card-title'));
    } */
}