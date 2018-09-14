package UnitTest;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;


import Main.Bucket;

public class BucketTest {
	@Rule
	public final StandardOutputStreamLog stdOutLog = new StandardOutputStreamLog();

	
	@Test
	public void testFill() {
		Bucket bucket = new Bucket();
		bucket.fill();
		assertThat(stdOutLog.getLog(), containsString("Filling bucket"));
	}
	
	@Test
	public void testEmpty() {
		Bucket bucket = new Bucket();
		bucket.empty();
		assertThat(stdOutLog.getLog(), containsString("Emptying bucket"));
	}
}
