/**
 * Implements a card class
 * @author Ruben Bramasco
 * @version 1.0.1 
 */
public class Card implements Comparable{
    
    /**
     * Suit of card
     */
    private String suit;

    /**
     * Card number
     */
    private int cardNum;

    /**
     * Constucts card with number and suit
     * @param carNum card number as Int
     * @param suit card suit as String Object
     */
    public Card(int carNum, String suit){
        this.cardNum = carNum;
        this.suit = suit;
    }

    /**
     * Allows comparing between two Card Objects
     * @param Object as Card Object
     */
    public int compareTo(Object other){
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
     * @return card suit as String Object
     */
    public String getSuit(){
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
        System.out.print("C:"+ suit + cardNum );
    }

}