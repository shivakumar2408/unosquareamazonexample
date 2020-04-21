package amazonTest;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class createAccount {
	
	WebDriver driver;

    By Name = By.id("ap_customer_name");

    By emailAddress = By.id("ap_email");

    By password =By.id("ap_password");

    By re_password = By.id("ap_password_check");
    By createAccount = By.id("createAccountSubmit");

    public createAccount(WebDriver driver){

        this.driver = driver;

    }
    public void setUserName(String strUserName){

        driver.findElement(Name).sendKeys(strUserName);

    }

    //Set password in password textbox
    public void setEmailAddress(String strEmailAddress){

        driver.findElement(emailAddress).sendKeys(strEmailAddress);

   }

    public void setPassword(String strPassword){

         driver.findElement(password).sendKeys(strPassword);

    }

    public void setPasswordCheck(String strPasswordCheck){

        driver.findElement(re_password).sendKeys(strPasswordCheck);

   }
    //Click on login button

    public void createAccount(){

            driver.findElement(createAccount).click();

    }

    public void account_Create(String strUserName, String stremailAddress, String strPasword, String strPasswordCheck){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password
        this.setEmailAddress(stremailAddress);
        this.setPassword(strPasword);
        this.setPasswordCheck(strPasswordCheck);

        //Click Login button

       // this.createAccount();        
    }

}


