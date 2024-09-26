## Joker API
- An API for playing several card games through a REST interface.
- Currently supports only simple Blackjack.

### Running
`docker compose up`

### Blackjack
- Base endpoint: `/blackjack`
- Start game: `/start?cash=0000&bet=0000`
  - Where `cash` is the initial money amount and bet is the initial bet.
- Each endpoint returns a `commands` array with the following available commands.
  - Each command represents an endpoint, e.g.: command `cash` -> `/cash`
