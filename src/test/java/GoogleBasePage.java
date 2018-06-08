import org.openqa.selenium.WebDriver;

public class GoogleBasePage {

    protected WebDriver webDriver;

    public GoogleBasePage (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentUrl (){
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTittle (){
        return webDriver.getTitle();
    }




}

