package learn.upskill.jpa.hibernate.demodatabasedepth.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import learn.upskill.jpa.hibernate.demodatabasedepth.entity.Course;


@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	//Create methods to access data in Course table
	public Course findCourseById(long id) {
		return em.find(Course.class, id);
	}
	
	// save() insert, update
	public void upsertCourseById(Course course) {
		 em.persist(course);
	}
	
	// save() insert, update
	public Course save(Course course) {
		if(findCourseById(course.getId()) == null)
			em.persist(course);
		else
			em.merge(course);
		
		return course;
		
	}
	
	//remove -> delete
	public void deleteCourseById(long id) {
		Course course = findCourseById(id);
		em.remove(course);
	}
	
	public void playWithEntityManager() {
		logger.info("Inside playWithEntityManager method");
		Course course1 = new Course("Mojo");
		em.persist(course1);
		course1.setName("Mojo PL");
		em.detach(course1);
		em.flush();

		
		Course course2 = new Course("Next");
		em.persist(course2);
		course2.setName("Next JS");
		em.detach(course2);
		em.flush();
		
//		em.flush();
//		em.detach(course1);
	}
	
}
