package courseRegistrationSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.service.impl.RegistrationEventServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {RegistrationEventController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RegistrationEventControllerTest {
    @Autowired
    private RegistrationEventController registrationEventController;

    @MockBean
    private RegistrationEventServiceImpl registrationEventServiceImpl;

    /**
     * Method under test: {@link RegistrationEventController#getAllRegistrationEvents()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetAllRegistrationEvents() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new RegistrationEventController()).getAllRegistrationEvents();
    }

    /**
     * Method under test: {@link RegistrationEventController#getRegistrationEventsStudentByIdDec(Long)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetRegistrationEventsStudentByIdDec() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new RegistrationEventController()).getRegistrationEventsStudentByIdDec(123L);
    }

    /**
     * Method under test: {@link RegistrationEventController#getRegistrationEventById(Long)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testGetRegistrationEventById() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new RegistrationEventController()).getRegistrationEventById(123L);
    }

    /**
     * Method under test: {@link RegistrationEventController#addNewRegistrationEvent(RegistrationEvent)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testAddNewRegistrationEvent() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: courseRegistrationSystem.domain.RegistrationEvent["startDate"])
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
        //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1306)
        //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:733)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:774)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:480)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:319)
        //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4624)
        //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:3869)
        //   See https://diff.blue/R013 to resolve this issue.

        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/registration-events/addRegistrationEvent")
                .contentType(MediaType.APPLICATION_JSON);
        LocalDateTime endDate = LocalDateTime.of(1, 1, 1, 1, 1);

        RegistrationEvent registrationEvent = new RegistrationEvent();
        registrationEvent.setEndDate(endDate);
        registrationEvent.setId(123L);
        registrationEvent.setRegistrationGroups(new ArrayList<>());
        registrationEvent.setStartDate(LocalDateTime.of(1, 1, 1, 1, 1));
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content((new ObjectMapper()).writeValueAsString(registrationEvent));
        MockMvcBuilders.standaloneSetup(registrationEventController).build().perform(requestBuilder);
    }

    /**
     * Method under test: {@link RegistrationEventController#deleteRegistrationById(Long)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testDeleteRegistrationById() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new RegistrationEventController()).deleteRegistrationById(123L);
    }
}

