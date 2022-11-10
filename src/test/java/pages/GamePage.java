package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GamePage {
    private final By OPEN_GAME_STATS = By.xpath(".//a[@ui-sref = 'geekitem.stats']");
    private final By GAME_ID = By.xpath(".//div[@class = 'game-itemid ng-binding']");
    private BaseFunk baseFunk;
    private final By GET_GAME_RATING = By.xpath(".//div[@class='outline-item-description']");

    public GamePage(BaseFunk baseFunk) {

        this.baseFunk = baseFunk;
    }

    public void openGameStats() {

        baseFunk.click(OPEN_GAME_STATS);
    }

    public String getGameId() {
        WebElement idText = baseFunk.findElement(GAME_ID);
        String gameId = idText.getText();
        return gameId.substring(13);
    }

    public Double getGameAverageRatingFromWeb() {
        String gameRating = baseFunk.findElement(GET_GAME_RATING).getText();
        double gameAR = baseFunk.parseStringToDouble(gameRating);
        return baseFunk.roundUpDouble(gameAR);
    }
}
