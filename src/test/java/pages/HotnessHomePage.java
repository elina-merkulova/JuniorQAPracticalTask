package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HotnessHomePage {
    private BaseFunk baseFunk;
    private final By TOP_GAMES = By.xpath(".//li[@class= 'hotness-item']");
    private final By INCREASING_RANK = By.xpath(".//fa-icon[@class = 'ng-fa-icon tw-text-base tw-text-green']");


    public HotnessHomePage(BaseFunk baseFunk) {
        this.baseFunk = baseFunk;
    }

    public void findTopGame() {
        WebElement gameWithIncreasingRank;
        gameWithIncreasingRank = baseFunk.findElement(INCREASING_RANK);
        baseFunk.findElements(TOP_GAMES);
        List<WebElement> topGames = baseFunk.findElements(TOP_GAMES);
        for (WebElement item : topGames) {
            if (item.equals(gameWithIncreasingRank)) {
                baseFunk.click(INCREASING_RANK);
                break;
            }
        }

    }

}
