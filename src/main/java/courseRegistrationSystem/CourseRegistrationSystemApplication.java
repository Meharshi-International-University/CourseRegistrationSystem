package courseRegistrationSystem;

import courseRegistrationSystem.domain.*;
import courseRegistrationSystem.utils.EmailService;
import courseRegistrationSystem.repository.*;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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


    }

    public void saveCourseDetails(){
        Course fpp = new Course("CS301","FPP","desc1");
        Course mpp = new Course("CS401","MPP","desc1");
        Course cc = new Course("CS516","Cloud Computing","desc1");
        Course ea = new Course("CS544","Enterprise Architecture","desc1");
         courseRepository.save(fpp);
        courseRepository.save(mpp);
        courseRepository.save(cc);
        courseRepository.save(ea);

        AcademicBlock dec = new AcademicBlock("12A-12D","Dec 2022", LocalDateTime.of(LocalDate.of(2022,12,1), LocalTime.MIDNIGHT),
                LocalDateTime.of(LocalDate.of(2022,12,30),LocalTime.MIDNIGHT));
        AcademicBlock nov = new AcademicBlock("11A-11D","Nov 2022", LocalDateTime.of(LocalDate.of(2022,11,1), LocalTime.MIDNIGHT),
                LocalDateTime.of(LocalDate.of(2022,12,30),LocalTime.MIDNIGHT));
        AcademicBlock oct = new AcademicBlock("10A-10D","Oct 2022", LocalDateTime.of(LocalDate.of(2022,10,1), LocalTime.MIDNIGHT),
                LocalDateTime.of(LocalDate.of(2022,12,30),LocalTime.MIDNIGHT));
        academicBlockRepository.save(dec);
        academicBlockRepository.save(nov);
        academicBlockRepository.save(oct);



    CourseOffering decEa = new CourseOffering(30, 30, ea, dec ,"PS");
    CourseOffering decCc = new CourseOffering(30, 30, cc, dec,"UU");
    CourseOffering decFpp = new CourseOffering(30, 30, ea, dec ,"SA");
    CourseOffering decMpp = new CourseOffering(30, 30, ea, dec,"MY");


        courseOfferingRepository.save(decEa);
        courseOfferingRepository.save(decCc);
        courseOfferingRepository.save(decFpp);
        courseOfferingRepository.save(decMpp);

    }
    public void saveStudentAndAddress(){
        Address srijanaMailAddress = new Address("1000 Nth 4th St",getCity(1l),"52557");
        Address srijanaHomeAddress = new Address("Dholahity Satdobato",getCity(2l),"65200");

        addressRepository.save(srijanaHomeAddress);
        addressRepository.save(srijanaMailAddress);
        Student srijana = new Student("22","Srijana Lama","srijana.lama@miu.edu",srijanaMailAddress,srijanaHomeAddress);
        studentRepository.save(srijana);

        Student srijana2 = new Student("21","Srijana2 Lama2","srijana2.lama@miu.edu",srijanaMailAddress,srijanaHomeAddress);
        studentRepository.save(srijana2);


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
