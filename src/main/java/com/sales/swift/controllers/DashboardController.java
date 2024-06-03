package com.sales.swift.controllers;

import com.sales.swift.entities.ToDoList;
import com.sales.swift.service.DataService;
import com.sales.swift.service.TargetsService;
import com.sales.swift.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private DataService dataService;
    private ToDoListService toDoListService;
    private TargetsService targetsService;

    @Autowired
    public DashboardController(DataService theDataService, ToDoListService theToDoListService, TargetsService theTargetsService){
        dataService = theDataService;
        toDoListService = theToDoListService;
        targetsService = theTargetsService;
    }

    @GetMapping("/todolist")
    public String todolist(Model model){

        List<ToDoList> theToDoList = toDoListService.findAll();

        model.addAttribute("todolist", theToDoList);

        return "dashboard";
    }

    @GetMapping("/addtodo")
    public String addToDo(Model model){

        ToDoList theToDoList = new ToDoList();

        model.addAttribute("todolist", theToDoList);

        return "toDoList/add-toList";
    }

    @GetMapping("/updatetodolist")
    public String updateToDoList(@RequestParam("todolist")Long theId, Model model){

        ToDoList theToDoList = toDoListService.findById(theId);

        model.addAttribute("todolist", theToDoList);

        return "toDoList/add-toList";

    }

    @GetMapping("/deletetodo")
    public String deleteToDo(@RequestParam("todolist")Long theId){
        toDoListService.delete(theId);

        return "redirect:/dashboard";
    }

    @PostMapping("/savetodo")
    public String saveToDo(@ModelAttribute("todolist") ToDoList theToDoList){

        toDoListService.save(theToDoList);

        return "redirect:/dashboard";

    }


    @GetMapping("/")
    public String rootView(){
        return "dashboard";
    }



    @GetMapping("/dashboard")
    public String dashboard(Model theModel){

        long theCustomerCount = dataService.getCustomerCount();
        long theProspectCount = dataService.getProspectCount();
        long theLeadCount = dataService.getLeadCount();
        long theCurrentMonthShipments = dataService.getCurrentMonthShipments();
        double theCurrentMonthRevenue = dataService.getCurrentMonthRevenue();
        Integer theTargetShipments = targetsService.getTargetsCount();
        Double theTargetRevenue = targetsService.getTargetRevenue();
        Integer theNewCustomers = targetsService.getTargetCustomers();
        Integer targetCustomers = targetsService.getTargetCustomers();

        Integer theOvernightData = dataService.getOvernightData();
        Integer theDocumentData = dataService.getDocumentData();
        Integer theTenderData = dataService.getTenderData();
        Integer theEconomyData = dataService.getEconomyData();
        Integer theRoadData = dataService.getRoadfreightData();
        Integer theSameDayData = dataService.getSamedayData();

        Double theOvernightValue = dataService.getOvernightValue();
        Double theDocumentValue = dataService.getDocumentValue();
        Double theTenderValue = dataService.getTenderValue();
        Double theEconomyValue = dataService.getEconomyValue();
        Double theRoadValue = dataService.getRoadValue();
        Double theSameDayValue = dataService.getSamedayValue();


        //Calcs to track against targets
        Integer customerDifference = (int) (targetCustomers - theCustomerCount);
        Double revenueTarget = (double)(theTargetRevenue - theCurrentMonthRevenue);
        Integer targetShipmentsDifference = (int) (theTargetShipments - theCurrentMonthShipments);



        theModel.addAttribute("customerCount", theCustomerCount);
        theModel.addAttribute("prospectCount", theProspectCount);
        theModel.addAttribute("leadCount", theLeadCount);
        theModel.addAttribute("currentMonthShipments", theCurrentMonthShipments);
        theModel.addAttribute("currentMonthRevenue", theCurrentMonthRevenue);
        theModel.addAttribute("targetShipments", theTargetShipments);
        theModel.addAttribute("targetRevenue",theTargetRevenue);
        theModel.addAttribute("newCustomers",theNewCustomers);
        theModel.addAttribute("customerDifference",customerDifference);
        theModel.addAttribute("revenueTarget",revenueTarget);
        theModel.addAttribute("targetShipmentsDifference", targetShipmentsDifference);

        //Adding services to the model to display in the graph on the dashboard
        theModel.addAttribute("overnightData", theOvernightData);
        theModel.addAttribute("documentData", theDocumentData);
        theModel.addAttribute("tenderData", theTenderData);
        theModel.addAttribute("economyData", theEconomyData);
        theModel.addAttribute("roadData",theRoadData);
        theModel.addAttribute("sameDayData",theSameDayData);

        //Adding Values to the model to display in the chart on the Dashboard
        theModel.addAttribute("overnightValue", theOvernightValue);
        theModel.addAttribute("documentValue", theDocumentValue);
        theModel.addAttribute("tenderValue", theTenderValue);
        theModel.addAttribute("economyValue", theEconomyValue);
        theModel.addAttribute("roadValue", theRoadValue);
        theModel.addAttribute("sameDayValue", theSameDayValue);

        return "dashboard";
    }



}
