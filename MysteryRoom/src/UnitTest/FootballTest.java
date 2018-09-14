package UnitTest;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;


import Main.Football;

public class FootballTest {
	@Rule
	public final StandardOutputStreamLog stdOutLog = new StandardOutputStreamLog();

	
	@Test
	public void testKick() {
		Football ball = new Football();
		ball.kick();
		assertThat(stdOutLog.getLog(), containsString("Kicking the ball"));
	}
	
	@Test
	public void testPick() {
		Football ball = new Football();
		ball.pick();
		assertThat(stdOutLog.getLog(), containsString("Picking up the ball"));
	}
}
