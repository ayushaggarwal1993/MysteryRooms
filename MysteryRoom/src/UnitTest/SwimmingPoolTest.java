package UnitTest;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import Main.SwimmingPool;

public class SwimmingPoolTest {
	@Rule
	public final StandardOutputStreamLog stdOutLog = new StandardOutputStreamLog();

	
	@Test
	public void testSwim() {
		SwimmingPool pool = new SwimmingPool();
		pool.swim();
		assertThat(stdOutLog.getLog(), containsString("Swimming in the pool"));
	}
	
	@Test
	public void testComeout() {
		SwimmingPool pool = new SwimmingPool();
		pool.comeout();
		assertThat(stdOutLog.getLog(), containsString("Coming out of the pool"));
	}
}
