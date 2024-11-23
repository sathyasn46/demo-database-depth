package learn.upskill.jpa.hibernate.demodatabasedepth.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import learn.upskill.jpa.hibernate.demodatabasedepth.DemoDatabaseDepthApplication;
import learn.upskill.jpa.hibernate.demodatabasedepth.entity.Course;

//@SpringBootTest(classes= DemoDatabaseDepthApplication.class)
@SpringBootTest
class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepo;

	@Test
	void contextLoads() {
		logger.info("===context loads===");
	}
	
	@Test
	void findById_BasicTest() {
		Course course = courseRepo.findCourseById(10001L);
		assertEquals("JPA & Hibernate", course.getName());
	}

	@Test
	@DirtiesContext
	void deleteById_BasicTest() {
		courseRepo.deleteCourseById(10006L);
		Course course = courseRepo.findCourseById(10006L);
		assertNull(course);
	}
	
	@Test
	@DirtiesContext
	void save_BasicTest() {
		Course course = courseRepo.findCourseById(10001L);
		assertEquals("JPA & Hibernate", course.getName());
		course.setName("JPA & Hibernate in 100 steps");
		courseRepo.save(course);
		Course savedCourse = courseRepo.findCourseById(10001L);
		assertEquals("JPA & Hibernate in 100 steps", savedCourse.getName());
		
	}
	
	@Test
	public void playWithEntityManagerTest() {
		logger.info("Inside playWithEntityManagerTest");
		courseRepo.playWithEntityManager();
		Course course = courseRepo.findCourseById(1);
		assertNotNull(course);
		assertTrue(true);
	}
}
