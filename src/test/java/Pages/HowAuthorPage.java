package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HowAuthorPage extends BasePage{

    private final By createPostBtnXpath = By.xpath("//a[contains(text(), 'Написать пост')]");

    public HowAuthorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка отображения кнопки \"Написать пост\"")
    public HowAuthorPage verifyVisibilityBtnCreatePost(){
        wait.until(ExpectedConditions.elementToBeClickable(createPostBtnXpath));
        Assert.assertTrue(driver.findElement(createPostBtnXpath).isEnabled());
        return this;
    }
}
