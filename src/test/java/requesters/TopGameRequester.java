package requesters;

import pages.BaseFunk;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class TopGameRequester {
    private final String PREFIX = "https://boardgamegeek.com/xmlapi/boardgame/";
    private final String POSTFIX = "?stats=1";
    private BaseFunk baseFunk;


    public TopGameRequester(BaseFunk baseFunk) {

        this.baseFunk = baseFunk;
    }

    public Double averageRatingFromApi(String gameID) {

        String url = PREFIX + gameID + POSTFIX;

        String average = RestAssured.given().accept(ContentType.XML).
                when().get(url).then().extract().path("boardgames.boardgame.statistics.ratings.average").toString();

        double gameRating = baseFunk.parseStringToDouble(average);
        return baseFunk.roundUpDouble(gameRating);
    }
}