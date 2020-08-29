package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Header extends BasePage {

    private final By logoXpath = By.xpath("//a[contains(@class, 'logo')]");
    private final By howAuthorBtnXpath = By.xpath("//a[contains(@class, 'bmenu__conversion')]");
    private final By searchBtnXpath = By.xpath("//button[contains(@id, 'search-form-btn')]");
    private final By searchFieldXpath = By.xpath("//input[contains(@id, 'search-form-field')]");


    public Header(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка загрузки страницы")
    public Header verifyLoad(){
        wait.until(ExpectedConditions.elementToBeClickable(logoXpath));
        Assert.assertTrue(driver.findElement(logoXpath).isDisplayed());
        return this;
    }

    @Step("Переход на страницу \"Как стать автором\"")
    public HowAuthorPage HowAuthorClick(){
        driver.findElement(howAuthorBtnXpath).click();
        return new HowAuthorPage(driver);
    }

    @Step("Поиск по строке {0}")
    public SearchResultPage search(String request){
        driver.findElement(searchBtnXpath).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldXpath));
        driver.findElement(searchFieldXpath).sendKeys(request + Keys.RETURN);
        return new SearchResultPage(driver);
    }
}
