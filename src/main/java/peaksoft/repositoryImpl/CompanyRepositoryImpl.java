package peaksoft.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.repository.CompanyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyRepositoryImpl implements CompanyRepository{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Company> getAllCompany() {
        return manager.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public void addCompany(Company company) {
    manager.persist(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return manager.find(Company.class,id);
    }

    @Override
    public void updateCompany(Long id, Company company) {
        Company company1 = manager.find(Company.class, id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        manager.merge(company1);
    }

    @Override
    public void deleteCompany(Long id) {
    manager.remove(manager.find(Company.class,id));
    }

    @Override
    public void countOfStudents() {
        manager.createQuery("SELECT COUNT(Company.students.size) FROM Company",Company.class).getResultList();
    }
}
