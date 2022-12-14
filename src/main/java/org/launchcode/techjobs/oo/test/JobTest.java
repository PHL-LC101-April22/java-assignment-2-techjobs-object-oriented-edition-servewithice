package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
        @Test
        public void testSettingJobId() {
            Job testJob1 = new Job();
            Job testJob2 = new Job();
            assertNotEquals(testJob1.getId(), testJob2.getId());
        }

        @Test
        public void testJobConstructorSetsAllFields() {
            Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            assertTrue(testJob.getName() instanceof String);
            assertTrue(testJob.getEmployer() instanceof Employer);
            assertTrue(testJob.getLocation() instanceof Location);
            assertTrue(testJob.getPositionType() instanceof PositionType);
            assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
            assertEquals("Product tester", testJob.getName());
            assertEquals("ACME", testJob.getEmployer().getValue());
            assertEquals("Desert", testJob.getLocation().getValue());
            assertEquals("Quality control", testJob.getPositionType().getValue());
            assertEquals("Persistence", testJob.getCoreCompetency().getValue());
        }

        @Test
        public void testJobsForEquality() {
            Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            assertFalse(testJob1.equals(testJob2));
        }

        @Test
        public void testToStringStartsAndEndsWithNewLine() {
            Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            assertEquals('\n', job.toString().charAt(0));
            assertEquals('\n', job.toString().charAt(job.toString().length()-1));
        }

        @Test
        public void testToStringContainsCorrectLabelsAndData() {
            Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            String jobString = "\n" +
                    "ID: " + job.getId() +
                    "\nName: Product tester" +
                    "\nEmployer: ACME" +
                    "\nLocation: Desert" +
                    "\nPosition Type: Quality control" +
                    "\nCore Competency: Persistence" +
                    "\n";
            assertEquals(jobString, job.toString());
        }

        @Test
        public void testToStringHandlesEmptyField() {
            Job job = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            String jobString = "\n" +
                    "ID: " + job.getId() +
                    "\nName: Product tester" +
                    "\nEmployer: Data not available" +
                    "\nLocation: Desert" +
                    "\nPosition Type: Quality control" +
                    "\nCore Competency: Persistence" +
                    "\n";
            assertEquals(jobString, job.toString());
        }
}

