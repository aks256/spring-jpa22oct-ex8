package com.pluralsight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.model.YogaActivity;
import com.pluralsight.service.YogaService;

@Controller
public class YogaController {

	@Autowired
	private YogaService yogaService;

	@RequestMapping(value = "/addMinutes", method = RequestMethod.GET)
	public String getMinutes(@ModelAttribute("exercise") Exercise exercise) {

		return "addMinutes";
	}

	@RequestMapping(value = "/addMinutes", method = RequestMethod.POST)
	public String addMinutes(@Valid @ModelAttribute("exercise") Exercise exercise, BindingResult result) {

		System.out.println("exercise: " + exercise.getMinutes());
		System.out.println("exercise activity: " + exercise.getActivity());

		if (result.hasErrors()) {
			return "addMinutes";
		}

		return "addMinutes";
	}

	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<YogaActivity> findAllActivities() {
		return yogaService.findYogaActivities();
	}

}
