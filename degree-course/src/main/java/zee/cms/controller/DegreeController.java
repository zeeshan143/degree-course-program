package zee.cms.controller;

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
@RequestMapping("/degree")
public class DegreeController {

	@Autowired
	private DegreeService degreeService;
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/showDegreesAdmin")
	public String offeredDegreesAdmin(Model model) { 
		try {
			List<Degree> theDegrees = degreeService.findAll();
			model.addAttribute("degrees", theDegrees);
		} 
		catch (NullPointerException e) { }
		return "/staff/degrees-admin";
	}

	@GetMapping("/addDegree")
	public String addDegree(Model model) {
		Degree theDegree = new Degree();
		model.addAttribute("degree", theDegree);
		return "/staff/degree-form";
	}
	
	@PostMapping("/save")
	public String saveDegree(@ModelAttribute("degree") Degree theDegree) {
		degreeService.save(theDegree);
		return "redirect:/degree/showDegreesAdmin";
	}

	@GetMapping("/update")
	public String updateDegree(@RequestParam("degreeId") long theId, Model theModel) {
		Degree theDegree = degreeService.findById(theId);
		theModel.addAttribute("degree", theDegree);
		return "/staff/degree-form";
	}

	@GetMapping("/delete")
	public String deleteDegree(@RequestParam("degreeId") long theId) {
		Degree theDegree = degreeService.findById(theId);
		List<Course> courses = courseService.findAll();
		if (courses != null) {
			for (Course course : courses) {
				try {
					if (course.getDegree().getId() == theDegree.getId()) {
						courseService.deleteById(course.getId());
					}
				} 
				catch (NullPointerException e) { }
			}
		}
		degreeService.deleteById(theId);
		return "redirect:/degree/showDegreesAdmin";
	}

}
