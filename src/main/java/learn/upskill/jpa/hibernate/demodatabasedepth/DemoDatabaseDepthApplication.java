package learn.upskill.jpa.hibernate.demodatabasedepth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import learn.upskill.jpa.hibernate.demodatabasedepth.entity.Course;
import learn.upskill.jpa.hibernate.demodatabasedepth.repository.CourseRepository;

@SpringBootApplication
public class DemoDatabaseDepthApplication implements CommandLineRunner {
	
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoDatabaseDepthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Inside CL run");
//		Course course= courseRepo.findCourseById(10001L);
//		//logger.info("Find all courses ->{}", courseRepo.);
//		logger.info("{}",course);
//		courseRepo.findCourseById(10001L);
//		courseRepo.deleteCourseById(10002L);
//		courseRepo.upsertCourseById(new Course("Bootstrap"));
//		courseRepo.save(new Course("Microservices in 100 steps"));

		courseRepo.playWithEntityManager();
		
	}

}
