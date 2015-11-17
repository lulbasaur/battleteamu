import java.util.*;

class CoordinateGrid{
    Map<Integer,Coordinate> coordGrid = new HashMap<Integer,Coordinate>();
    int dimensions;


    CoordinateGrid(int d){
	this.dimensions = d;
	
	for (int y = 0; y < d; y++) {
	    for (int x = 0; x < d; x++) {
		Coordinate cord = new Coordinate(x,y);
		coordGrid.put(x + 10*y,cord);
	    }
	}
    }


    
}
