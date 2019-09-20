

/**
 * Represents a player for card game
 * 
 * @author Ruben Bramasco
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
    private int deckSize;

    /**
     * Contructs a new player with a deck
     * @param cards Deck Object
     */
    public Player(Deck cards){
        this.cards = cards;
        this.deckSize = cards.getDeckSize();
    }

    /**
     * Gets and removes first card in deck
     * @return Card Object
     */
    public Card placeCard(){
        this.deckSize--;
        return cards.pop();
    }

    public void addCards(Deck cards){
        deckSize += cards.getDeckSize();
        this.cards.addListOfCards(cards);
    }

    /**
     * Gets cards
     * @return Deck Object
     */
    public Deck getDeck(){
        return cards;
    }

    /**
     * Gets deck size
     * @return deckSize as Int
     */
    public int getDeckSize(){
        return deckSize;
    }

    public boolean outOfCards(){
        if(deckSize == 0)
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