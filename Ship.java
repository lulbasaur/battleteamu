class Ship{

    int start;
    int length;
    String dir;

    Cord cordVector[];

    //  0 1 2
    //0 + +     
    //1     
    //2     
    Ship(Cord start, int length, int direction){

	this.dir = dir;
	this.cordVector = new Cord[length];
	this.cordVector[0] = start;
	this.length = length;
	int tempX = start.getX();
	int tempY = start.getY();
	if (direction == 0) {§
	    //down
	    for (int i = 1; i < length; i++) {
		this.cordVector[i] = new Cord(tempX,1 + tempY++);
	    }
	}

	if (direction >= 1) {
	    //right
	    for (int i = 1; i < length; i++) {
		this.cordVector[i] = new Cord(1 + tempX++,tempY);
	    }
	}
    }


    int[] returnVectorY(){
	int vY[] = new int[this.length];
	    for (int i = 0; i < length; i++) {
		vY[i] = cordVector[i].getY();
	    }
	return vY;
    }

    int[] returnVectorX(){
	int vX[] = new int[this.length];
	    for (int i = 0; i < length; i++) {
		vX[i] = cordVector[i].getX();
	    }
	return vX;
    }
    
    int returnLength(){ return length;}


   
    
}
