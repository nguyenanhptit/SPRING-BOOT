package edu.hanoi.jazz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.javafx.collections.MappingChange.Map;

import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.dao.UserDAO;
import edu.hanoi.jazz.dao.model.Group;
import edu.hanoi.jazz.dao.model.User;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;

@Controller
@RequestMapping("/tai-khoan")
public class UserController {
	public static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	GroupDAO groupDAO;

	@Autowired
	UserDAO userDAO;

	@GetMapping("/them")
	public ModelAndView addForm(ModelMap model) {
		ModelAndView mv = new ModelAndView("user.form", "user", new User());
		mv.addObject("groups", toGroupMap(groupDAO.listGroup(null)));
		return mv;
	}

	private Object toGroupMap(List<Group> groups) {
		// TODO Auto-generated method stub
		java.util.Map<Integer, String> map = new HashMap<>();
		groups.forEach(group -> {
			map.put(group.getId(), group.getName());
		});
		return map;
	}

	@RequestMapping(value = "/luu", method = RequestMethod.POST)
	public ModelAndView addNew(@Valid @ModelAttribute("command") User user, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView("user.form", "command", new User());
			mv.addObject("groups", toGroupMap(groupDAO.list()));
			mv.addObject("errors", result);
			return mv;
		}
		logger.info("add new user ------>" + user);
		userDAO.insert(user);
		return new ModelAndView("redirect:/tai-khoan/them");
	}

	@RequestMapping(value = "/danh-sach", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(value = "group", required = false) Integer group) {
		ModelAndView mv = new ModelAndView("user.list");
		mv.addObject("users", userDAO.listUser(group));
		mv.addObject("average", userDAO.averageAge());
		return mv;
	}

	@RequestMapping(value = "/chi-tiet/{username}", method = RequestMethod.GET)
	public ModelAndView userDetail(@PathVariable(value = "username") String username) {
		ModelAndView mv = new ModelAndView("user.list");
		mv.addObject("users", userDAO.getUserByUsername(username));
		return mv;
	}

	@RequestMapping(value = "/xoa/{username}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "username") String username) {
		userDAO.deleteUser(username);
		return "redirect:/tai-khoan/danh-sach";
	}

	// Phan trang

	@GetMapping("danh-sach")
	public ModelAndView paging(@RequestParam(value = "group", required = false) Integer group) {
		ModelAndView mv = new ModelAndView("user.list");
		mv.addObject("users", userDAO.page(1));
		return mv;
	}

}