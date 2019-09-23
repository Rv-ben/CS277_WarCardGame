

/**
 * Represents a player for card game
 * 
 * @author Ruben Bramasco
 * @since 2019-22-9
 * @version 1.0.0
 */
public class Player{

    /**
     * Deck of cards belonging to player
     */
    private Deck cards;

    /**
     * Size of deck of cards
     */
    private int score;

    /**
     * Contructs a new player with a deck
     * @param cards Deck Object
     */
    public Player(Deck cards){
        this.cards = cards;
        this.score = cards.getDeckSize();
    }

    /**
     * Gets and removes first card in deck
     * @return Card Object
     */
    public Card placeCard(){
        this.score--;
        return cards.pop();
    }
    
    /**
     * Adds cards to bottom of player deck
     * @param cards Deck Object
     */
    public void addCards(Deck cards){
        score += cards.getDeckSize();
        this.cards.addListOfCards(cards);
    }

    /**
     * Gets the players main deck
     * @return player deck as Deck Object
     */
    public Deck getDeck(){
        return cards;
    }

    /**
     * Gets players score
     * @return score as Int
     */
    public int getScore(){
        return score;
    }

    /**
     * Checks if player is out of cards
     * @return true if player is out of cards
     */
    public boolean outOfCards(){
        if(score == 0)
            return true;
        return false;
    }

    /**
     * Prints players deck
     */
    public void showDeck(){
        cards.printDeck();
    }

}