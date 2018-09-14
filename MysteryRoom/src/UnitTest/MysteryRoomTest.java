package UnitTest;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.hamcrest.CoreMatchers.not;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import Main.Game;

public class MysteryRoomTest {
	private static final String EOL = System.getProperty("line.separator");
	@Rule
	public final StandardOutputStreamLog stdOutLog = new StandardOutputStreamLog();
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	
	/*
	 * To test a positive test case to enter the Game and simply exit it
	 * 
	 */
	
	@Test
	public void testSuccessfulEntryAndExit() {
		systemInMock.provideText("exit\n");
		Game.main(new String[] {});
		assertThat(stdOutLog.getLog(),
				is("Please give input or Enter exit to Quit" + EOL + "Thanks for playing the game. Quitting!!!" + EOL));
	}

	
	/*
	 *  To Test Positive case in which user describes and then exits the game
	 */
	@Test
	public void testSuccesfulDescribe() {
		systemInMock.provideText("describe\nexit\n");
		Game.main(new String[] {});
		assertThat(stdOutLog.getLog(), containsString("You are in Entrance"+EOL+
				"The room has following objects and the actions you can take with each"));
	}
	
	
	/*
	 *  Negative test case where user misspells the command
	 */
	@Test
	public void testFailureDescribe() {
		systemInMock.provideText("descibe\nexit\n");
		Game.main(new String[] {});
		assertThat(stdOutLog.getLog(), containsString("Please give input correctly"));
	}
	
	
	/*
	 *  To test successful operation to ask for a movement to a direction where a room is present - Positive
	 */
	
	@Test
	public void  testSuccessfulDirectionMove() {
		systemInMock.provideText("go back\nexit\n");
		Game.main(new String[] {});
		assertThat(stdOutLog.getLog(), not(containsString("Oops! No room found")));
	}
	
	
	/*
	 *  To test successful operation to ask for a movement to a direction where a room is not present  - Negative
	 */
	
	@Test
	public void  testFailedDirectionMove() {
		systemInMock.provideText("go left\nexit\n");
		Game.main(new String[] {});
		assertThat(stdOutLog.getLog(), containsString("Oops! No room found"));
	}
	
	
	/*
	 * To test a successful object pickup(action)
	 */
	@Test
	public void  testSuccesfulObjectPickup() {
		systemInMock.provideText("sit Chair\nexit\n");
		Game.main(new String[] {});
		assertThat(stdOutLog.getLog(), containsString("Sitting on chair"));
	}
	
	
	/*
	 *  To test a failed object action - The asked object is not present in the room
	 */
	@Test
	public void testFailureObject() {
		systemInMock.provideText("sit pool\nexit\n");
		Game.main(new String[] {});
		assertThat(stdOutLog.getLog(), containsString("Please give correct object name"));
	}
	
	
	/*
	 * To test failed action on the object - The asked action is not allowed with the object
	 */
	@Test
	public void testFailureAction() {
		systemInMock.provideText("stand chair\nexit\n");
		Game.main(new String[] {});
		assertThat(stdOutLog.getLog(), containsString("Please give right action"));
	}
	
	
	/*
	 * To test a non numeric input - Negative
	 */
	@Test
	public void testNumericInput() {
		systemInMock.provideText("-123324\nexit\n");
		Game.main(new String[] {});
		assertThat(stdOutLog.getLog(), containsString("Please give input correctly"));
	}
	
	
	/*
	 *  To test by entering more than 2 input words where first two make right syntax for operation  - postive
	 */
	@Test
	public void testMoreThan2InputWordSuccess() {
		systemInMock.provideText("sit Chair random\nexit\n");
		Game.main(new String[] {});
		assertThat(stdOutLog.getLog(), containsString("Sitting on chair"));
	}
	
	
	/*
	 *  To test entering more than 2 input words where there is a mistake in operation by considering only first two letters -  negative
	 */
	@Test
	public void testWronginputFailure() {
		systemInMock.provideText("sit plate random\nexit\n");
		Game.main(new String[] {});
		assertThat(stdOutLog.getLog(), containsString("Please give correct object name"));
	}
	
	
	
	
	
	
	
}
