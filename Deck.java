import java.util.*;


enum Suit{
    Diamonds,Clubs,Spades,Hearts
}

/**
 * Represents a Deck
 * @author Ruben Bramasco
 * @version 1.0.1
 */
public class Deck{


    /**
     * List of cards
     */
    private ArrayList<Card> cards;

    /**
     * Size of deck
     */
    private int deckSize;


    private Suit suits[] = Suit.values();

    
    public Deck(List<Card> cards){
        this.cards = new ArrayList<Card>();
        this.addListOfCards(cards);
        this.deckSize = cards.size();
        this.shuffle();
    }

    public Deck(int deckSize){
        this.deckSize = deckSize;
        this.fillDeck();
        this.shuffle();
    }

    public Deck(Deck other){
        this.cards = other.getCards();
        this.deckSize = other.getDeckSize();
    }


    /**
     * Shuffles List of cards
     */
    public void shuffle(){
        Collections.shuffle(cards);
    }

    /**
     * Gets a subsection of the cards ArrayList
     * @param beginIndex index of first element in list as Int 
     * @param endIndex index of last element in list as Int 
     * @return List of Card Objects 
     */
    public List<Card> splitDeck(int beginIndex, int endIndex){
        return cards.subList(beginIndex, endIndex);
    }

    /**
     * Gets deckSize
     * @return deskSize as Int 
     */
    public int getDeckSize(){
        return deckSize;
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    /**
     * Pops the front card in deck
     * @return Card Object
     */
    public Card pop(){
        Card temp = cards.get(0);
        cards.remove(0);
        deckSize--;
        return temp;
    }

    /**
     * Adds single card to bottom of deck 
     * @param card Card Object 
     */
    public void addToBottom(Card card){
        cards.add(card);
        deckSize++;
    }

    /**
     * Fills the deck with all cards possible
     */
    private void fillDeck(){
        this.cards = new ArrayList<Card>();
        int cardPerSuit = this.deckSize/4;
        
        for( Suit Su: suits ){
            for(int i = 0; i < cardPerSuit; i++){
                this.cards.add(i, new Card(i+2, Su.name()));
            }
        }
    
    }

    /**
     * Adds a list of cards to the bottom of deck
     */
    public void addListOfCards(List<Card> cards){
        for(Card i : cards){
            this.cards.add(i);
        }
        deckSize += cards.size();
    }

    /**
     * Prints the deck
     */
    public void printDeck(){
        for(int i = 0; i<deckSize; i++){
            this.cards.get(i).printCard();
            System.out.println();
        }
    }

}