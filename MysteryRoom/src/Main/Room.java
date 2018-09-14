package Main;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Room {
	private ArrayList<RoomObject> list;				// Stores the list of Objects present in the room
	private Room left;								// To store the Room present at left position
	private Room right;
	private Room back;
	private Room front;
	private Room top;
	private Room down;
	private String name;							// Name of the Room
	
	public Room(){
		list=new ArrayList<RoomObject>();          
	}
	
	
	/*
	 *   This method is called when the user asks for description of the current room
	 */
	public void describe() {
		System.out.println("You are in "+ this.name);
		System.out.println("The room has following objects and the actions you can take with each");
		for(RoomObject obj:list) {										// Iterate over the list of objects and looks for the actions involved with each
			System.out.print(obj.getClass().getSimpleName() +":  ");
			for(Method m:obj.getClass().getDeclaredMethods()) {
				System.out.print(m.getName()+"  ");
			}
			System.out.println("");
		}
		
	}
	
	public ArrayList<RoomObject> getList() {
		return list;
	}
	public void setList(ArrayList<RoomObject> list) {
		this.list = list;
	}
	public Room getLeft() {
		return left;
	}
	public void setLeft(Room left) {
		this.left = left;
	}
	public Room getRight() {
		return right;
	}
	public void setRight(Room right) {
		this.right = right;
	}
	public Room getBack() {
		return back;
	}
	public void setBack(Room back) {
		this.back = back;
	}
	public Room getFront() {
		return front;
	}
	public void setFront(Room front) {
		this.front = front;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Room getTop() {
		return top;
	}
	public void setTop(Room top) {
		this.top = top;
	}
	public Room getDown() {
		return down;
	}
	public void setDown(Room down) {
		this.down = down;
	}
	
	
}
