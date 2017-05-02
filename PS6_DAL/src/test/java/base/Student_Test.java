package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;
import domain.StudentDomainModel;
import util.HibernateUtil;

import domain.PersonDomainModel;
import domain.StudentDomainModel;
import util.HibernateUtil;

public class Student_Test {
	static PersonDomainModel per1 = new PersonDomainModel();
	static PersonDomainModel per2 = new PersonDomainModel();
	static PersonDomainModel per3 = new PersonDomainModel();
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PersonDAL.addPerson(per1);
		PersonDAL.addPerson(per2);
		PersonDAL.addPerson(per3);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(per1.getPersonID());
		PersonDAL.deletePerson(per2.getPersonID());
		PersonDAL.deletePerson(per3.getPersonID());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(PersonDAL.getPerson(per1.getPersonID()).getFirstName() == null);
		assertTrue(PersonDAL.getPerson(per2.getPersonID()).getFirstName() == null);
		assertTrue(PersonDAL.getPerson(per3.getPersonID()).getFirstName() == null);
		
		assertTrue(PersonDAL.getPersons().size() == 3);
		PersonDAL.deletePerson(per3.getPersonID());
		
		assertTrue(PersonDAL.getPersons().size() == 2);
		
		per1.setFirstName("bob");
		PersonDAL.updatePerson(per1);
		assertTrue(PersonDAL.getPerson(per1.getPersonID()).getFirstName() == "bob");
	}

}
