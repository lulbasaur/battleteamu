class GameEngine{


    CoordinateGrid CD;
    Coordinate p1Position = new Coordinate(9,19);
    Coordinate p2Position = new Coordinate(10,20);
    
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
		    int updatedX = p1Position.getX() + 1;
		    int sameY = p1Position.getY();
		    p1Position.alterCoordinate(updatedX,sameY);
		}
		break;
	    case 1:
		//p1 left
		if(p1Position.getX() < CD.dimensions && p1Position.getX() > 1){
		    int updatedX = p1Position.getX() - 1;
		    int sameY = p1Position.getY();
		    p1Position.alterCoordinate(updatedX,sameY);
		}
		break;
	    }
	}
	else if(player == 2){
	    switch(rightleft){
		//p2 right
	    case 0:
		if(p2Position.getX() < CD.dimensions && p2Position.getX() > 1){
		    int updatedX = p2Position.getX() + 1;
		    int sameY = p2Position.getY();
		    p2Position.alterCoordinate(updatedX,sameY);
		}
		break;
		//p2 left
	    case 1:
		if(p2Position.getX() < CD.dimensions && p2Position.getX() > 1){
		    int updatedX = p2Position.getX() - 1;
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
    

    public void killAlien(int player){
	int frontAlien = -1;
	if (player == 1){   //kolla om player 1 dödar en alien
	    int xAxis = p1Position.getX();
	    int maxLength = updateVector.length; 
	    int i = 2;
	   
	    while(i < maxLength){
		if (updateVector[i].isAlien() && updateVector[i].getX() == xAxis){
		    if (updateVector[i].getY() > frontAlien){
			frontAlien = i;
		    }
		}
		i++;
	    }
	    updateVector[frontAlien].empty();
	}		    	    
	if (player == 2){  //kolla om player 2 dödar en alien
	    int xAxis = p1Position.getX();
	    // int yAxis = (CD.dimensions - 2);
	    int maxLength = updateVector.length; /// kolla upp det
	    int i = 2;
	
	    while(i < maxLength){
		if (updateVector[i].isAlien() && updateVector[i].getX() == xAxis){
		    if (updateVector[i].getY() > frontAlien){
			frontAlien = i;
		    }
		}
		i++;
	    }
	    updateVector[frontAlien].empty();
	}	
    }
    
    //   public void moveAlien(){
	
    

    /*

fire metod:

int player

om player 1 kolla vart han befinner sig i x led

finns det några alien i x led



     */
    
    
}
