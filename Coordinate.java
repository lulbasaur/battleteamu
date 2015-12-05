class Coordinate{
    private int x;
    private int y;

    private boolean ship1;
    private boolean ship2;
    private boolean alien;
    private boolean lazer;
    private boolean empty;

    private int objectType;
    
    public Coordinate(int x, int y){
	this.x = x;
	this.y = y;
	this.empty = true;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }

    public void ship1(){ this.ship1 = true; objectType = 1; }   
    public void ship2(){ this.ship2 = true; objectType = 2; }   
    public void alien(){ this.alien = true; objectType = 3; }
    public void lazer(){ this.lazer = true; objectType = 4; }
    public void empty(){ this.empty = true; objectType = 5; }

    public boolean isShip1(){ return ship1; }
    public boolean isShip2(){ return ship2; }
    public boolean isAlien(){ return alien; }
    public boolean isLazer(){ return lazer; }
    public boolean isEmpty(){ return empty; }

    public int getObjectType(){ return objectType; }
    
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
