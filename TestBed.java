

public class TestBed{

    public static Player playerOne,playerTwo;
    public static Deck MainDeck, playerOneDeck, playerTwoDeck, playedCards;
    public static Card playerOneCard, playerTwoCard;

    public static void main(String[] args) {

        //Cards currently in play
        playedCards = new Deck();

        //Makes a deck with 52 and 4 suits
        MainDeck = new Deck(52);

        //splits the main deck and gives it to player 1
        playerOneDeck = new Deck(MainDeck.splitDeck(0, 52/2));
        playerOne = new Player(new Deck(playerOneDeck));

        //splits the main deck and gives it to player 2
        playerTwoDeck = new Deck(MainDeck.splitDeck(52/2, 52));
        playerTwo = new Player(new Deck(playerTwoDeck));

        //Keeps running the game while the players are not out of cards

        int i = 1;

        while(!gameOver()){
            System.out.println("---------------------------------ROUND: "+i+"--------------------------------------------------------------");
            round();
            //debug
            System.out.println(playerOne.getDeckSize() +" "+playerTwo.getDeckSize());
            i++;
            System.out.println("---------------------------------ROUND END----------------------------------------------------------------");
        }


        //MainDeck.getCards().get(0).printCard();
    }

    //game round
    public static void round(){

        //True if cards sums are not equal
        boolean cardSumEqual = false;

        //round loop
        do{

            //checks if game is over
            if(gameOver())
                break;

            //Places a new card down
            playerOneCard = playerOne.placeCard();
            playerTwoCard = playerTwo.placeCard();

            //Display placed cards
            System.out.println("Player 1's Card");
            playerOneCard.printCard();

            System.out.println();
            
            System.out.println("Player 2's Card");
            playerTwoCard.printCard();
            

            //adds the placed cards to the current cards
            playedCards.addToBottom(playerOneCard);
            playedCards.addToBottom(playerTwoCard);

            //compares two cards 
            cardSumEqual = compare(playerOneCard.compareTo(playerTwoCard));

        }while(cardSumEqual); //keep going if same value
        
        playedCards.clear(); //clears the current field
    }

    public static boolean compare(int result){

        if(result == 1){
            //player one wins
            playerOne.addCards(playedCards);
            return false;
        }
        else if(result == 0){
            //player two wins
            playSecondCard();
            return false;
        }
        else{
            //tie
            war();
            return true;
        }
    }

    //This function places 3 cards face down
    public static void war(){
        for(int i = 0 ; i<3 ; i++){
            if(!playerOne.outOfCards())
                playedCards.addToBottom(playerOne.placeCard());
            if(!playerTwo.outOfCards())
                playedCards.addToBottom(playerTwo.placeCard());
        }
    }

    //checks if game is over
    public static boolean gameOver(){
        if(playerOne.outOfCards() || playerTwo.outOfCards()){
            if(!playerOne.outOfCards())
                playerOne.addCards(playedCards);
            else
                playerTwo.addCards(playedCards);
            return true;
        }
        return false;
    }
    
    public static void playSecondCard(){

        java.util.Scanner input = new java.util.Scanner (System.in);
        System.out.println("Play another card?");
        char answer = input.next().charAt(0);
        int cardSum = 0;
        
        if(answer == 'y'){
            //add second placed card sum to first
            cardSum = playerOneCard.getCardNum();
            playerOneCard = playerOne.placeCard();
            System.out.println("Player 1's Card");
            playerOneCard.printCard();
            playedCards.addToBottom(playerOneCard);
            cardSum += playerOneCard.getCardNum();
        }

        if(cardSum < playerTwoCard.getCardNum()){
            playerTwo.addCards(playedCards);
        }
        else{
            playerOne.addCards(playedCards);
        }
        
    }
}