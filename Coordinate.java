class Coordinate{
    private int x;
    private int y;

    private boolean ship1;
    private boolean ship2;
    private boolean alien;
    private boolean lazer;
    private boolean empty;

    private int objectType;
    private int alienNumber;
    
    public Coordinate(int x, int y){
	this.x = x;
	this.y = y;
    }

    public void alterCoordinate(int x, int y){
	this.x = x;
	this.y = y;
    }
    
    public int getX(){ return x; }
    public int getY(){ return y; }

    public void ship1(){
	objectType = 1;
	this.ship1 = true;
	this.ship2 = false;
	this.alien = false;
	this.lazer = false;
	this.empty = false;
    }   
    public void ship2(){
	objectType = 2;
	this.ship1 = false;
	this.ship2 = true;
	this.alien = false;
	this.lazer = false;
	this.empty = false;
    }   
    public void alien(int number){
	objectType = 3;
	alienNumber = number;
	this.ship1 = false; 
	this.ship2 = false;
	this.alien = true;
	this.lazer = false;
	this.empty = false;
    }
    public void lazer(){
	objectType = 4;
	this.ship1 = false; 
	this.ship2 = false;
	this.alien = false;
	this.lazer = true;
	this.empty = false;
    }
    public void empty(){
	objectType = 0;
	this.ship1 = false; 
	this.ship2 = false;
	this.alien = false;
	this.lazer = false;
	this.empty = true;
    }

    public boolean isShip1(){ return ship1; }
    public boolean isShip2(){ return ship2; }
    public boolean isAlien(){ return alien; }
    public boolean isLazer(){ return lazer; }
    public boolean isEmpty(){ return empty; }

    public int getObjectType(){ return objectType; }

    public int getAlienNumber(){ return alienNumber; }
    
    public String returnSymbol(){

	if(this.ship1){
	    return " s ";
	}
	else if(this.ship2){
	    return " S ";
	}
	else if(this.alien){
	    return " A ";
	}
	else if(this.lazer){
	    return " | ";
	}
	else{
	    return " . ";
	}
    }
}
