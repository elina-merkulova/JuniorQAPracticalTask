package stepdefs;

import pages.BaseFunk;
import pages.GamePage;
import pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import requesters.TopGameRequester;

public class TopRatedGameStepDefs {
    BaseFunk baseFunc = new BaseFunk();
    GamePage gamePage = new GamePage(baseFunc);
    HomePage homePage = new HomePage(baseFunc);
    TopGameRequester requester = new TopGameRequester(baseFunc);
    private Double response;
    private Double averageWeb;


    private final String HOME_PAGE_URL = "boardgamegeek.com";

    @Given("Homepage is opened")
    public void open_url_url() {

        baseFunc.openUrl(HOME_PAGE_URL);
    }

    @When("click on side bar menu btn")
    public void open_side_menu_bar() {
        homePage.acceptCookies();
        homePage.sideMenuBar();
    }

    @When("we are opening top game with increasing rank")
    public void find_game_with_most_increased_rank() {

        homePage.findTopGame();
    }

    @When("we are requesting information about the game from API")
    public void request_information_from_api() {
        String gameId = gamePage.getGameId();
        response = requester.averageRatingFromApi(gameId);
    }

    @When("we open game statistics page")
    public void open_statistics_page() {
        gamePage.openGameStats();

    }

    @Then("Average rating matches the one found on the game page")
    public void check_average_game_rating() {
        averageWeb = gamePage.getGameAverageRatingFromWeb();
        System.out.println("Rating from web is:" + averageWeb);
        System.out.println("Rating from API is:" + response);
        System.out.println("Checking if the ratings match...");
        Assertions.assertEquals(averageWeb, response, "Ratings don't match");
        System.out.println("Ratings match!");
    }
    @Then("Close browser")
    public void close_browser(){

        baseFunc.closeBrowser();
    }


}
