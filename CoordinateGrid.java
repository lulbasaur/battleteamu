import java.util.*;

class CoordinateGrid{
    Map<Integer,Coordinate> coordGrid = new HashMap<Integer,Coordinate>();
    int dimensions;


    CoordinateGrid(int d){
	this.dimensions = d;
	
	for (int i = 0; i < d; i++) {
	    for (int j = 0; i < d; i++) {
		Coordinate cord = new Coordinate(i,j);
		coordGrid.put(i + 10*j,cord);
	    }
	}
    }


    
}
