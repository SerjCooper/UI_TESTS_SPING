package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Logger logger = LogManager.getLogger(getClass());

    public BasePage(WebDriver driver){
        logger.info("Создан объект страницы");
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
    }
}
