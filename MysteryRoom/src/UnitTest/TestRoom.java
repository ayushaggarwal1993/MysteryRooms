package UnitTest;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import Main.Bed;
import Main.Room;


public class TestRoom {
	@Rule
	public final StandardOutputStreamLog stdOutLog = new StandardOutputStreamLog();
	private static final String EOL = System.getProperty("line.separator");
	
	@Test
	public void testdescribe() {
		Room room = new Room();
		Bed bed = new Bed();
		room.getList().add(bed);
		room.setName("MasterRoom");
		room.describe();
		assertThat(stdOutLog.getLog(), containsString("You are in MasterRoom"+ EOL+ 
								"The room has following objects and the actions you can take with each"));
	}
	
	
}
