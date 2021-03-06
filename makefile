JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Coordinate.java \
	CoordinateGrid.java \
	GameEngine.java \
	GUI.java \
	InvaderServer.java \
	Player.java \
	PlayerThread.java \
	ServerMessage.java \
	SocketClient.java \
	SocketClientDriver.java \
	Alien.java \
	Ship.java \
	GUIThread.java \			
	Ship.java \ 
classes: 
	$(CLASSES:.java=.class)
default: 
	classes
clean: 
	$(RM) *.class