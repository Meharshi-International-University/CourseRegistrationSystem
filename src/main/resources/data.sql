-- Country

use course_registrationdb;
INSERT into country (id, name)
VALUES (1, 'US' );
-- Country
INSERT into country (id, name)
VALUES (2, 'Eritrea' );
select* from state;
-- State
-- INSERT into state (id, statename, country_id)
-- VALUES (1, 'IOWA' ,1);
-- State
-- INSERT into state (id, statename, country_id)
-- VALUES (2, 'Maekel' ,2);

-- City
select* from city;
INSERT into city (id, cityname,state_id)
VALUES (3, 'Demoin',1 );
-- City
INSERT into city (id, cityname,state_id)
VALUES (2, 'Asmara',2 );

-- Address
select * from Address;
INSERT into address (id, postal_code,street,city_id)
VALUES (3, '52557','8966 4th street',1 );
-- Address
INSERT into address (id, street, postal_code,city_id)
VALUES (2, '1524 Delane ave', '25897',2);

-- Address
INSERT into address (id, street, postal_code,city_id)
VALUES (3, '1524 Delane ave', '25897',2);
-- Address
INSERT into address (id, street, postal_code,city_id)
VALUES (4, '3856 Drive ave', '25817',2);

-- Students
select * from student;
Insert Into student (id, student_id, name, email, mailing_address_id, home_address_id)
VALUES (1, '111', 'Luwam', 'Lwan@miu.edu', 1, 2);

Insert Into student (id, student_id, name, email, mailing_address_id, home_address_id)
VALUES (2, '112', 'Edu', 'Edu@miu.edu', 2, 1);

Insert Into student (id, student_id, name, email, mailing_address_id, home_address_id)
VALUES (3, '113', 'John', 'John@miu.edu', 2, 2);

Insert Into student (id, student_id, name, email, mailing_address_id, home_address_id)
VALUES (4, '114', 'Natnael', 'Natnael@miu.edu', 1, 1);

-- Courses
select * from course;
INSERT INTO course (id, course_code, name, description)
VALUES (1, 'CS544', 'EA', 'Enterprise Architecture');

INSERT INTO course (id, course_code, name, description)
VALUES (2, 'CS472', 'WAP', 'Web Programming');

INSERT INTO course (id, course_code, name, description)
VALUES (3, 'CS545', 'WAA', 'Web Application Architecture');


INSERT INTO course (id, course_code, name, description)
VALUES (4, 'CS390', 'FPP', 'Fundamental Programming Practice');


INSERT INTO course (id, course_code, name, description)
VALUES (5, 'CS590', 'SA', 'Software Architecture');



-- Course CourseOffering
-- INSERT INTO COURSE_COURSE_OFFERINGS (course_id, course_offerings_id)
-- VALUES ( 1, 1 );
--
-- INSERT INTO COURSE_COURSE_OFFERINGS (course_id, course_offerings_id)
-- VALUES ( 2, 2 );
--
-- INSERT INTO COURSE_COURSE_OFFERINGS (course_id, course_offerings_id)
-- VALUES ( 3, 3 );
--
-- INSERT INTO COURSE_COURSE_OFFERINGS (course_id, course_offerings_id)
-- VALUES ( 4, 4 );
--
-- INSERT INTO COURSE_COURSE_OFFERINGS (course_id, course_offerings_id)
-- VALUES ( 4, 5 );

-- Faculty

select * from faculty;
select* from course_offering;
INSERT INTO faculty (id,faculty_id, name, email, title)
VALUES ( 1, 221,'Ahmed', 'Ahmed@miu.edu', 'Associate Professor' );

INSERT INTO faculty (id,faculty_id, name, email, title)
VALUES ( 2, 222,'Wzan', 'Wazan@miu.edu', 'Professor' );

INSERT INTO faculty (id,faculty_id, name, email, title)
VALUES ( 3, 223,'Keven', 'Keven@miu.edu', 'Associate Professor' );

INSERT INTO faculty (id,faculty_id, name, email, title)
VALUES ( 4, 224,'Rima', 'Rima@miu.edu', 'Assistant Professor' );

INSERT INTO faculty (id,faculty_id, name, email, title)
VALUES ( 5, 225,'Sanad', 'Sanad@miu.edu', 'Assistant Professor' );

-- Registration Group
INSERT INTO registration_group (registration_group_id, name)
VALUES ( 1, 'FPP Group Registration' );

INSERT INTO registration_group (registration_group_id, name)
VALUES ( 2, 'MPP Group Registration' );

-- REGISTRATION_GROUP_STUDENTS
INSERT INTO registration_group_students (registration_group_registration_group_id, STUDENTS_ID)
values ( 1, 2 );

INSERT INTO registration_group_students (registration_group_registration_group_id, STUDENTS_ID)
values ( 2, 1 );

INSERT INTO registration_group_students (registration_group_registration_group_id, STUDENTS_ID)
values ( 1, 3 );

INSERT INTO REGISTRATION_GROUP_STUDENTS (registration_group_registration_group_id, STUDENTS_ID)
values ( 2, 4 );

-- Registration Event
INSERT INTO registration_event (id, start_date, end_date)
VALUES ( 1, '2022-12-20 12:21:47' , '2022-12-24 12:21:47');

INSERT INTO registration_event (id, start_date_time, end_date_time)
VALUES ( 2, '2022-12-25 12:21:47' , '2022-12-30 12:21:47' );

INSERT INTO registration_event (id, start_date_time, end_date_time)
VALUES ( 3, '2023-01-10 12:21:47' , '2023-01-15 12:21:47' );

-- REGISTRATION_EVENT_REGISTRATION_GROUPS
INSERT INTO registration_event_registration_groups (registration_event_id, registration_groups_registration_group_id )
VALUES ( 1, 2 );

INSERT INTO REGISTRATION_EVENT_REGISTRATION_GROUPS (registration_event_id, registration_groups_registration_group_id )
VALUES ( 2, 1 );

-- INSERT INTO REGISTRATION_EVENT_REGISTRATION_GROUPS (registration_event_id, registration_groups_registration_group_id )
-- VALUES ( 3, 1 );
--
-- INSERT INTO REGISTRATION_EVENT_REGISTRATION_GROUPS (registration_event_id, registration_groups_registration_group_id )
-- VALUES ( 3, 1);

-- Academic Block
INSERT INTO academic_block (id, block_code, semester, start_date,end_date, registration_group_id)
VALUES ( 1, 'AUG', 'winter', '2022-01-01 12:15:47', '2022-01-28 12:10:47' , 1);

INSERT INTO academic_block (id, block_code, semester, start_date,end_date, registration_group_id)
VALUES ( 2, 'SEP', 'spring', '2022-05-01 10:15:47', '2022-05-28 12:10:47', 2 );

INSERT INTO academic_block (id, block_code, semester, start_date,end_date, registration_group_id)
VALUES ( 3, 'NOV', 'summer', '2022-12-01 10:15:47', '2022-12-28 12:10:47', 1 );

-- CourseOffering  course_offering_code
INSERT INTO course_offering(id, course_offering_code, capacity, available_seats, course_id, academic_block_id)
VALUES (1, 'CS544', 50, 35, 1, 1);

INSERT INTO course_offering(id, course_offering_code, capacity, available_seats, course_id, academic_block_id)
VALUES (2, 'CS545', 25, 13 ,2, 2);

INSERT INTO course_offering(id, course_offering_code, capacity, available_seats, course_id, academic_block_id)
VALUES (3, 'CS472', 20, 15 , 3, 3);

INSERT INTO course_offering(id, course_offering_code, capacity, available_seats, course_id, academic_block_id)
VALUES (4, 'CS590', 35, 20, 4, 4);

INSERT INTO course_offering(id, course_offering_code, capacity, available_seats, course_id, academic_block_id)
VALUES (5, 'CS590', 35, 35 ,5, 5);


-- REGISTRATION_GROUP_ACADEMIC_BLOCKS
-- INSERT INTO REGISTRATION_GROUP_ACADEMIC_BLOCKS (REGISTRATION_GROUP_ID,ACADEMIC_BLOCKS_ID )
-- VALUES ( 1, 1 );
--
-- INSERT INTO REGISTRATION_GROUP_ACADEMIC_BLOCKS (REGISTRATION_GROUP_ID,ACADEMIC_BLOCKS_ID )
-- VALUES ( 1, 2 );
--
-- INSERT INTO REGISTRATION_GROUP_ACADEMIC_BLOCKS (REGISTRATION_GROUP_ID,ACADEMIC_BLOCKS_ID )
-- VALUES ( 2, 3 );
--
-- INSERT INTO REGISTRATION_GROUP_ACADEMIC_BLOCKS (REGISTRATION_GROUP_ID,ACADEMIC_BLOCKS_ID )
-- VALUES ( 2, 1 );

-- Registration Request
-- INSERT INTO registration_request (id, priority_number)
-- VALUES ( 1, 1 );
--
-- INSERT INTO registration_request (id, priority_number)
-- VALUES ( 2, 3 );
--
-- INSERT INTO registration_request (id, priority_number)
-- VALUES ( 3, 2 );

-- Request
-- INSERT INTO REGISTRATION_REQUEST (id, priority_number, course_offering_id)
-- values ( 1, 1, 1 );
--
-- INSERT INTO REGISTRATION_REQUEST (id, priority_number, course_offering_id)
-- values ( 2, 2, 2 );
--
-- INSERT INTO REGISTRATION_REQUEST (id, priority_number, course_offering_id)
-- values ( 4, 1,  3);
--
-- INSERT INTO REGISTRATION_REQUEST (id, priority_number,course_offering_id)
-- values ( 3, 2, 4 );

-- STUDENT_REGISTRATION_REQUESTS
