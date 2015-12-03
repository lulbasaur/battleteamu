import java.util.*;

class Battle{

    private static final int HIT = 0;
    private static final int OCC = 1;
    private static final int UNOCC = 2;
    
    public static void main(String[] args) {

	Window frame = new Window();
	frame.setVisible(true);
	
	CoordinateGrid CD = new CoordinateGrid(20);

	
	for (int i = 0; i < 20; i++) {
	    CD.alterGrid(OCC,i,0);
	}

	clearScreen();
	CD.printGrid();

	try {
	    Thread.sleep(2000); //1000 ms is one second.
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	
	for (int i = 0; i < 20; i++) {
	    CD.alterGrid(OCC,i,1);
	}
	
	
	clearScreen();
	CD.printGrid();

	try {
	    Thread.sleep(2000);                 //1000 milliseconds is one second.
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	
	for (int i = 0; i < 20; i++) {
	    CD.alterGrid(OCC,i,2);
	}
	
	
	clearScreen();
	CD.printGrid();

	try {
	    Thread.sleep(2000);                 //1000 milliseconds is one second.
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	
	for (int i = 0; i < 20; i++) {
	    CD.alterGrid(OCC,i,3);
	}
	
	
	clearScreen();
	CD.printGrid();
	
    }
    public static void clearScreen() {  
	System.out.print("\033[H\033[2J");  
	System.out.flush();  
    }  
	
}
