package valentini.ludwig.joker_api.interfaces;

import valentini.ludwig.joker_api.dto.GameRequest;
import valentini.ludwig.joker_api.dto.GameResponse;
import valentini.ludwig.joker_api.model.Card;
import valentini.ludwig.joker_api.model.Deck;

import java.util.ArrayList;

@SuppressWarnings("unused")
public interface IGameController {
    GameResponse start(GameRequest req);
    GameResponse stop();
    Deck getDeck();
    ArrayList<Card> getHand();
}
