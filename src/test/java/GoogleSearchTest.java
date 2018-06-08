import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class GoogleSearchTest extends GoogleBaseTest {

    @Test
    public void GoogleSearchTest() throws InterruptedException {
        String searchTerm = "Selenium";
        sleep(1000);
        Assert.assertEquals(googleHomePage.getCurrentUrl(),
                "https://www.google.com/",
                "Page is not loaded");
        GoogleFirstPageResult googleFirstPageResult = googleHomePage.search();



        Assert.assertEquals(googleHomePage.getCurrentTittle(),
                "selenium - Поиск в Google",
                "Page is not loaded");

        sleep(1000);


        List<String> searchResultsList = googleFirstPageResult.getSearchResualts();

        for (String searchResult:searchResultsList){
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "Searchterm " + searchResult + " was not found in: \n" + searchResult);
            }
        sleep(1000);
        Assert.assertTrue(googleFirstPageResult.isPageLoaded(),"Page is not loaded");


              googleFirstPageResult.GoogleMessage();
              GoogleSecondPageResult googleSecondPageResult = googleFirstPageResult.nextPage();
              sleep(1000);



        List<String> searchResultsList2 = googleSecondPageResult.getSearchResualts();

        for (String searchResult:searchResultsList){
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "Searchterm " + searchResult + " was not found in: \n" + searchResult);
        }

    }

}
