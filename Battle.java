import java.util.*;

class Battle{

    private static final int HIT = 0;
    private static final int OCC = 1;
    private static final int UNOCC = 2;
    
    public static void main(String[] args) {
	
	CoordinateGrid CD = new CoordinateGrid(20);

	for (int i = 5; i < 10; i++) {
	    CD.alterGrid(HIT,i,5);
	}
	for (int i = 5; i < 10; i++) {
	    CD.alterGrid(HIT,2,i);
	}
	
	CD.printGrid();

    }
	
}
