package zee.cms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zee.cms.entity.Course;
import zee.cms.entity.Degree;
import zee.cms.service.DegreeService;

@Repository
public class CourseDAOImpl implements CourseDAO{

	@Autowired
	private DegreeService degreeService;
	
	
	
	private EntityManager entityManager;

	@Autowired
	public CourseDAOImpl(EntityManager entityManager) { this.entityManager = entityManager; }

	@Override
	public List<Course> findAll() {
		Query theQuery=entityManager.createQuery("FROM Course");
		List<Course> courses=theQuery.getResultList();
		return courses;
	}

	@Override
	public Course findById(long id) {
		Course course=entityManager.find(Course.class, id);
		return course;
	}

	@Override
	public void save(Course course) {
		course.setTitle(course.getTitle().trim());
		Course theCourse=entityManager.merge(course);
		course.setId(theCourse.getId());
	}

	@Override
	public void deleteById(long id) {
		Query theQuery=entityManager.createQuery("DELETE FROM Course where id=:courseId");
		theQuery.setParameter("courseId", id);
		theQuery.executeUpdate();
	}
}
