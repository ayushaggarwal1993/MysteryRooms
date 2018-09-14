package UnitTest;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;


import Main.StudyTable;

public class StudyTableTest {
	@Rule
	public final StandardOutputStreamLog stdOutLog = new StandardOutputStreamLog();

	
	@Test
	public void testStop() {
		StudyTable table = new StudyTable();
		table.stop();
		assertThat(stdOutLog.getLog(), containsString("Stop studying"));
	}
	
	@Test
	public void testStudy() {
		StudyTable table = new StudyTable();
		table.study();
		assertThat(stdOutLog.getLog(), containsString("Studying on the chair"));
	}
}
