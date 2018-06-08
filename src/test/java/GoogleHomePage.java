import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends GoogleBasePage{


    @FindBy(xpath = "//input[@id='lst-ib']")
    WebElement searchField;

    public GoogleHomePage (WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }



    public GoogleFirstPageResult search(){
        searchField.click();
        searchField.sendKeys("selenium");
        searchField.sendKeys(Keys.ENTER);
        return new GoogleFirstPageResult(webDriver);



    }
}
