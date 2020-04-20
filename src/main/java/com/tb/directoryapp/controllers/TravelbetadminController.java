package com.tb.directoryapp.controllers;


import com.tb.directoryapp.requirements.RegistrationForm;
import com.tb.directoryapp.converters.TravelbetadminToRegistrationForm;
import com.tb.directoryapp.model.Travelbetadmin;
import com.tb.directoryapp.model.Sbjs;
import com.tb.directoryapp.services.TravelbetadminService;
import com.tb.directoryapp.services.InteractionsService;
import com.tb.directoryapp.services.SbjsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
public class TravelbetadminController {

    @Autowired
    private TravelbetadminService travelbetadminService;
    @Autowired
    private InteractionsService interactionsService;
    @Autowired
    private SbjsService sbjsService;
    @Autowired
    private TravelbetadminToRegistrationForm travelbetadminToRegistrationForm;


    @RequestMapping("/adminstrator/user")
    public String newContact(Model model){
        model.addAttribute("registrationForm", new RegistrationForm());
        return "RegisterAsAdmin";
    }

    @PostMapping(value = "/adminstrator")
    public String saveOrUpdateContact(@Valid RegistrationForm registrationForm, BindingResult result){

        if (result.hasErrors()) {
            return "RegisterAsAdmin";
        }

        travelbetadminService.saveOrUpdateRegistrationForm(registrationForm);

        return "redirect:/adminstrator";
    }

    @GetMapping(value = "/interactions")
    public String saveOrUpdateInteractions(@Valid RegistrationForm registrationForm, BindingResult result){

        if(result.hasErrors()) {
            return "RegisterAsAdmin";
        }

        interactionsService.saveOrUpdateContactForm(registrationForm);
        return "redirect:/adminstrator/user";
    }

    @RequestMapping("/adminstrator/view/{id}")
    public String getContact(@PathVariable String id, Model model){
        model.addAttribute("travelbetadmin", travelbetadminService.getById(Long.valueOf(id)));
        return "ViewUserPortal";
    }

    @RequestMapping({"/adminstrator/users", "/adminstrator"})
    public String listContacts(Model model) {
        model.addAttribute("travelbetadmin", travelbetadminService.listAll());
        return "CheckList";
    }

    @RequestMapping("/adminstrator/update/{id}")
    public String updateUserAccount(@PathVariable String id, Model model){
        Travelbetadmin travelbetadmin = travelbetadminService.getById(Long.valueOf(id));
        RegistrationForm registrationForm = travelbetadminToRegistrationForm.convert(travelbetadmin);
        model.addAttribute("registrationForm", registrationForm);
        return "UpdateUserAccount";
    }

    @RequestMapping("/adminstrator/delete/{id}")
    public String delete(@PathVariable String id){
        travelbetadminService.delete(Long.valueOf(id));
        return "redirect:/adminstrator/users";
    }

    @PostMapping(value = "/adminstrator.htm")
    public @ResponseBody
    Sbjs processAJAXRequest(
            @RequestParam("type") String type,
            @RequestParam("source") String source,
            @RequestParam("medium") String medium,
            @RequestParam("cmp") String cmp,
            @RequestParam("cnt") String cnt,
            @RequestParam("trm") String trm ) {

        System.out.println("\n" + "************ WEB AGENT INTERPRETER: ************" + "\n" + "\n" +
                "TYPE: referral === WEB AGENT: Opera" + "\n" +
                "TYPE: typein === WEB AGENT: Chrome, Firefox, Safari" + "\n" + "\n" +
                "************ WEB AGENT INFORMATION: ************" + "\n");

        System.out.println("TYPE: " + type);
        System.out.println("SOURCE: " + source);
        System.out.println("MEDIUM: " + medium);
        System.out.println("CAMPAIGN: " + cmp);
        System.out.println("CONTENT: " + cnt);
        System.out.println("TERM: " + trm);

        Sbjs sbjsPojo = new Sbjs();

        sbjsPojo.setType(type);
        sbjsPojo.setSource(source);
        sbjsPojo.setMedium(medium);
        sbjsPojo.setCampaign(cmp);
        sbjsPojo.setContent(cnt);
        sbjsPojo.setTerm(trm);

        System.out.println("*** Sourcebuster Parameters: HAS BEEN SENT TO DB ***");

        return sbjsService.saveOrUpdate(sbjsPojo);

    }
}
