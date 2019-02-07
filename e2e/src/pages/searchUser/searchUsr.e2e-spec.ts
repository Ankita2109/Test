import { LoginPage } from "../login/login.po";
import { protractor,browser } from "protractor";
import { SearchUser } from "./searchUser.po";


describe('Search User Page',()=>{
    let searchUser=new SearchUser();
    let form= new LoginPage();
    const EC=protractor.ExpectedConditions;

    beforeEach(()=>{
        form.navigateToLoginPage();
    });
   /*  it('Should Get the Title Expected',()=>{
        form.sendEmailForLogin().sendKeys('admin@gmail.com');
        form.sendPasswordForLogin().sendKeys('admin');
        form.getLoginButton().click();
        browser.wait(EC.visibilityOf(searchUser.getTitle()));                
        expect(searchUser.getTitle().getText()).toEqual('Search For News Analyst');
        /* form.getLogoutButton().click();
    });
 */
   /*  it('By Default Msg Should be empty',()=>{
        form.sendEmailForLogin().sendKeys('admin@gmail.com');
        form.sendPasswordForLogin().sendKeys('admin');
        form.getLoginButton().click();
        browser.wait(EC.visibilityOf(searchUser.getTitle()));                
        expect(searchUser.getTitle().getText()).toEqual('');
         form.getLogoutButton().click(); 
    }); */

   /*  it('Should show No User Found',()=>{
        form.sendEmailForLogin().sendKeys('admin@gmail.com');
        form.sendPasswordForLogin().sendKeys('admin');
        form.getLoginButton().click();
        browser.wait(EC.visibilityOf(searchUser.getTitle()));                
        searchUser.getSearchBox().sendKeys('fhvbhfdjdvsd');
        searchUser.getSearchButton().click();
        expect(searchUser.getError().getText()).toEqual('No user Found with this email');
         form.getLogoutButton().click(); 
    });

    it('Should show one user',()=>{
        form.sendEmailForLogin().sendKeys('admin@a.in');
        form.sendPasswordForLogin().sendKeys('admin123');
        form.getLoginButton().click();
        browser.wait(EC.visibilityOf(searchUser.getTitle()));
        searchUser.getSearchBox().sendKeys('anki@gmail.com');
        searchUser.getSearchButton().click();
        expect(searchUser.getUserName().getText()).toContain('UserOne exist');
       form.getLogoutButton().click(); 
    }); */
});