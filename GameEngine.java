class GameEngine{


    CoordinateGrid CD;
    Coordinate p1Position = new Coordinate(5,5);
    Coordinate p2Position = new Coordinate(7,7);
    
    Coordinate[] updateVector;
    
    public GameEngine(CoordinateGrid CD){
	this.CD = CD;
	
    }

    public void init(int x1,int y1,int x2,int y2, int alienNr){
	p1Position.ship1();
	p1Position.alterCoordinate(x1,y1);

	p2Position.ship2();
	p2Position.alterCoordinate(x2,y2);
	
	updateVector = new Coordinate[alienNr + 2];
	
	int len = updateVector.length;
 
	updateVector[0] = p1Position;
	updateVector[1] = p2Position;

	int x = 3;
	int y = 3;
	
	for(int i = 2 ; i < len; i++){
	    updateVector[i] = new Coordinate(x++,y);
	    updateVector[i].alien();		
	}
    }

    public void movePlayer(int player, int rightleft){
	if(player == 1){
	    switch(rightleft){
	    case 0:
		//p1 right
		if(p1Position.getX() < CD.dimensions && p1Position.getX() > 1){
		    int updatedX = p1Position.getX() - 1;
		    int sameY = p1Position.getY();
		    p1Position.alterCoordinate(updatedX,sameY);
		}
		break;
	    case 1:
		//p1 left
		if(p2Position.getX() < CD.dimensions && p2Position.getX() > 1){
		    int updatedX = p2Position.getX() + 1;
		    int sameY = p2Position.getY();
		    p2Position.alterCoordinate(updatedX,sameY);
		}
		break;
	    }
	}
	else if(player == 2){
	    switch(rightleft){
		//p2 right
	    case 0:
		if(p2Position.getX() < CD.dimensions && p2Position.getX() > 1){
		    int updatedX = p2Position.getX() - 1;
		    int sameY = p2Position.getY();
		    p2Position.alterCoordinate(updatedX,sameY);
		}
		break;
		//p2 left
	    case 1:
		if(p2Position.getX() < CD.dimensions && p2Position.getX() > 1){
		    int updatedX = p2Position.getX() + 1;
		    int sameY = p2Position.getY();
		    p2Position.alterCoordinate(updatedX,sameY);
		}
		break;
	    }
	}
	
    }

    public Coordinate[] returnUpdateVector(){
	Coordinate[] uV = updateVector.clone();
	return uV;
    }
    




    
}
