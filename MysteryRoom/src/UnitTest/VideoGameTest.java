package UnitTest;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import Main.VideoGame;

public class VideoGameTest {
	@Rule
	public final StandardOutputStreamLog stdOutLog = new StandardOutputStreamLog();

	
	@Test
	public void testOff() {
		VideoGame game = new VideoGame();
		game.switchOff();
		assertThat(stdOutLog.getLog(), containsString("Switching off the game"));
	}
	
	@Test
	public void testOn() {
		VideoGame game = new VideoGame();
		game.switchOn();
		assertThat(stdOutLog.getLog(), containsString("Switching on the game"));
	}
}
