package UnitTest;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;


import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;


import Main.Bed;

public class BedTest {
	@Rule
	public final StandardOutputStreamLog stdOutLog = new StandardOutputStreamLog();

	
	@Test
	public void testSleep() {
		Bed bed = new Bed();
		bed.sleep();
		assertThat(stdOutLog.getLog(), containsString("Going to sleep"));
	}
	
	@Test
	public void testGetup() {
		Bed bed = new Bed();
		bed.getup();
		assertThat(stdOutLog.getLog(), containsString("Get up"));
	}
	
}
