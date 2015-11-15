import java.util.*;
import java.*;
import java.io.*;

class Battleships{

    public static void main(String[] args) {
	System.out.println("Welcome to Battleships!");
	System.out.println(" 0 1 2 3 4 5 6 7 8 9");
	System.out.println("0  . . . . . . . . . ");
	System.out.println("1  . . . . . . . . . ");
	System.out.println("2  . . . . . . . . . ");
	System.out.println("3  . . . . . . . . . ");
	System.out.println("4  . . . . . . . . . ");
	System.out.println("5  . . . . . . . . . ");
	System.out.println("6  . . . . . . . . . ");
	System.out.println("7  . . . . . . . . . ");
	System.out.println("8  . . . . . . . . . ");
	System.out.println("9  . . . . . . . . . ");
		
	System.out.println("Place your Battleships!");


	Scanner in = new Scanner(System.in);

	System.out.print("Enter length of ship: ");
	int length = in.nextInt();
	
	System.out.print("Enter X Cordinate: ");
	int xCord = in.nextInt();
	
	System.out.print("Enter Y Cordinate: ");
	int yCord = in.nextInt();

	System.out.print("Place Down or Right?: ");
	int dir = in.nextInt();


	Cord cord = new Cord(xCord,yCord);
	Ship ship =  new Ship(cord,length,dir);

	BattleRunner runner = new BattleRunner(ship);
    }

    

    
}
