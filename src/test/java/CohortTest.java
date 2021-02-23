import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CohortTest {

	Cohort emptyCohort;
	Cohort cohortWithOne;
	Cohort cohortWithMany;

	@Before
	public void setup(){
		emptyCohort = new Cohort();
		cohortWithOne = new Cohort();
		cohortWithMany = new Cohort();

		Student james = new Student(1, "James Dashner");
		james.addGrade(90);

		Student dave = new Student(2, "Dave Willmarth");
		dave.addGrade(100);
		dave.addGrade(100);
		dave.addGrade(100);

		cohortWithOne.addStudent(james);
		cohortWithMany.addStudent(james);
		cohortWithMany.addStudent(dave);
	}

	@Test
	public void testAddStudentWorks(){
		cohortWithMany.addStudent(new Student(3, "Rick Riordan"));

		assertEquals("Rick Riordan", cohortWithMany.getStudents().get(2).getName());
		cohortWithMany.addStudent(new Student(4, "Dakota Krout"));

		assertEquals(4, cohortWithMany.getStudents().size());
	}


	@Test
	public void testIfGetStudentsWork(){

		assertEquals(0, emptyCohort.getStudents().size());
		assertEquals(1, cohortWithOne.getStudents().size());
		assertEquals(1, cohortWithMany.getStudents().get(0).getId());
		assertEquals(2, cohortWithMany.getStudents().get(1).getId());
	}

	@Test
	public void testIfAvgIsCorrect(){
		double nan = Double.NaN;
		assertEquals(nan, emptyCohort.getCohortAverage(), 0);
		assertEquals(90.0, cohortWithOne.getCohortAverage(), 0);
		assertEquals(95.0, cohortWithMany.getCohortAverage(), 0);
	}

}