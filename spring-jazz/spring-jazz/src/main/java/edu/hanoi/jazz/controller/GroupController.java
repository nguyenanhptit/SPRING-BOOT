package edu.hanoi.jazz.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.dao.model.Group;

@Controller
@RequestMapping(value = "/nhom")
public class GroupController {
	@Autowired
	private final static Logger LOGGER = Logger.getLogger(GroupController.class);
	@Autowired
	private GroupDAO groupDAO;

	@RequestMapping(value = "/them", method = RequestMethod.GET)
	public ModelAndView addForm() {
		return new ModelAndView("group.form", "command", new Group());
	}

	@RequestMapping(value = "/luu", method = RequestMethod.POST)

	public ModelAndView addNew(@Valid @ModelAttribute("command") Group group, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("group.form", "command", group);
			model.addObject("errors", result);
			return model;
		}
		LOGGER.info("add new group ------->" + group);
		if (group.getId() > 0) {
			groupDAO.insert(group);
		} else {
			groupDAO.update(group);
		}

		return new ModelAndView("redirect:/nhom/danh-sach");
		// return new ModelAndView("group.form");

	}

	@RequestMapping(value = "/danh-sach", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("group.list");
		mv.addObject("groups", groupDAO.list());
		return mv;
	}

	@RequestMapping(value = "/xoa/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable Integer id) {
		if (id == null)
			return new ModelAndView("redirect:/nhom/danh-sach");
		groupDAO.delete(id);
		return new ModelAndView("redirect:/nhom/danh-sach");
	}

	@RequestMapping(value = "/sua", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam(value = "id", required = true) Integer id) {
		Group group = groupDAO.getGroupById(id);
		if (group == null)
			return new ModelAndView("redirect:/nhom/danh-sach");
		return new ModelAndView("group.form", "command", group);
	}

	@RequestMapping(value = "/danh-sach/tim-kiem", method = RequestMethod.GET)
	public ModelAndView searchGroup(@RequestParam(value = "q", required = false) String pattern) {
		ModelAndView model = new ModelAndView("group.list");
		model.addObject("groups", groupDAO.listGroup(pattern));
		return model;
	}
}
