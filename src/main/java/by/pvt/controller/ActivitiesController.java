package by.pvt.controller;

import by.pvt.dto.activities.ActivitiesRequest;
import by.pvt.dto.activities.ActivitiesResponse;
import by.pvt.service.ActivitiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RequiredArgsConstructor
@RequestMapping("activities")
@Controller
public class ActivitiesController {
    private final ActivitiesService activitiesService;
    private ModelAndView currentModelAndView;

    @ModelAttribute
    void initAttributes(Model model) {
        model.addAttribute("addActivitiesReq", new ActivitiesRequest());
        model.addAttribute("updateActivitiesReq", new ActivitiesRequest());
        model.addAttribute("addActivitiesResp", new ActivitiesResponse());
        model.addAttribute("updateActivitiesResp", new ActivitiesResponse());
        model.addAttribute("activities", new ActivitiesResponse());
    }

    @PostMapping("addActivities")
    public ModelAndView addActivities(ActivitiesRequest activities, BindingResult result, Model model) {
        currentModelAndView = new ModelAndView("redirect:/activities");
        try {
            var activitiesResponse = activitiesService.add(activities);
            model.addAttribute("activities", activities);
            currentModelAndView.addObject("activities", activitiesResponse);
        } catch (Exception e) {
            currentModelAndView.addObject("error", e.getMessage());
        }
        return currentModelAndView;
    }

    @PostMapping("deleteActivities")
    public ModelAndView deleteActivities(Long id) {
        currentModelAndView = new ModelAndView("redirect:/activities");
        try {
            activitiesService.delete(id);
        } catch (Exception e) {
            currentModelAndView.addObject("error", e.getMessage());
        }
        return currentModelAndView;
    }

    @PostMapping("updateActivities")
    public ModelAndView updateActivities(ActivitiesRequest activities, Model model) {
        currentModelAndView = new ModelAndView("redirect:/activities");
        try {
            var activitiesResponse = activitiesService.add(activities);
            model.addAttribute("activities", activities);
            currentModelAndView.addObject("activities", activitiesResponse);
        } catch (Exception e) {
            currentModelAndView.addObject("error", e.getMessage());
        }
        return currentModelAndView;
    }

    @PostMapping("findByIdActivities")
    public ModelAndView findByIdActivities(Long id, Model model) {
        currentModelAndView = new ModelAndView("redirect:/activities");
        try {
            var activities = activitiesService.findById(id);
            model.addAttribute("activities", activities);
            currentModelAndView.addObject("activities", activities);
        } catch (Exception e) {
            currentModelAndView.addObject("error", e.getMessage());
        }
        return currentModelAndView;
    }

    @GetMapping
    public ModelAndView modelAndView() {
        //я так сделал т.к у меня раздувался url и я не мог добавить 2 активность
        ModelAndView modelAndView = currentModelAndView == null ? new ModelAndView() : currentModelAndView;
        modelAndView.addObject("listActivities", activitiesService.getAll());
        modelAndView.setViewName("activities/activities");
        return modelAndView;
    }
}
