import { protractor } from "protractor/built/ptor";
import { LoginPage } from "../login/login.po";
import { signupPage } from "./signup.po";
import { browser } from "protractor";

describe('Signup page', () => {
    let page: signupPage;
   // let home = new LoginPage();
    const EC = protractor.ExpectedConditions;
beforeEach(() => {
    page = new signupPage();
    page.navigateToSignupPage();
});
it('should be able to signup as new user', () => {
    page.sendNameSignupPage().sendKeys('analyst4');
    page.sendEmailSignupPage().sendKeys('user124@gmail.com');
    page.sendPasswordForSignup().sendKeys('123456');
    page.sendLanguageId().sendKeys("english");
    page.getSignupButton().click();
    browser.sleep(2000)
    expect(browser.driver.getCurrentUrl()).toContain('');   
});  

it('should be not able to signup as user if emailId already present', () => {
    page.sendNameSignupPage().sendKeys('anki');
    page.sendEmailSignupPage().sendKeys('anki@gmail.com');
    page.sendPasswordForSignup().sendKeys('1234');
    page.sendLanguageId().sendKeys("english");
    page.getSignupButton().click();
    // browser.wait(EC.visibilityOf(home.getTitle()));
    browser.sleep(2000)
    expect(browser.driver.getCurrentUrl()).toContain('');
});
});