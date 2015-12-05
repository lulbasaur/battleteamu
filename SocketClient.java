import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.awt.event.*;


class SocketClient{


    public static void main(String[] args) {
	ObjectInputStream inFromServer;
	ObjectOutputStream outToServer;
	String server = "192.168.0.2";
	int port = 2044;

	SocketClientDriver SCD = new SocketClientDriver(server, port);

    }
	   
}
	
