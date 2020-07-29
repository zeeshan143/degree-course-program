package zee.cms.service;

import java.util.List;

import zee.cms.entity.Course;

public interface CourseService {

	public List<Course> findAll();
	public Course findById(long id);
	public void save(Course student);
	public void deleteById(long id);

}
