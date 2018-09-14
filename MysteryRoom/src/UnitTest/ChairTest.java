package UnitTest;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import Main.Chair;

public class ChairTest {
	@Rule
	public final StandardOutputStreamLog stdOutLog = new StandardOutputStreamLog();

	
	@Test
	public void testSit() {
		Chair chair = new Chair();
		chair.sit();
		assertThat(stdOutLog.getLog(), containsString("Sitting on chair"));
	}
	
	@Test
	public void testGetup() {
		Chair chair = new Chair();
		chair.getup();
		assertThat(stdOutLog.getLog(), containsString("Getting up from chair"));
	}
}
