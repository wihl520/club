package com.gzqf.webui.controller;

import com.gzqf.club.entity.Member;
import com.gzqf.webui.service.CoachTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CoachTeamController {
    @Autowired
    private CoachTeamService coachTeamService;

    @RequestMapping(value = "/team")
    public String showTeam(Model model){
        List<Member> list = coachTeamService.findList();
        model.addAttribute("coachList",list);
        return "team";
    }

    @RequestMapping(value = "/findcoachInfo")
    public String findCoachById(String id, Model model){
        Member member = coachTeamService.findCoachById(id);
        List<Member> list = coachTeamService.findStuList(id);
        model.addAttribute("Coach",member);
        model.addAttribute("Stu",list);
        return "/coachInfo";
    }


}
