package peaksoft.repository;

import peaksoft.entity.Company;

import java.util.List;

public interface CompanyRepository {
    List<Company> getAllCompany();
    void addCompany(Company company);
    Company getCompanyById(Long id);
    void updateCompany(Long id, Company company);
    void deleteCompany(Long id);
    void countOfStudents();
}
