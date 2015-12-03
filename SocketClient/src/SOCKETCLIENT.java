import java.io.*;
import java.net.*;

public class SOCKETCLIENT {




	//------------------//
/*	public static void main(String[] args) throws Exception
	{
		SOCKETCLIENT CLIENT = new SOCKETCLIENT();
		CLIENT.run();
	}
*/

	public static void run(ActionButton BUTTON) throws Exception
	{
		String host = "vi bestämmer"; // bestäm host statiskt.
		int port  = 8080;  //port variabel
		
		Socket SOCKET = null;
		ObjectOutputStream OUT = null;
		BufferedReader IN = null;
		//BufferedReader STDIN = null;  används inte
		String MESSAGE;


		try {

			SOCKET = new Socket(host,port);
			OUT = new ObjectOutputStream(SOCKET.getOutputStream());
			IN = new BufferedReader(new InputStreamReader(SOCKET.getInputStream()));
		
			while(true){
			
				
				MESSAGE = IN.readLine();
				OUT.writeObject(BUTTON);
				OUT.flush();
				System.out.println(MESSAGE);
			}
			
			
			
		}catch (IOException e){
			System.err.println(e);
		}




	}


}





