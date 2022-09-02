package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Company;
import peaksoft.repository.CompanyRepository;
import peaksoft.service.CompanyService;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.getAllCompany();
    }

    @Override
    public void addCompany(Company company) {
    companyRepository.addCompany(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.getCompanyById(id);
    }

    @Override
    public void updateCompany(Long id, Company company) {
    companyRepository.updateCompany(id,company);
    }

    @Override
    public void deleteCompany(Long id) {
    companyRepository.deleteCompany(id);
    }

    @Override
    public void countOfStudents() {
        companyRepository.countOfStudents();
    }
}