class GameEngine{

    CoordinateGrid CD;

    Coordinate[] aliens;
    int nextMove = 1; // 0 = left , 1 = right för alien

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
	    updateVector[i].alien(i-2);		
	}
    }

    public void movePlayer(int player, int rightleft){
	if(player == 1){
	    switch(rightleft){
	    case 0:
		//p1 right
		if(p1Position.getX() < CD.dimensions -1 && p1Position.getX() >= 0){
		    int updatedX = p1Position.getX() + 1;
		    int sameY = p1Position.getY();
		    p1Position.alterCoordinate(updatedX,sameY);
		    System.out.println("p1right " + updatedX);
		}
		else{
		    int sameX = CD.dimensions-1;
		    int sameY = p1Position.getY();
		    p1Position.alterCoordinate(sameX,sameY);
		}
		break;
	    case 1:
		//p1 left
		if(p1Position.getX() < CD.dimensions && p1Position.getX() > 0){
		    int updatedX = p1Position.getX() - 1;
		    int sameY = p1Position.getY();
		    p1Position.alterCoordinate(updatedX,sameY);
		    System.out.println("p1left " + updatedX);
		}
		else{
		    int sameX = 0;
		    int sameY = p1Position.getY();
		    p1Position.alterCoordinate(sameX,sameY);
		}
		break;
	    }
	}
    
	else if(player == 2){
	    switch(rightleft){
		//p2 right
	    case 0:
		if(p2Position.getX() < CD.dimensions -1 && p2Position.getX() >= 0){
		    int updatedX = p2Position.getX() + 1;
		    int sameY = p2Position.getY();
		    p2Position.alterCoordinate(updatedX,sameY);
		    System.out.println("p2right "  + updatedX);
		}
		else{
		    int sameX = CD.dimensions-1;
		    int sameY = p2Position.getY();
		    p1Position.alterCoordinate(sameX,sameY);	
		}
		break;
		//p2 left
	    case 1:
		if(p2Position.getX() < CD.dimensions && p2Position.getX() > 0){
		    int updatedX = p2Position.getX() - 1;
		    int sameY = p2Position.getY();
		    p2Position.alterCoordinate(updatedX,sameY);
		    System.out.println("p2left " + updatedX);
		}
	        else{
		    int sameX = 0;
		    int sameY = p2Position.getY();
		    p1Position.alterCoordinate(sameX,sameY);	
		}
		break;
	    }
	}
	
    }

    public Coordinate[] returnUpdateVector(){
	/*	Coordinate[] uV = updateVector.clone();
		return uV;*/
	return updateVector;
    }
    

    public void killAlien(int player){
	int frontAlien = -1;
	int maxLength = updateVector.length; 
	if (player == 1){   //kolla om player 1 dödar en alien
	    int xAxis = p1Position.getX();
	    int i = 2;
	   
	    while(i < maxLength){
		if (updateVector[i].isAlien() && updateVector[i].getX() == xAxis){
		    if (updateVector[i].getY() > frontAlien){
			frontAlien = i;
		    }
		}
		i++;
	    }
	    
	    if(frontAlien != -1){
		updateVector[frontAlien].shot();
	    } 
	}		  
  	    
	if (player == 2){  //kolla om player 2 dödar en alien
	    int xAxis = p1Position.getX();
	    // int yAxis = (CD.dimensions - 2);
	    int i = 2;
	
	    while(i < maxLength){
		if (updateVector[i].isAlien() && updateVector[i].getX() == xAxis){
		    if (updateVector[i].getY() > frontAlien){
			frontAlien = i;
		    }
		}
		i++;
	    }
	    
	    if(frontAlien != -1 ){
		updateVector[frontAlien].shot();
	    }
	}	
    }
    
    public void moveAlien(int nextMove){
	//looks if alien can move right. if not, move down
	boolean moveSideways = true;
	int maxLength = updateVector.length ;
	int i;
	int j;	   
	   
	for(i=2; i < maxLength && moveSideways == true && nextMove == 1; i++){
	    if(updateVector[i].isAlien() && updateVector[i].getX() == CD.dimensions)
		moveSideways = false;
	}
	   
	if (moveSideways == true){
	    for (j=2; j < maxLength; j++){
		if(updateVector[j].isAlien()){
		    int updatedX = updateVector[j].getX() + 1;
		    int sameY = updateVector[j].getY();
		    updateVector[j].alterCoordinate(updatedX,sameY);
		    nextMove = 0;
		}
	    }
	}
	
	if(moveSideways == false){
	    for(j=2; j < maxLength; j++){
		if(updateVector[j].isAlien()){
		    int sameX = updateVector[j].getX();
		    int updatedY = updateVector[j].getY() + 1;
		    updateVector[j].alterCoordinate(sameX,updatedY);
		    nextMove = 0;
		}	   
	    }
	}
   
	//looks if aliens can move left, if not move down
	for(i=2; i < maxLength && moveSideways == true && nextMove == 0; i++){
	    if(updateVector[i].isAlien() && updateVector[i].getX() == 0)
		moveSideways = false;
	}
       
	if (moveSideways == true){
	    for (j=2; j < maxLength; j++){
		if(updateVector[j].isAlien()){
		    int updatedX = updateVector[j].getX() - 1;
		    int sameY = updateVector[j].getY();
		    updateVector[j].alterCoordinate(updatedX,sameY);
		    nextMove = 1;
		}
	    }
	}

	if(moveSideways == false){
	    for(j=2; j < maxLength; j++){
		if(updateVector[j].isAlien()){
		    int sameX = updateVector[j].getX();
		    int updatedY = updateVector[j].getY() + 1;
		    updateVector[j].alterCoordinate(sameX,updatedY);
		    nextMove = 1;
		}
		   
	    }
	}
    }
}
    

