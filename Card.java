/**
 * Implements a card class
 * @author Ruben Bramasco
 * @since 2019-22-9
 * @version 1.0.1 
 */
public class Card{
    
    /**
     * Suit of card
     */
    private int suit;

    /**
     * Card number
     */
    private int cardNum;
    
    /**
     * Char for card printing
     */
    private String rank;

    /**
     * Constucts card with number and suit
     * @param carNum card number as Int
     * @param suit card suit as String Object
     */
    public Card(int carNum, int suit){
        this.cardNum = carNum;
        this.suit = suit;
        this.rank = "";
        convertToCardChar();
    }

    /**
     * Converts card number to printable rank
     */
    private void convertToCardChar(){
        if(cardNum > 9){
            switch (cardNum){
                case 10: rank = "10"; break;
                case 11: rank = "J"; break;
                case 12: rank = "Q"; break;
                case 13: rank = "K"; break;
                case 14: rank = "A"; break;
            }
        }
        else{
            rank += (char)(cardNum + 48);
        }
    }

    /**
     * Allows comparing between two Card Objects
     * @param Object as Card Object
     */
    public int compareTo(Card other){
        Card otherCard = (Card) other;

        if(this.cardNum < otherCard.getCardNum())
            return 0;
        if(this.cardNum > otherCard.getCardNum())
            return 1;
        if(this.cardNum == otherCard.getCardNum())
            return -1;
        
        return -2;
    }

    /**
     * Gets card suit
     * @return card suit as Int
     */
    public int getSuit(){
        return suit;
    }

    /**
     * Gets card number 
     * @return card number as Int
     */
    public int getCardNum(){
        return cardNum;
    }

    /**
     * Prints card's suit and numnber
     */
    public void printCard(){
        System.out.println(" __________");
        switch(suit){
            case 0: 
            System.out.println("|"+rank+"   /\\    |");
            System.out.println("|   /  \\   |");
            System.out.println("|  /    \\  |");
            System.out.println("|  \\    /  |");
            System.out.println("|   \\  /   |");
            System.out.println("|    \\/    |");
            break;
            case 1:
            System.out.println("|"+rank+"         |");
            System.out.println("|    / \\   |");
            System.out.println("|   /   \\  |");
            System.out.println("|  /_   _\\ |");
            System.out.println("|    | |   |");
            System.out.println("|    |_|   |");
            break;
            case 2:
            System.out.println("|"+rank+"   ___   |");
            System.out.println("|   (   )  |");
            System.out.println("|  (_   _) |");
            System.out.println("|    | |   |");
            System.out.println("|    | |   |");
            System.out.println("|    |_|   |");
            break;
            case 3:
            System.out.println("|"+rank+"  _  _   |");
            System.out.println("|  / \\/ \\  |");
            System.out.println("| |      | |");
            System.out.println("|  \\    /  |");
            System.out.println("|   \\  /   |");
            System.out.println("|    \\/    |");
            break;

        }
        System.out.println("|__________|");
    }

}