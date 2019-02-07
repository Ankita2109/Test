
import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class LoginPage {

    navigateToLoginPage() {
        return browser.get('');
    }

    sendEmailForLogin() {
        return element(by.id('loginemail'));
    }

    sendPasswordForLogin() {
        return element(by.id('loginpassword'));
    }
    getLoginButton() {
        return element(by.id('login'));
    }
   /*  getLogoutButton(){
        return element(by.id('bLogout'));
    }
 */
    getErrorMessage() {
        return element(by.className('col form-group alert alert-danger'));
    } 

}
