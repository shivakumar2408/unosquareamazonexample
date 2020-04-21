package amazonTest;



import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import amazonTest.dependMethod;

public class searchProduct extends dependMethod {

    /**

     * All WebElements are identified by @FindBy annotation

     */

    WebDriver driver;
    String phone_name = null;
		String phone_price;
		int int_phone_price = 0;
		
	@FindBy(css="#nav-logo > a > span.nav-sprite.nav-logo-base")
	
	WebElement homeLogo;

    @FindBy(xpath= "//*[@id=\"nav-link-accountList\"]")

    WebElement signIn;

    @FindBy(id="twotabsearchtextbox")

    WebElement search;    

    @FindBy(css="#nav-search > form > div.nav-right > div > input")

    WebElement searchButton;

    @FindBy(xpath="//*[@class='a-size-medium a-color-base a-text-normal']")

    List<WebElement> phoneArray;
    
    @FindBy(xpath="//*[@class='a-size-base']")

    List<WebElement> rateArray;
    
    @FindBy(name="submit.add-to-cart-ubb")
    
    WebElement addtoCart;

    public searchProduct(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public void setSearch(String strSearch){

        search.sendKeys(strSearch);     
    }
    
    public void clickHome(){

        homeLogo.click();

    }
    
   
    public void clickSearch(){

            searchButton.click();

    }  
    
    public void clickaddtoCart() 
    {
    	addtoCart.click();
    }
    
    public void clicksignIn(){

        signIn.click();

    }  
    public void clickProduct()
    {
    	for(int j =0; j<phoneArray.size(); j++)
		{
			if(phoneArray.get(j).getText().contains("Samsung Galaxy S9 "))
			{
				System.out.print(phoneArray.get(j).getText() + "\t" + rateArray.get(j).getText() + "\n");
				phone_name=phoneArray.get(j).getText();
				phone_price=rateArray.get(j).getText();
				phone_price = phone_price.replaceAll("[^0-9]", "");
				int_phone_price = Integer.parseInt(phone_price);
				System.out.println(phone_name + "\t" + int_phone_price);
				phoneArray.get(j).click();
				break;
							
			}
		}
		
 		String  actual = driver.findElement(By.id("acrCustomerReviewText")).getText();
 		StringTokenizer st = new StringTokenizer(actual);  
 		String actualrating = st.nextToken(" ").replaceAll("[^0-9]", "");
		int int_actual_rating = Integer.parseInt(actualrating);
 	    System.out.println(int_phone_price +"" + int_actual_rating);  
 	    Assert.assertEquals(int_actual_rating, int_phone_price, "ratings matched");
    	
    }
    public void driver_wait() 
    {
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
    }
   
}

