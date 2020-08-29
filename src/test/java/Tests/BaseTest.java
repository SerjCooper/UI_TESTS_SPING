package Tests;

import Config.ServerConfig;
import Utils.WebDriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {

    @Autowired
    protected WebDriverFactory webDriverFactory;
    protected Logger logger = LogManager.getLogger(getClass());
    protected ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        logger.info("Инициализация теста" );
        ApplicationContext javaConfigContext =
                new AnnotationConfigApplicationContext(WebDriverFactory.class);
        webDriverFactory = javaConfigContext.getBean(WebDriverFactory.class);
        driver = webDriverFactory.create(cfg.browser());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(cfg.timeout_implicitly(), SECONDS);
        driver.get(cfg.url());
    }

    @AfterMethod
    public void quit(){
        if(driver != null)
            driver.quit();
    }
}
