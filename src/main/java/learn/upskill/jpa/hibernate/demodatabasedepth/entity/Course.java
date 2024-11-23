package learn.upskill.jpa.hibernate.demodatabasedepth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private long id;
	//id only needs getter, as Id value will be taken care by JPA
	
	private String name;
	
	//noarg constructor
	protected Course() {}
	
	public Course(String name) {
		this.name= name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

//	@Override
//	public String toString() {
//	//	return "Course [name=" + name + "]";
//		return String.format("Course[%s]", name);
//	}
//	
	
	
}
