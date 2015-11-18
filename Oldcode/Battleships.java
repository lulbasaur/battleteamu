import java.util.*;
import java.*;
import java.io.*;

class Battleships{

    public static void main(String[] args) {
	System.out.println("Welcome to Battleships!");
	System.out.println("   A B C D E F G H I J");
	System.out.println("0  . . . . . . . . . .");
	System.out.println("1  . . . . . . . . . .");
	System.out.println("2  . . . . . . . . . .");
	System.out.println("3  . . . . . . . . . .");
	System.out.println("4  . . . . . . . . . .");
	System.out.println("5  . . . . . . . . . .");
	System.out.println("6  . . . . . . . . . .");
	System.out.println("7  . . . . . . . . . .");
	System.out.println("8  . . . . . . . . . .");
	System.out.println("9  . . . . . . . . . .");
		
	System.out.println("Place your Battleships!");


	Scanner in = new Scanner(System.in);
	int lock = 1;

	while (lock == 1) {
	    //Skip length of ship, use fixed lengths (5 ships in total, size 5, 4, 3, 3, 2)
	    System.out.print("Enter length of ship: ");
	    int length = in.nextInt();

	    System.out.print("Place Down [0] or Right [1]?: ");
	    int dir = in.nextInt();
	    while (dir != 0 && dir != 1) {
		System.out.print("\nYou must enter a valid direction!\nPlace Down [0] or Right [1]?: ");
		dir = in.nextInt();
	    }
	
	    System.out.print("Enter X coordinate [A-J]: ");
	    int xCord = charToInt(in.next().trim().charAt(0));
	    while (xCord < 0 || xCord > 9) {
		System.out.print("\nYou must enter a valid coordinate!\nEnter X coordinate [A-J]: ");
		xCord = charToInt(in.next().trim().charAt(0));
	    }
	
	    System.out.print("Enter Y coordinate [0-9]: ");
	    int yCord = in.nextInt();
	    while (yCord < 0 || yCord > 9) {
		System.out.print("\nYou must enter a valid coordinate!\nEnter Y coordinate: ");
		yCord = in.nextInt();
	    }

	    Cord cord = new Cord(xCord,yCord);
	    Ship ship = new Ship(cord,length,dir);

	    if (ship.isWithinGrid() == true){
		BattleRunner runner = new BattleRunner(ship);
		lock = 0;
	

	    }
	    else {
		System.out.print("\nYour battleship must be within the grid!\n");
	    }
	}	
    }




    static public int charToInt(char c){
	char ch = Character.toUpperCase(c);
	int i = (int)ch;
	if(i-65 > -1 && i-65 < 10){
	    return i-65;
	}
	else{ return -1; }
    }
    
    
}
