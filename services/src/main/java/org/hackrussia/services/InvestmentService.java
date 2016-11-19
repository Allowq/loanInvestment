package org.hackrussia.services;

import org.hackrussia.model.Investment;
import org.hackrussia.model.dto.InvestmentResp;
import org.hackrussia.repositories.ClientRepository;
import org.hackrussia.repositories.CrudRepository;
import org.hackrussia.repositories.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentService implements CrudRepository<Investment, String> {
    @Autowired
    private InvestmentRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Investment save(Investment entity) {
        return repository.save(entity);
    }

    @Override
    public Investment findOne(String primaryKey) {
        return repository.findOne(primaryKey);
    }

    public InvestmentResp find(String primaryKey) {
        Investment entry = repository.findOne(primaryKey);
        return new InvestmentResp(entry.getId(), entry.getInvestor().getId(), entry.getBorrower().getId(), entry.getRisk(), entry.isAcceptInvestor(), entry.isAcceptBorrower());
    }

    @Override
    public List<Investment> findAll() {
        return repository.findAll();
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public void delete(Investment entity) {
        repository.delete(entity);
    }

    @Override
    public boolean exists(String primaryKey) {
        return repository.exists(primaryKey);
    }

    public List<Investment> findByCriteria(Query query) {
        return repository.findByCriteria(query);
    }

    public boolean acceptInvestment(String investmentId, String clientId) {
        Investment investment = repository.findOne(investmentId);

        if (investment.getInvestor().getId().equals(clientId)) {
            investment.setAcceptInvestor(true);
            repository.save(investment);
            return checkContract(investment);
        } else if (investment.getBorrower().getId().equals(clientId)) {
            investment.setAcceptBorrower(true);
            repository.save(investment);
            return checkContract(investment);
        }
        return false;
    }

    private boolean checkContract(Investment investment) {
        return investment.isAcceptBorrower() && investment.isAcceptInvestor();
    }
}
