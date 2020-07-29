package zee.cms.dao;

import java.util.List;

import zee.cms.entity.Course;
import zee.cms.entity.Degree;

public interface CourseDAO {

	public List<Course> findAll();
	public Course findById(long id);
	public void save(Course student);
	public void deleteById(long id);

}
