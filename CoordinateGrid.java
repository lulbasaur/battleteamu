import java.util.*;

class CoordinateGrid{
    Map<Integer,Coordinate> coordGrid = new HashMap<Integer,Coordinate>();
    int dimensions;

    private static final int HIT = 0;
    private static final int OCC = 1;
    private static final int UNOCC = 2;


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
	    case HIT:  coordGrid.get(key).hit();

		break;
	    case OCC:  coordGrid.get(key).occupy();

		break;
	    case UNOCC:  coordGrid.get(key).unOccupy();

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
	    return "error generating charAxis";
	}
    }

    
}
