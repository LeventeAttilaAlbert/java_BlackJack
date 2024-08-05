import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");

        String userInput = scan.nextLine();

        //Player prep, 2 random cards + their KNOWN value
        int playerCard1 = drawRandomCard();
        int playerCard2 = drawRandomCard();
        int handValue = playerCard1 + playerCard2;

        boolean bustOfPlayer = checkBust(handValue);
        if (bustOfPlayer == true) {
            System.out.println("BUST! You lose...");
            System.exit(0);
        }

        System.out.println("\n You get a \n" + cardString(playerCard1) + "\n and a \n" + cardString(playerCard2));
        System.out.println("Your total is: " + handValue);
        
        //Dealer prep, 2 random cards + their HIDDEN value
        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();
        int dealerValue = dealerCard1 + dealerCard2;

        boolean bustOfDealer = checkBust(dealerValue);
        if (bustOfDealer == true) {
            System.out.println("BUST! Dealer loses...");
            System.exit(0);
        }

        System.out.println("The dealer shows \n" + cardString(dealerCard1) + "\nand has a card facind down \n" + faceDown());
        System.out.println("\nThe dealer's total is hidden.");

       //Player does HIT or STAY
        int playerHitCard;
        String hitStay = hitOrStay();

        while (true) {
            if (hitStay.equals("Hit")){
            playerHitCard = drawRandomCard();
            handValue += playerHitCard;
            System.out.println("You get a\n" + cardString(playerHitCard) + "\nYour new total is: " + handValue);
                boolean bustWhileHit = checkBust(handValue);
                if (bustWhileHit == true) {
                System.out.println("BUST! You lose...");
                System.exit(0);
                }
            System.out.println("Want to hit again?");
            }
            else {
                break;
            }
            hitStay = hitOrStay();
        }
        //Dealer Turn, Reveal Second Card, Draw cards until the Dealer Value is bigger or equal than 17.
        System.out.println("Dealer's turn: ");
        System.out.println("The dealer's cards are:\n" + cardString(dealerCard1) + "\nand a" + cardString(dealerCard2));
        System.out.println("Their total is: " + dealerValue + " right now.");

        while(dealerValue <17) {
            int newDealerDraw = drawRandomCard();
            System.out.println("Dealer draws a\n" + cardString(newDealerDraw));
            dealerValue += newDealerDraw;
            System.out.println("Their new total is: " + dealerValue);
                boolean bustOfDealerWhileDraw = checkBust(dealerValue);
                if (bustOfDealerWhileDraw == true) {
                    System.out.println("BUST! Dealer loses...");
                    System.exit(0);
                }
        }

        if (handValue > dealerValue) {
            System.out.println("Congratulations! You win!");
        }
        else if (handValue < dealerValue) {
            System.out.println("You lose! Better luck next time!");
        }
        else {
            System.out.println("It's a TIE!");
        }


        scan.close();
    }
    
    public static int drawRandomCard() {
        int cardNumber = (int)(Math.random() * 13) + 1;
        return cardNumber;
    }

    public static String cardString(int cardNumber) {
        String cardDrawing = "No";
        switch (cardNumber) {
            case 1:
            cardDrawing = "   _____\n"+
                   "  |A _  |\n"+ 
                   "  | ( ) |\n"+
                   "  |(_'_)|\n"+
                   "  |  |  |\n"+
                   "  |____V|\n";
            break;

            case 2:
            cardDrawing = "   _____\n"+              
                    "  |2    |\n"+ 
                    "  |  o  |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____Z|\n";
            break;

            case 3:
            cardDrawing = "   _____\n" +
                  "  |3    |\n"+
                  "  | o o |\n"+
                  "  |     |\n"+
                  "  |  o  |\n"+
                  "  |____E|\n";
            break;

            case 4:
            cardDrawing ="   _____\n" +
                   "  |4    |\n"+
                   "  | o o |\n"+
                   "  |     |\n"+
                   "  | o o |\n"+
                   "  |____h|\n";
            break;

            case 5:
            cardDrawing ="   _____ \n" +
                    "  |5    |\n" +
                    "  | o o |\n" +
                    "  |  o  |\n" +
                    "  | o o |\n" +
                    "  |____S|\n";
            break;

            case 6:
            cardDrawing ="   _____ \n" +
                    "  |6    |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  |____6|\n";

            break;

            case 7:
            cardDrawing ="   _____ \n" +
                    "  |7    |\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |____7|\n";
            break;

            case 8:
            cardDrawing ="   _____ \n" +
                    "  |8    |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  |____8|\n";
            break;

            case 9:
            cardDrawing ="   _____ \n" +
                    "  |9    |\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |____9|\n";
            break;

            case 10:
            cardDrawing ="   _____ \n" +
                    "  |10  o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |___10|\n";
            break;

            case 11:
            cardDrawing ="   _____\n" +
                    "  |J  ww|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o% |\n"+ 
                    "  | | % |\n"+ 
                    "  |__%%[|\n";
            break;

            case 12:
            cardDrawing ="   _____\n" +
                    "  |Q  ww|\n"+ 
                    "  | o {(|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%O|\n";
            break;

            case 13:
            cardDrawing ="   _____\n" +
                    "  |K  WW|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%>|\n";
            break;
        
            default:
                break;
        }


        return cardDrawing;
    }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    public static String hitOrStay() {
        System.out.println("Hit or Stay? Please type out your choice.");
        String playerHitStay = "No";
        
        while (!(playerHitStay.equals("Hit") || playerHitStay.equals("Stay"))) {
            System.out.println("Please type 'Hit' or 'Stay'..");
            playerHitStay = scan.nextLine();
            
        }
        return playerHitStay; 
    }

    public static Boolean checkBust(int sumOfCards) {
        if (sumOfCards > 21) {
            return true;
        }
        else {
            return false;
        }
    }
    
}

