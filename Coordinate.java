class Coordinate{
    private int x;
    private int y;

    private boolean hit;
    private boolean occupied;
    
    public Coordinate(int x, int y){
	this.x = x;
	this.y = y;
	this.hit = false;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }


    public boolean isOccupied(){ return occupied; }
    
    public boolean getHit(){ return hit; }    
    public void hit(){  this.hit = true; }   
    
}
