import java.util.*;
import java.util.concurrent.*;

class CoordinateGrid{
    Map<Integer,Coordinate> coordGrid = new ConcurrentHashMap<Integer,Coordinate>();
    int dimensions;

    private static final int SHIP1 = 1;
    private static final int SHIP2 = 2;
    private static final int ALIEN = 3;
    private static final int LAZER = 4;
    private static final int EMPTY = 5;



    CoordinateGrid(int d){
	this.dimensions = d;
	
	for (int y = 0; y < d; y++) {
	    for (int x = 0; x < d; x++) {
		Coordinate cord = new Coordinate(x,y);
		coordGrid.put(x + dimensions * y,cord);
	    }
	}
    }

    public void printGrid(){
	int N = (dimensions * dimensions) - 1;
	int i = 0;
	int yAxis = 0;

	System.out.println(returnCharAxis(dimensions));
	
	while(i < N) {
	    String line = "";	
	    for (int j = 0; j < dimensions; j++) {
		line = line + coordGrid.get(i++).returnSymbol();
	    }
	    System.out.println(" " + line + " " + yAxis);
	    yAxis++;
	}
    }

    public void alterGrid(int choice, int x, int y){
	int key = x + dimensions * y;
	switch (choice)
	    {
	    case EMPTY:  coordGrid.get(key).empty();

		break;
	    case SHIP1:  coordGrid.get(key).ship1();

		break;
	    case SHIP2:  coordGrid.get(key).ship2();

		break;
	    case ALIEN:  coordGrid.get(key).alien();

		break;
	    case LAZER:  coordGrid.get(key).empty();

		break;
		     
	    }
    }

    static public String returnCharAxis(int d){
	if (d < 27) {
	    String axis = "";
	    for (int i = 0; i < d; i++) {
		axis += "  " + (char)(i+65);
	    }
	    return axis;
	}
	else{
	    return "Error generating charAxis";
	}
    }


    
}
