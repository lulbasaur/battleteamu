import java.util.*;
import java.*;
import java.io.*;

class BattleRunner{

    String standardLine = " . . . . . . . . . .";
    
    BattleRunner(Ship s1){
	int x_Vector[] = s1.returnVectorX();
	int y_Vector[] = s1.returnVectorY();
	int lines = 10;
	PrintGrid(x_Vector,y_Vector,lines);
    }

    private void PrintGrid(int[] x_Vector, int[] y_Vector,int lines){
	int y_length = y_Vector.length;
	
	System.out.println(Arrays.toString(x_Vector));

	System.out.println(Arrays.toString(y_Vector));

	System.out.println("   0 1 2 3 4 5 6 7 8 9");

	int step = 0;
	
	for (int i = 0; i < lines; i++) {
	    if(step < y_length  && y_Vector[step] == i){
		System.out.println(returnLine(x_Vector,y_Vector[step],lines));
		step++;
	    }
	    else{
		System.out.println(i + " " + standardLine);
	    }
	}
    }

    // [3 4 5]
    //  0 1 2
    String returnLine(int xArray[], int yAxisNr, int N){
	String line = yAxisNr + " ";
	
	int i = 0;
	int step = 0;

	while(i < N){
	    if (step < xArray.length && xArray[step] == i)
		{ 
		    line = line + " x";
		    step++;
		    i++;
		}
	    else{
		line = line + " .";
		i++;
	    }
	}	
	return line;
    }    
}
