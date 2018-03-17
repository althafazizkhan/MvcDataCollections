package com.students;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {

		int i = Integer.parseInt(request.getParameter("t1"));
		int j = Integer.parseInt(request.getParameter("t2"));
		String opr = request.getParameter("operation");
		int k = i + j;
		int l = i - j;

		ModelAndView mv = new ModelAndView();
		if (opr.equals("add")) {
			mv.setViewName("display.jsp");

			mv.addObject("Result", k);

			return mv;
		}
		if (opr.equals("sub")) {
			mv.setViewName("display.jsp");

			mv.addObject("Result", l);

			return mv;
		}
		else
		
		return mv;

	}
	


}
