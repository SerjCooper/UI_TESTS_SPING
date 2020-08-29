package Tests;

import Pages.Header;
import Pages.SearchResultPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

@Epic("Домашняя работа: Spring")
@Owner("Bondarev Sergey")
public class HeaderTest extends BaseTest {

    @Test
    @Description("Проверка отображения кнопки написания поста")
    public void howAuthorTest(){
        Header header = new Header(driver);
        header
                .verifyLoad()
                .HowAuthorClick()
                .verifyVisibilityBtnCreatePost();
    }

    @Test
    @Description("Проверка поискового запроса")
    public void searchTest(){
        String searchRequest = "Spring";

        Header header = new Header(driver);
        SearchResultPage searchResultPage =
                header.search(searchRequest);
        searchResultPage.verifySearchResult(searchRequest);
    }
}
