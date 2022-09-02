package peaksoft.service;

import peaksoft.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();
    void addCompany(Company company);
    Company getCompanyById(Long id);
    void updateCompany(Long id, Company company);
    void deleteCompany(Long company);
    void countOfStudents();
}
