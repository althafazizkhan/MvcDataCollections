package com.students;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.StudentDao;
import com.resource.StudentResource;

@Controller
public class secondController {

	@RequestMapping("/user")

	public ModelAndView studentMangement(HttpServletRequest request, HttpServletResponse response) {

		String n = request.getParameter("name");
		String ln = request.getParameter("Lname");
		String opr = request.getParameter("condition");

		ModelAndView mv = new ModelAndView();

		if (opr.equals("add")) {

			mv.addObject("FN", n);
			mv.addObject("LN", ln);

			StudentResource sr = new StudentResource();

			sr.setFirst_Name(n);
			sr.setLast_Name(ln);

			StudentDao sd = new StudentDao();
			sd.addStudents(sr);
			// sd.getAllStudents();

			mv.setViewName("student.jsp");

		}
		return mv;
	}

	@RequestMapping(value = ("/list"), method = RequestMethod.GET)
	public ModelAndView StudentList(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		StudentDao sd = new StudentDao();

		List<StudentResource> listStudent = sd.getAllStudents();
		mv.addObject("lists", listStudent);
		mv.setViewName("studentList.jsp");

		return mv;

	}

}
