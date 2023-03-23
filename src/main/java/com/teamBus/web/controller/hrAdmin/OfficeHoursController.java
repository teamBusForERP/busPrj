package com.teamBus.web.controller.hrAdmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamBus.web.entity.AdminListDayView;
import com.teamBus.web.entity.Company;
import com.teamBus.web.entity.Employee;
import com.teamBus.web.service.CommonService;
import com.teamBus.web.service.OfficeHoursService;

@Controller("hrAdminOfficeHoursController")
@RequestMapping("/hr-admin/office-hours")
public class OfficeHoursController {

    @Autowired
    private OfficeHoursService service;

    @Autowired
    private CommonService commonService;

//    public OfficeHoursController(OfficeHoursService service) {
//        this.service = service;
//    }

    @GetMapping("list")
    public String list(Model model) {

    	int employeeId = 1;
    	Employee e = commonService.getEmployeeByEmployeeId(employeeId);
    	model.addAttribute("loginInfo", e);
    	String companyName = commonService.getCompanyNameByCompanyId(e.getCompanyId());
    	model.addAttribute("companyName", companyName);
    	
//        List<Employee> list = service.getList();
//        model.addAttribute("list",list);
//        LoginInfo loginInfo = commonService.getLoginInfo(employeeId);
//        model.addAttribute("loginInfo", loginInfo);

        List<AdminListDayView> dayList = service.getDayList(e.getCompanyId());
        model.addAttribute("dayList",dayList);



        return "/hr-admin/office-hours/list";
    }

}
