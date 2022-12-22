package courseRegistrationSystem;

import courseRegistrationSystem.domain.*;
import courseRegistrationSystem.enums.RegistrationEventStatus;
import courseRegistrationSystem.utils.EmailService;
import courseRegistrationSystem.repository.*;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;


import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
@EnableKafka
@EnableScheduling

public class CourseRegistrationSystemApplication implements CommandLineRunner {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;


    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private  AcademicBlockRepository academicBlockRepository;

    @Autowired
    private CourseOfferingRepository courseOfferingRepository;

    @Autowired
    private RegistrationGroupRepository registrationGroupRepository;

    @Autowired
    private RegistrationEventRepository registrationEventRepository;

    public static void main(String[] args) {
        SpringApplication.run(CourseRegistrationSystemApplication.class, args);

    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }




    @Override
    public void run(String... args) throws Exception {
     log.info("Inside run method loading Data.....");
     saveAddress();
     saveStudentAndAddress();
     saveCourseDetails();
     saveRegistrationEvent();


    }

    private void saveRegistrationEvent() {
        List<Student> fallFppStudents = new ArrayList<>();
        fallFppStudents.add(getStudentById(1l));
        fallFppStudents.add(getStudentById(2l));

        List<Student> fallMppStudents = new ArrayList<>();
        fallFppStudents.add(getStudentById(3l));
        fallFppStudents.add(getStudentById(4l));

        List<Student> springFppStudents = new ArrayList<>();
        springFppStudents.add(getStudentById(5l));
        springFppStudents.add(getStudentById(6l));

        List<Student> springMppStudents = new ArrayList<>();
        springMppStudents.add(getStudentById(7l));
        springMppStudents.add(getStudentById(8l));
/**
 * This is list blocks for FPP students
 */
        List<AcademicBlock> fallFppAcademicB= new ArrayList<>();
        fallFppAcademicB.add(getAcademicBlockById(1l));
        fallFppAcademicB.add(getAcademicBlockById(2l));

/**
 * This is list blocks for MPP students
 */
        List<AcademicBlock> fallMppAcademicB= new ArrayList<>();
        fallMppAcademicB.add(getAcademicBlockById(3l));


//        fallFppAcademicB.add(getAcademicBlockById(3l));
//        fallFppAcademicB.add(getAcademicBlockById(4l));
//        fallFppAcademicB.add(getAcademicBlockById(5l))
//        fallFppAcademicB.add(getAcademicBlockById(6l));


/**
 * This is list groups for FPP students in Fall
 */
        RegistrationGroup fallFPP= new RegistrationGroup("fallFPP");
        fallFPP.setAcademicBlocks(fallFppAcademicB);
        fallFPP.setStudents(fallFppStudents);

        /**
         * This is list groups for MPP students
         */
        RegistrationGroup fallMPP= new RegistrationGroup("fallMPP");
        fallMPP.setAcademicBlocks(fallMppAcademicB);
        fallMPP.setStudents(fallMppStudents);

        RegistrationGroup springFPP= new RegistrationGroup("springFPP");
        springFPP.setStudents(springFppStudents);


        RegistrationGroup springMPP= new RegistrationGroup("springMPP");
        springMPP.setStudents(springMppStudents);

        registrationGroupRepository.save(fallFPP);
        registrationGroupRepository.save(fallMPP);
        registrationGroupRepository.save(springFPP);
        registrationGroupRepository.save(springMPP);

        RegistrationEvent event= new RegistrationEvent
                (LocalDateTime.of(LocalDate.of(2022,10,20),LocalTime.now()),
                        LocalDateTime.of(LocalDate.of(2022,10,30),LocalTime.now()),
                        RegistrationEventStatus.CLOSED);
        List<RegistrationGroup> groupList=new ArrayList<>();
        groupList.add(getGroupById(1l));
        groupList.add(getGroupById(2l));

        event.setRegistrationGroups(groupList);

        RegistrationEvent event2= new RegistrationEvent
                (LocalDateTime.of(LocalDate.of(2022,12,19),LocalTime.now()),
                        LocalDateTime.of(LocalDate.of(2023,01,05),LocalTime.now()),RegistrationEventStatus.OPEN);

        List<RegistrationGroup> groupListSpring=new ArrayList<>();
        groupListSpring.add(getGroupById(3l));
        groupListSpring.add(getGroupById(4l));

        event2.setRegistrationGroups(groupListSpring);
          registrationEventRepository.save(event);
        registrationEventRepository.save(event2);

    }
    private Student getStudentById(Long studentId){
        return studentRepository.findById(studentId).orElseThrow(()-> new RuntimeException("Student not found"));

    }
    private RegistrationGroup getGroupById(Long registratioGroupId){
        return registrationGroupRepository.findById(registratioGroupId).orElseThrow(()-> new RuntimeException("RegistrationGroup not found"));

    }

    private AcademicBlock getAcademicBlockById(Long academicBlockId){
        return academicBlockRepository.findById(academicBlockId).orElseThrow(()-> new RuntimeException("AcademicBlock not found"));

    }

    public void saveCourseDetails(){
        Course fpp = new Course("CS301","FPP","desc1");
        Course mpp = new Course("CS401","MPP","desc1");
        Course cc = new Course("CS516","Cloud Computing","desc1");
        Course ea = new Course("CS544","Enterprise Architecture","desc1");
        Course dbms = new Course("CS425","DataBaseManagementSystem","desc");
        Course wap = new Course("CS455","WebApplicationProgramming","desc1");
        ea.setPrerequisite(Arrays.asList(dbms,wap));

         courseRepository.save(fpp);
        courseRepository.save(mpp);
        courseRepository.save(cc);
        courseRepository.save(dbms);
        courseRepository.save(wap);
        courseRepository.save(ea);


        AcademicBlock dec = new AcademicBlock("12A-12D","Dec 2022", LocalDateTime.of(LocalDate.of(2022,12,1), LocalTime.MIDNIGHT),
                LocalDateTime.of(LocalDate.of(2022,12,30),LocalTime.MIDNIGHT));
        AcademicBlock nov = new AcademicBlock("11A-11D","Nov 2022", LocalDateTime.of(LocalDate.of(2022,11,1), LocalTime.MIDNIGHT),
                LocalDateTime.of(LocalDate.of(2022,12,30),LocalTime.MIDNIGHT));
        AcademicBlock oct = new AcademicBlock("10A-10D","Oct 2022", LocalDateTime.of(LocalDate.of(2022,10,1), LocalTime.MIDNIGHT),
                LocalDateTime.of(LocalDate.of(2022,12,30),LocalTime.MIDNIGHT));

        AcademicBlock jan = new AcademicBlock("01A-01D","Jan 2023", LocalDateTime.of(LocalDate.of(2023,01,1), LocalTime.MIDNIGHT),
                LocalDateTime.of(LocalDate.of(2023,01,30),LocalTime.MIDNIGHT));

        AcademicBlock feb = new AcademicBlock("02A-02D","Feb 2023", LocalDateTime.of(LocalDate.of(2023,02,1), LocalTime.MIDNIGHT),
                LocalDateTime.of(LocalDate.of(2023,02,28),LocalTime.MIDNIGHT));

        AcademicBlock marc = new AcademicBlock("03A-03D","March 2023", LocalDateTime.of(LocalDate.of(2023,03,1), LocalTime.MIDNIGHT),
                LocalDateTime.of(LocalDate.of(2023,03,30),LocalTime.MIDNIGHT));

        academicBlockRepository.save(dec);
        academicBlockRepository.save(nov);
        academicBlockRepository.save(oct);
        academicBlockRepository.save(jan);
        academicBlockRepository.save(feb);
        academicBlockRepository.save(marc);



    CourseOffering decEa = new CourseOffering(30, 30, ea, dec ,"PS");
    CourseOffering decCc = new CourseOffering(30, 30, cc, dec,"UU");
    CourseOffering decFpp = new CourseOffering(30, 30, fpp, dec ,"SA");
    CourseOffering decMpp = new CourseOffering(30, 30, mpp, dec,"MY");

        CourseOffering novEa = new CourseOffering(30, 30, ea, nov ,"PS");
        CourseOffering novCc = new CourseOffering(30, 30, cc, nov,"UU");
        CourseOffering octFpp = new CourseOffering(30, 30, fpp, oct ,"SA");
        CourseOffering octMpp = new CourseOffering(30, 30, mpp, oct,"MY");


        courseOfferingRepository.save(decEa);
        courseOfferingRepository.save(decCc);
        courseOfferingRepository.save(decFpp);
        courseOfferingRepository.save(decMpp);
        courseOfferingRepository.save(novEa);
        courseOfferingRepository.save(novCc);
        courseOfferingRepository.save(octFpp);
        courseOfferingRepository.save(octMpp);

    }
    public void saveStudentAndAddress(){
        Address mailAddressShared = new Address("1000 Nth 4th St",getCity(1l),"52557");
        Address srijanaHomeAddress = new Address("Dholahity Satdobato",getCity(2l),"65200");


        Address homeAddressluwi = new Address("Dealne ave 1000 S",getCity(3l),"65200");

        Address homeAddressedu = new Address("Dealne ave 1000 S",getCity(4l),"62200");

        Address homeAddressromi = new Address("Dealne ave 1000 S",getCity(6l),"656300");

        addressRepository.save(srijanaHomeAddress);
        addressRepository.save(mailAddressShared);
        addressRepository.save(homeAddressluwi);
        addressRepository.save(homeAddressedu);
        addressRepository.save(homeAddressromi);


        Student srijana = new Student("21","Srijana Lama","srijana.lama@miu.edu",mailAddressShared,srijanaHomeAddress);
        studentRepository.save(srijana);

        Student romiyo = new Student("22","romiyo Julie","romiyo.Julie@miu.edu",mailAddressShared,homeAddressromi);
        studentRepository.save(romiyo);

        Student luwam = new Student("23","Luwam  Fish","luwam.fish@miu.edu",mailAddressShared,homeAddressluwi);
        studentRepository.save(luwam);

        Student edu = new Student("24","Edu Tes","edu.tes@miu.edu",mailAddressShared,homeAddressedu);
        studentRepository.save(edu);


        Student natnael = new Student("25","natnael  jish","natnael.jish@miu.edu",mailAddressShared,homeAddressluwi);
        studentRepository.save(natnael);

        Student daniel = new Student("26","dani Tes","dani.tes@miu.edu",mailAddressShared,homeAddressedu);
        studentRepository.save(daniel);

        Student abiel = new Student("27","abiel  ash","abiel.ash@miu.edu",mailAddressShared,homeAddressromi);
        studentRepository.save(abiel);

        Student febu = new Student("28","febu Tesi","febu.tems@miu.edu",mailAddressShared,homeAddressluwi);
        studentRepository.save(febu);

    }

    private City getCity(Long cityId){
       return cityRepository.findById(cityId).orElseThrow(()->new DataAccessResourceFailureException("City Not Found"));
    }

    public void  saveAddress(){
        Country  usa = new Country(1L,"USA");
        Country  eritrea = new Country(2L,"Eritrea");
        Country  rwanda = new Country(3L,"Rwanda");
        Country  nepal = new Country(4L,"Nepal");
        countryRepository.save(usa);
        countryRepository.save(eritrea);
        countryRepository.save(rwanda);
        countryRepository.save(nepal);

        State iowa = new State(1l,"Iowa",usa);
        State eritrea1 = new State(2l,"eritrea1",eritrea);
        State eritrea2 = new State(3l,"eritrea1",eritrea);
        State eritrea13 = new State(4l,"eritrea13",eritrea);
        State rwanda1 = new State(5l,"rwanda1",rwanda);
        State bagmati = new State(6l,"Bagmati",nepal);

        stateRepository.save(iowa);
        stateRepository.save(eritrea1);
        stateRepository.save(eritrea2);
        stateRepository.save(eritrea13);
        stateRepository.save(rwanda1);
        stateRepository.save(bagmati);


        City fairfield = new City(1l,"Fairfield",iowa);
        City kathmandu = new City(2l,"Kathmandu",bagmati);
        City eriC1 = new City(3l,"eric1",eritrea1);
        City eriC2 = new City(4l,"eric2",eritrea1);
        City eriC3 = new City(5l,"eric3",eritrea1);
        City rwan1 = new City(6l,"rwan1",rwanda1);
        cityRepository.save(fairfield);
        cityRepository.save(kathmandu);
        cityRepository.save(eriC1);
        cityRepository.save(eriC2);
        cityRepository.save(eriC3);
        cityRepository.save(rwan1);
    }
}
