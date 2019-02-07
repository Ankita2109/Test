import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class NewsPage{
    getTitle(){
        return element(by.css('h2'));
    }
}