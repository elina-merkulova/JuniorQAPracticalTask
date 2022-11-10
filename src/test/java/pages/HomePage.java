package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By ACCEPT_COOKIES_BTN = By.id("c-p-bn");
    private final By OPEN_SIDE_MENU = By.xpath(".//button[@class = 'btn btn-empty header-icon tw-mr-2 tw-hidden tw-self-center tw-rounded tw-p-1.5 tw-leading-none tw-outline-none hover:tw-bg-purple-dark hover:tw-text-white focus:tw-bg-purple-dark focus:tw-text-white xl:tw-block']");
    private final By INCREASING_RANK = By.xpath(".//fa-icon[@class = 'ng-fa-icon tw-text-base tw-text-green']");
    private final By TOP_GAMES = By.xpath(".//li[@class = 'hotness-item']");
    private BaseFunk baseFunk;

    public HomePage(BaseFunk baseFunk) {
        this.baseFunk = baseFunk;
    }

    public void acceptCookies() {
        baseFunk.click(ACCEPT_COOKIES_BTN);
    }

    public void sideMenuBar() {
        baseFunk.click(OPEN_SIDE_MENU);
    }

    public void findTopGame() {
        List<WebElement> topGames = baseFunk.findElements(TOP_GAMES);
        for (WebElement game : topGames) {
            if (game.findElement(INCREASING_RANK).isDisplayed()) {
                try {
                    game.click();
                } catch (ElementClickInterceptedException e) {
                    System.out.println("Can't click from first  try");
                    game.click();
                }
            }

        }

    }
}
