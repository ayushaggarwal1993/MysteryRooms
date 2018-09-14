package Main;
import java.util.ArrayList;

public class Map {
    private ArrayList<Room> list;  // Stores the list of rooms in map
    private Room currentRoom;      // Stores the reference to current room
    
    public Map() {
    	list= new ArrayList<Room>();
    }
    
	public Room getCurrentRoom() {
		return currentRoom;
	}
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	public ArrayList<Room> getList() {
		return list;
	}
	public void setList(ArrayList<Room> list) {
		this.list = list;
	}
}
