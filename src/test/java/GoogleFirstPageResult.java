import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleFirstPageResult extends GoogleBasePage {

   @FindBy(xpath = "//div[@class='srg']/div[\" + i + \"]")
   List <WebElement> searchResults;
   @FindBy(xpath = "//a[@aria-label='Page 2']")
    WebElement secondPage;

    public GoogleFirstPageResult (WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public List<String> getSearchResualts ()  {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResult:searchResults) {
            ((JavascriptExecutor)webDriver).executeScript(
                    "arguments[0].scrollIntoView();", searchResult);

            String searchResultText = searchResult.getText();
            searchResultsList.add(searchResultText);
        }
        System.out.println(searchResultsList);
        System.out.println(searchResultsList.size());
        return searchResultsList;
    }

    public void GoogleMessage (){
        System.out.println("Поиск на второй странице");


    }


    public  GoogleSecondPageResult nextPage(){
        secondPage.click();
        return new GoogleSecondPageResult(webDriver);
    }

    public boolean isPageLoaded(){
        return secondPage.isDisplayed();


    }
}
