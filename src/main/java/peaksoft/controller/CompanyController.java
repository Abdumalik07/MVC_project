package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Company;
import peaksoft.service.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getAllCompanies")
    private String getAllCompanies(Model model) {
        model.addAttribute("allCompanies",companyService.getAllCompany());
        return "company/allCompanies";
    }
    @GetMapping("/new")
    private String newCompany(Model model) {
        model.addAttribute("newCompany",new Company());
        return "company/addCompany";
    }

    @PostMapping("/save")
    private String saveCompany(@ModelAttribute("newCompany") Company company) {
        companyService.addCompany(company);
        return "redirect:/companies/getAllCompanies";
    }


    @GetMapping("/getCompany/{id}")
    private String getCompanyById(@PathVariable("id") Long id,Model model) {
        model.addAttribute("company",companyService.getCompanyById(id));
        return "company/getAllCompanies";

    }

    @GetMapping("/update/{id}")
    private String updateCompany(@PathVariable("id")Long id, Model model) {
        model.addAttribute("company",companyService.getCompanyById(id));
        return "company/updateCompany";
    }


    @PostMapping("{id}/updateCompany")
    private String saveUpdateCompany(@PathVariable("id") Long id,@ModelAttribute("company") Company company) {
        companyService.updateCompany(id,company);
        return "redirect:/companies/getAllCompanies";
    }


    @PostMapping("/delete/{id}")
    public String deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteCompany(id);
        return "redirect:/companies/getAllCompanies";
    }


}
