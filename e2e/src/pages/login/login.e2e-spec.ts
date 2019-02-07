import { LoginPage } from './login.po';
import { protractor, browser } from 'protractor';
import { NewsPage } from '../news/news.po';


describe('Login page', () => {
    let page: LoginPage;
    let news = new NewsPage();
   

    // tslint:disable-next-line:label-position
   //  let article = new ArticlePage();
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new LoginPage();
        page.navigateToLoginPage();
    });

    it('should be able to login as admin', () => {
        page.sendEmailForLogin().sendKeys('admin@gmail.com');
        page.sendPasswordForLogin().sendKeys('admin');
        page.getLoginButton().click();
       // browser.wait(EC.visibilityOf(news.getTitle()));
    //    expect(article.getTitle().isPresent()).toBeTruthy();
              browser.sleep(1000);
        expect(browser.driver.getCurrentUrl()).toContain('/search');
    });  
    it('should be able to login as user', () => {
        page.sendEmailForLogin().sendKeys('anki@gmail.com');
        page.sendPasswordForLogin().sendKeys('1234');
        page.getLoginButton().click();
        browser.wait(EC.visibilityOf(news.getTitle()));
    //    expect(article.getTitle().isPresent()).toBeTruthy();
 expect(browser.driver.getCurrentUrl()).toContain('/news');
    }); 
 /*  it('should be able to get the errorMessage', () => {
        page.sendEmailForLogin().sendKeys('anki@gmail.com');
        page.sendPasswordForLogin().sendKeys('user123');
        page.getLoginButton().click();        
        expect(page.getErrorMessage().getText()).toEqual("Incorrect Email or Password");
    }); */  


     
  
});