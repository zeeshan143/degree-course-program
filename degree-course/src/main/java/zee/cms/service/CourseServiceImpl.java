package zee.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zee.cms.dao.CourseDAO;
import zee.cms.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseDAO courseDAO;

	@Autowired
	public CourseServiceImpl(CourseDAO courseDAO) { this.courseDAO = courseDAO; }

	@Override
	@Transactional
	public List<Course> findAll() { return courseDAO.findAll(); }

	@Override
	@Transactional
	public Course findById(long id) { return courseDAO.findById(id); }

	@Override
	@Transactional
	public void save(Course course) { courseDAO.save(course); }

	@Override
	@Transactional
	public void deleteById(long id) { courseDAO.deleteById(id); }

}
