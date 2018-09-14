package Main;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * This is the main class to play the game. Please run the main method.
 * This is a command line game. You can give three types of input
 * describe - This gives you info about your current environment
 * go <direction>  - To move back,front,up,down,left,right   *** Note if you add more than 2 words, those will be neglected
 * <action> <object> - To perform an action on an available object   *** Note if you add more than 2 words, those will be neglected
 * 
 */
public class Game {
	private Map map;        // Holds the state of Map
	
	/*
	 * Constructor
	 */
	public Game() {
		this.map = new Map();
		this.startUp(map);		// Game setup while initializing
	}
	
	/*
	 * This calls the decribe method of current Room
	 */
	public void describe() {
		this.map.getCurrentRoom().describe();			
	}
	
	/*
	 * To route the input to either move in a direction or perform action with an object
	 */
	void route(String action, String toDo) {
		if ("go".equals(action)) {
			try {
				Method methodcall = this.getClass().getDeclaredMethod(toDo);        // Refer to the appropriate Direction movement method wrt input "toDO"
				methodcall.invoke(this);											// Calls the appropriate direction method
			} catch (NoSuchMethodException e) {
				System.out.println("Please give right direction...");
			} catch (Exception e) {
				System.out.println("Something went wrong...");
			}
		} else {
			try {
				Method methodcall = null;
				ArrayList<RoomObject> list = this.map.getCurrentRoom().getList();   // To get the list of objects present in current room
				RoomObject object = null;
				for (RoomObject obj : list) {										// Iterate through all the objects and check for the asked object and action on it
					if (toDo.equalsIgnoreCase(obj.getClass().getSimpleName())) {
						methodcall = obj.getClass().getDeclaredMethod(action);
						object = obj;
						break;
					}
				}

				if (methodcall == null) {											// If methodcall is null that means that the asked object is not present in the List
					System.out.println("Please give correct object name...");
				} else {
					methodcall.invoke(object);
				}
			} catch (NoSuchMethodException e) {
				System.out.println("Please give right action...");					// The action asked is not possible for the asked object
			} catch (Exception e) {
				System.out.println("Something went wrong...");
				;
			}
		}
	}
	/*
	 * To move in left direction
	 */
	void left() {
		System.out.println("Going left:");
		if (this.map.getCurrentRoom().getLeft() == null) {
			System.out.println("Oops! No room found");
		} else {
			System.out.println(this.map.getCurrentRoom().getLeft().getName());
			this.map.setCurrentRoom(this.map.getCurrentRoom().getLeft());
		}
	}
	
	/*
	 * To move in right direction 
	 */
	void right() {
		System.out.println("Going Right:");
		if (this.map.getCurrentRoom().getRight() == null) {
			System.out.println("Oops! No room found");
		} else {
			System.out.println(this.map.getCurrentRoom().getRight().getName());
			this.map.setCurrentRoom(this.map.getCurrentRoom().getRight());
		}

	}

	/*
	 * To move in front direction 
	 */
	void front() {
		System.out.println("Going front:");
		if (this.map.getCurrentRoom().getFront() == null) {
			System.out.println("Oops! No room found");
		} else {
			System.out.println(this.map.getCurrentRoom().getFront().getName());
			this.map.setCurrentRoom(this.map.getCurrentRoom().getFront());
		}
	}

	/*
	 * To move in back direction 
	 */
	void back() {
		System.out.println("Going back:");
		if (this.map.getCurrentRoom().getBack() == null) {
			System.out.println("Oops! No room found");
		} else {
			System.out.println(this.map.getCurrentRoom().getBack().getName());
			this.map.setCurrentRoom(this.map.getCurrentRoom().getBack());
		}
	}
	
	/*
	 * To move in up direction 
	 */
	void up() {
		System.out.println("Going up:");
		if (this.map.getCurrentRoom().getTop() == null) {
			System.out.println("Oops! No room found");
		} else {
			System.out.println(this.map.getCurrentRoom().getTop().getName());
			this.map.setCurrentRoom(this.map.getCurrentRoom().getTop());
		}

	}

	/*
	 * To move in down direction 
	 */
	void down() {
		System.out.println("Going Down:");
		if (this.map.getCurrentRoom().getDown() == null) {
			System.out.println("Oops! No room found");
		} else {
			System.out.println(this.map.getCurrentRoom().getDown().getName());
			this.map.setCurrentRoom(this.map.getCurrentRoom().getDown());
		}
	}

	/*
	 * This method setups the initial state of the map
	 */
	void startUp(Map map) {

		Room entranceRoom = new Room();
		Chair chair = new Chair();
		Bed bed = new Bed();
		entranceRoom.getList().add(bed);
		entranceRoom.getList().add(chair);
		Room centreRoom = new Room();
		Bed bed1 = new Bed();
		centreRoom.getList().add(bed1);
		Room backRoom = new Room();
		StudyTable table = new StudyTable();
		backRoom.getList().add(table);
		Room rightRoom = new Room();
		VideoGame game = new VideoGame();
		rightRoom.getList().add(game);
		Room leftRoom = new Room();
		Bucket bucket = new Bucket();
		leftRoom.getList().add(bucket);
		Room topFloorRoom = new Room();
		Football ball = new Football();
		topFloorRoom.getList().add(ball);
		Room basementRoom = new Room();
		SwimmingPool pool = new SwimmingPool();
		basementRoom.getList().add(pool);

		map.getList().add(basementRoom);
		map.getList().add(centreRoom);
		map.getList().add(leftRoom);
		map.getList().add(rightRoom);
		map.getList().add(topFloorRoom);
		map.getList().add(entranceRoom);
		map.getList().add(backRoom);

		entranceRoom.setName("Entrance");
		centreRoom.setName("Centre");
		backRoom.setName("Back");
		rightRoom.setName("Right");
		leftRoom.setName("Left");
		topFloorRoom.setName("Top");
		basementRoom.setName("Basement");

		entranceRoom.setBack(centreRoom);
		centreRoom.setFront(entranceRoom);
		centreRoom.setBack(backRoom);
		centreRoom.setLeft(leftRoom);
		centreRoom.setRight(rightRoom);
		centreRoom.setTop(topFloorRoom);
		centreRoom.setDown(basementRoom);
		rightRoom.setLeft(centreRoom);
		leftRoom.setRight(centreRoom);
		backRoom.setFront(centreRoom);
		topFloorRoom.setDown(centreRoom);
		basementRoom.setTop(centreRoom);
		map.setCurrentRoom(entranceRoom);

	}

	
	/*
	 * Main method to run
	 */
	public static void main(String args[]) {
		Game game = new Game();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Please give input or Enter exit to Quit");
			String input = scan.nextLine();
			String[] arr = input.split(" ");
			if ("exit".equalsIgnoreCase(input)) {
				System.out.println("Thanks for playing the game. Quitting!!!");
				break;
			} else if ("describe".equalsIgnoreCase(input)) {								// If user wants to describe the current scenario
				game.describe();
			} else if (arr.length >= 2 && arr[0] != null && arr[1] != null) {               // If user inputs 2 or more than two words
				game.route(arr[0], arr[1]);
			} else {
				System.out.println("Please give input correctly");							// All other inputs are invalid
			}
		}
		scan.close();
	}

}
