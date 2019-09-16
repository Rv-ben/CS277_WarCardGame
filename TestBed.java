import java.util.ArrayList;
import java.util.List;


public class TestBed{

    public static Player playerOne;
    public static Player playerTwo;
    public static Deck MainDeck, playerOneDeck, playerTwoDeck;
    public static List<Card> playedCards;

    public static void main(String[] args) {

        playedCards = new ArrayList<Card>();
        MainDeck = new Deck(52);

        playerOneDeck = new Deck(MainDeck.splitDeck(0, 52/2));
        playerOne = new Player(new Deck(playerOneDeck));

        playerTwoDeck = new Deck(MainDeck.splitDeck(52/2, 52));
        playerTwo = new Player(new Deck(playerTwoDeck));
        while(!playerOne.outOfCards() && !playerTwo.outOfCards()){
            round();
            System.out.println(playerOne.getDeckSize() +" "+playerTwo.getDeckSize());
        }


    }

    public static void round(){
        boolean cardSumEqual = false;

        Card playerOneCard = new Card(0,"null"), playerTwoCard = new Card(0,"null");

        do{

            try{
            playerOneCard = playerOne.placeCard();
            playerTwoCard = playerTwo.placeCard();
            }
            catch(Exception s){
                System.out.println(s);
            };

            playedCards.add(playerOneCard);
            playedCards.add(playerTwoCard);

            cardSumEqual = false;

            switch(playerOneCard.compareTo(playerTwoCard))
            {
                case 1:
                    //playerOne wins
                    playerOne.addCards(playedCards);break;
                case 0:
                    //playerTwo wins
                    playerTwo.addCards(playedCards);break;
                case -1:
                    //WAR
                    cardSumEqual =  true;
                    war();break;
                default:
                    System.out.println("Something went wrong");
            }

        }while(cardSumEqual);
        
        playedCards.clear();
    }

    public static void war(){
        for(int i = 0 ; i<3 ; i++){
            if(!playerOne.outOfCards())
                playedCards.add(playerOne.placeCard());
            if(!playerTwo.outOfCards())
                playedCards.add(playerTwo.placeCard());
        }
    }

    

}