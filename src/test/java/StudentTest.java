import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

	Student john;

	@Before
	public void setup(){
		john = new Student(1, "John");
	}

	@Test
	public void testIfStudentObjCanBeCreated(){
		Student tom = null;

		assertNotNull(john);
		assertNull(tom);
	}

	@Test
	public void testIfFieldWork(){
		Student tom = new Student(2, "Tom");

		assertEquals(1, john.getId());
		assertEquals("John", john.getName());
		assertNotNull(john.getGrades());
		assertNotEquals("John", tom.getName());
	}

	@Test
	public void testIfAddGradeWorks(){

		assertEquals(0, john.getGrades().size());
		john.addGrade(100);
		john.addGrade(80);

		assertEquals(2, john.getGrades().size());
		assertEquals(100, (int) john.getGrades().get(0));
		assertEquals(80, (int) john.getGrades().get(1));
	}

	@Test
	public void testIfGetGradeAverageWorks(){
		john.addGrade(100);
		john.addGrade(80);

		assertEquals(90, john.getGradeAverage(), 0);

		john.addGrade(90);
		assertEquals(90, john.getGradeAverage(), 0);
	}

}