
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class MyNewTest extends BaseWebDriverTest{

    public static final String INPUT_SELECTOR = "//input[contains(@class,'rz-header-search-input-text')]";
    public static final String FILTER_SELECTOR = "a.filter-active-i-link";
    public static final String IPHONE_ITEM = "//div[contains(@class,'g-i-tile g-i-tile-catalog')]//div[contains(@class,'g-i-tile-i-title')]/a[contains(text(),'Apple iPhone 7 128GB Jet Black')]";
    public static final String IPHONE_CODE = "span.detail-code-i";

    @Test
    public void testRozetka(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_SELECTOR)))
                .sendKeys("iphone 7 32gb");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("rz-search-button")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(IPHONE_ITEM))).click();
        String result = driver.findElement(By.cssSelector(IPHONE_CODE)).getText();
        assert result.equals("11241577");
        assert driver.getCurrentUrl().equals("http://rozetka.com.ua/apple_iphone_7_128gb_jet_black/p11241577/");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("topurchases")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#popup-checkout")))
                .click();
        String page1 = driver.findElement(By.cssSelector(".check-title")).getText();
        assert page1.equals("Оформление заказа");

    }

}
