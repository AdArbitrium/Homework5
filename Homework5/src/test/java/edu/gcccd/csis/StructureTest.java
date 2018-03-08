package edu.gcccd.csis;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Tests for a system that can track employee information for two organizations.
 * The Employee information you must (at least) track, is as follows:
 * Name, Job Title, Organization they work for, Birthday
 *
 * As for the Organization that the Employee works for, you must also (at the very least) track this information:
 * Organization Name, Number of Employees
 *
 * The system must be able to properly compare any two employees against each other to determine,
 * if they are the same Person. This means that if you compared two People,
 * with the same Name, Birthday, and Organization, the system should think that they are equal to one another.
 * If any of these properties are different, then the two People are not the same Person.
 * The same rules apply to comparing Organizations to one another.
 * Organizations with the same Organization name are to be thought of as equal,
 * different names means different organizations.
 */
public class StructureTest {
    Employee e1;
    Employee e2;
    Organization c1;
    Organization c2;

    @Before
    public void setUp(){
        e1 = new Employee("JackieChan","KungFuMaster","Google","SomeTime");
        e2 = new Employee("JackieChan","Actor","Google","SomeTime");
        c1 = new Organization("Google");
        c2 = new Organization("Google");
    }

    @Test
    public void employeeComplete() {
        assertNotNull(e1.getName());
        assertNotNull(e1.getBirthday());
        assertNotNull(e1.getJobTitle());
        assertNotNull(e1.getOrganization());

    }

    @Test
    public void employeeEq() {
        Employee e1 = null;
        Employee e2 = null;

        e1 = new Employee("JackieChan","KungFuMaster","Google","SomeTime");
        e2 = new Employee("JackieChan","Actor","Google","SomeTime");
        assertTrue(e1.equals(e2));

        e2.setOrganization("microsoft");
        assertNotEquals(e1, e2);

    }

    @Test
    public void companyEq() {
        assertTrue(c1.equals(c2));

        c2.setOrganization("microsoft");
        assertNotEquals(c1, c2);

    }

    @Test
    public void companyComplete() {
        Organization c1 = new Organization(null);
        assertNotNull(c1.getOrganization());
        assertNotNull(c1.getNumOfEmployee());
        assertTrue(c1.getNumOfEmployee() >= 0);
        c1 = new Organization("Google");
        assertEquals(c1.getOrganization(), "Google");

    }
}