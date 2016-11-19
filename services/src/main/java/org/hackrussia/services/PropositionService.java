package org.hackrussia.services;

import org.hackrussia.model.Client;
import org.hackrussia.model.Proposition;
import org.hackrussia.repositories.ClientRepository;
import org.hackrussia.repositories.PropositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PropositionService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PropositionRepository propositionRepository;

    public void addProposition(String clientId, String title, String disc, double sum) {
        Proposition proposition = new Proposition(title, disc, sum);
        propositionRepository.save(proposition);
        Client client = clientRepository.findOne(clientId);
        if (client.getPropositions() != null) {
            client.getPropositions().add(proposition);
        } else {
            client.setPropositions(Collections.singletonList(proposition));
        }
        clientRepository.save(client);
    }

    public void removeProposition(String clientId, String propositionId) {
        Client client = clientRepository.findOne(clientId);
        Proposition proposition = client.getPropositions().stream()
                .filter(p -> p.getId().equals(propositionId))
                .findFirst()
                .orElse(null);
        if (proposition != null) {
            client.getPropositions().remove(proposition);
            clientRepository.save(client);
            propositionRepository.delete(proposition);
        }
    }

    public void closeProposition(String propositionId) {
        Proposition proposition = propositionRepository.findOne(propositionId);
        proposition.setClosed(true);
        propositionRepository.save(proposition);
    }

    public List<Proposition> findAll() {
        return propositionRepository.findAll();
    }
}
