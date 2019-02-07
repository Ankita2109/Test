import { NewsArticleComponent } from "src/app/news-article/news-article.component";
import { LoginPage } from "../login/login.po";
import { protractor,browser } from "protractor";
import { NewsPage } from "./news.po";

describe('News Article Page',()=>{
    let page=new NewsPage();
    let form= new LoginPage();
    const EC=protractor.ExpectedConditions;

    beforeEach(()=>{        
        form.navigateToLoginPage();
    });   
   it('Should Get the Title Expected',()=>{
        form.sendEmailForLogin().sendKeys('anki@gmail.com');
        form.sendPasswordForLogin().sendKeys('1234');
        form.getLoginButton().click();
        browser.wait(EC.visibilityOf(page.getTitle()));        
        expect(page.getTitle().getText()).toEqual('Search Article Page');
         //form.getLogoutButton().click();
    }); 
});