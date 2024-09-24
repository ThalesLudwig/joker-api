package valentini.ludwig.joker_api.controller.blackjack;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import valentini.ludwig.joker_api.dto.GameResponse;
import valentini.ludwig.joker_api.dto.GameRequest;
import valentini.ludwig.joker_api.interfaces.IGameController;
import valentini.ludwig.joker_api.model.Card;
import valentini.ludwig.joker_api.model.Deck;
import valentini.ludwig.joker_api.service.blackjack.BlackjackService;

import java.util.ArrayList;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/blackjack")
public class BlackjackController implements IGameController {
    private final String GAME_NOT_STARTED = "Game has not started.";

    @GetMapping("/deck")
    public Deck getDeck() {
        return BlackjackService.getDeck();
    }

    @GetMapping("/hand")
    public ArrayList<Card> getHand() {
        return BlackjackService.getPlayerHand();
    }

    @GetMapping("/cash")
    public double getCash() {
        return BlackjackService.getCash();
    }

    @GetMapping("/hit")
    public GameResponse hit() {
        try {
            return BlackjackService.hit();
        } catch (NullPointerException e) {
            throw new NullPointerException(GAME_NOT_STARTED);
        }
    }

    @GetMapping("/stand")
    public GameResponse stand() {
        try {
            return BlackjackService.stand();
        } catch (NullPointerException e) {
            throw new NullPointerException(GAME_NOT_STARTED);
        }
    }

    @PostMapping(value = "/start", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GameResponse start(@RequestBody GameRequest req) {
        return BlackjackService.start(req);
    }

    @PostMapping(value = "/bet", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GameResponse bet(@RequestBody GameRequest req) {
        return BlackjackService.setBet(req.bet());
    }

    @GetMapping("/stop")
    public GameResponse stop() {
        return BlackjackService.stop();
    }
}
