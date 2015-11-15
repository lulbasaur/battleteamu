import java.util.*;
import java.*;
import java.io.*;
class BattleRunner{

    Ship s1;
    String standardLine = " . . . . . . . . .";
    
    
    BattleRunner(Ship s1){
	PrintGrid(s1);
	
    
    }




    private void PrintGrid(Ship s1){
	int xV[] = s1.returnVectorX();
	int yV[] = s1.returnVectorY();


	
	int x = xV[0];
	int y = yV[0];
	System.out.println(y);
	System.out.println(x);
	int lp = 0;
	int length = s1.returnLength();
	int N = 10;
	System.out.println(" 0 1 2 3 4 5 6 7 8 9");
	
	    for (int i = 0; i < N; i++) {
		if (x == i) {
		    System.out.println(returnLine(y,x,N));
		}
		else{
		    System.out.println(i + " " + standardLine);
		}
	    }

	
    }


    String returnLine(int index, int linenr, int N){
	String line = "" + linenr + " ";
	for (int i = 1; i < N; i++) {
	    if (index == i) {
		line = line + " *"; 
	    }
	    else line = line + " .";
	}
	line =  line;
	return line;
    }

    
    
}
