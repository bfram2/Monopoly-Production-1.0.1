package pieces;

public class Dice {
	private int die1;   // first die
    private int die2;   // second die
    private int diet;   // total die
	
        public Dice() {roll(); }       
        public void roll() {	
            die1 = (int)(Math.random()*6) + 1; // Roll a random number between 1 and 6. 
        	die2 = (int)(Math.random()*6) + 1;
            diet = die1 + die2;
        }
        public int getDie1() {return die1;}
        public int getDie2() {return die2;}
        public int getTotal() {return diet;}
}