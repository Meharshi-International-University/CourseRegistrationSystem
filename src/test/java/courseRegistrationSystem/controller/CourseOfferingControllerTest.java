package courseRegistrationSystem.controller;

import static org.mockito.Mockito.mock;

import courseRegistrationSystem.domain.CourseOffering;
import org.junit.Ignore;
import org.junit.Test;

public class CourseOfferingControllerTest {
    /**
     * Method under test: {@link CourseOfferingController#getRegistrationAlls()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetRegistrationAlls() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        //(new CourseOfferingController()).getRegistrationAlls();
    }

    /**
     * Method under test: {@link CourseOfferingController#getCourseOfferingyId(Long)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetCourseOfferingyId() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new CourseOfferingController()).getCourseOfferingyId(123L);
    }

    /**
     * Method under test: {@link CourseOfferingController#addNewCourseOffering(CourseOffering)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testAddNewCourseOffering() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        CourseOfferingController courseOfferingController = new CourseOfferingController();
        courseOfferingController.addNewCourseOffering(new CourseOffering());
    }

    /**
     * Method under test: {@link CourseOfferingController#addNewCourseOffering(CourseOffering)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testAddNewCourseOffering2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new CourseOfferingController()).addNewCourseOffering(mock(CourseOffering.class));
    }
}

