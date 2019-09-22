

public class TestBed{

    public static Player playerOne,playerTwo;
    public static Deck MainDeck, playerOneDeck, playerTwoDeck, playedCards;
    public static Card playerOneCard, playerTwoCard;

    public static void main(String[] args) throws InterruptedException{

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

        System.out.println("__      ____ _ _ __ ");
        System.out.println("\\ \\ /\\ / / _` | \'__|");
        System.out.println(" \\ V  V / (_| | |   ");
        System.out.println("  \\_/\\_/ \\__,_|_|   ");

        int i = 1;

        while(!gameOver()){
                Thread.sleep(3000);
            System.out.println("---------------------------------ROUND: "+i+"--------------------------------------------------------------");
            round();
            //debug
            System.out.println("User: "+playerOne.getDeckSize() +" Computer: "+playerTwo.getDeckSize());
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
            System.out.println("User's Card");
            playerOneCard.printCard();

            System.out.println();
            
            System.out.println("Computer's Card");
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
            System.out.println("User wins this round");
            return false;
        }
        else if(result == 0){
            //player two wins
            playSecondCard();
            return false;
        }
        else{
            //tie
            System.out.println("WAAARRR");
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
            System.out.println("User's Second Card");
            playerOneCard.printCard();
            playedCards.addToBottom(playerOneCard);
            cardSum += playerOneCard.getCardNum();
        }

        if(cardSum < playerTwoCard.getCardNum()){
            System.out.println("Computer wins this round");
            playerTwo.addCards(playedCards);
        }
        else{
            System.out.println("User wins this round");
            playerOne.addCards(playedCards);
        }
        //input.close();
    }
}