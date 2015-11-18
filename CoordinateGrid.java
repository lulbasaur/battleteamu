import java.util.*;

class CoordinateGrid{
    Map<Integer,Coordinate> coordGrid = new HashMap<Integer,Coordinate>();
    int dimensions;


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
	
	while(i < N) {
	    String line = "";	
	    for (int j = 0; j < dimensions; j++) {
		line = line + coordGrid.get(i++).returnSymbol();
	    }
	    System.out.println(line);	    
	}
    }   
}
