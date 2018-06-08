import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSecondPageResult extends GoogleBasePage {


    @FindBy(xpath = "//div[@class='srg']/div[\" + i + \"]")
    List<WebElement> searchResultsSecondPage;

    public GoogleSecondPageResult (WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    public List<String> getSearchResualts ()  {
        List<String> searchResultsList2 = new ArrayList();
        for (WebElement searchResult:searchResultsSecondPage) {
            ((JavascriptExecutor)webDriver).executeScript(
                    "arguments[0].scrollIntoView();", searchResult);

            String searchResultText = searchResult.getText();
            searchResultsList2.add(searchResultText);
        }
        System.out.println(searchResultsList2);
        System.out.println(searchResultsList2.size());
        return searchResultsList2;
    }


}
