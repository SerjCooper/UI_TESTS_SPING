package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;

public class SearchResultPage extends BasePage {

    private final By postTitleXpath = By.xpath("//h2[contains(@class,'post__title')]");
    private final By tabTypeXpath = By.xpath("//h3[contains(@class, 'tabs-menu__item-text_active')]");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка загрузки страницы")
    public SearchResultPage verifyLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tabTypeXpath));
        Assert.assertTrue(driver.findElement(tabTypeXpath).isDisplayed());
        return this;
    }

    public SearchResultPage verifySearchResult(String expStr){
        List<WebElement> elements = driver.findElements(postTitleXpath);
        for (WebElement e : elements) {
            Assert.assertTrue(e.getText().contains(expStr));
        }
        return this;
    }
}
