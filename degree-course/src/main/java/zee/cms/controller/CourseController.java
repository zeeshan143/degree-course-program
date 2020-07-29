package zee.cms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import zee.cms.entity.Course;
import zee.cms.entity.Degree;
import zee.cms.service.CourseService;
import zee.cms.service.DegreeService;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private DegreeService degreeService;

	@Autowired
	private CourseService courseService;

	@GetMapping("/showCoursesAdmin")
	public String offeredCoursesAdmin(@RequestParam("degreeId") long theId, Model model) {
		try {
			List<Course> theCourses = courseService.findAll();
			List<Course> selectedCourses = new ArrayList<Course>();
			Degree degree = degreeService.findById(theId);
			for (Course course : theCourses) {
				if (course.getDegree().getId() == theId) { selectedCourses.add(course); }
			}
			model.addAttribute("courses", selectedCourses);
			model.addAttribute("deg", degree);
		} catch (NullPointerException e) { }
		return "/staff/courses-admin";
	}

	@GetMapping("/addCourse")
	public String addCourse(@RequestParam("degreeId") long theId, Model model) {
		Degree theDegree = degreeService.findById(theId);
		Course theCourse = new Course();
		model.addAttribute("degree", theDegree);
		model.addAttribute("course", theCourse);
		return "/staff/course-form";
	}

	@PostMapping("/save")
	public String saveCourse(@ModelAttribute("course") Course theCourse, @RequestParam("degreeId") long theId) {
		Degree theDegree = degreeService.findById(theId);
		theCourse.setDegree(theDegree);
		courseService.save(theCourse);
		return "redirect:/course/showCoursesAdmin"; // Issue: How to pass degreeId in this link (/course/showCoursesAdmin) ???
	}

}
