package org.hackrussia;

import org.hackrussia.repositories.ClientRepository;
import org.hackrussia.repositories.InvestmentRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new ClassPathResource("spring-config.xml").getPath());
        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        InvestmentRepository investmentRepository = context.getBean(InvestmentRepository.class);

//        Client clientA = new Client("A", "A");
//        clientRepository.save(clientA);
//        clientRepository.findOne(clientA.getId());
//
//        Client clientB = new Client("B", "B");
//        clientRepository.save(clientB);
//
//        Investment investment = new Investment(clientA, clientB, 0.10f);
//
//        investmentRepository.save(investment);
//        investmentRepository.findOne(investment.getId());
//
//        Investment i = investmentRepository.findOne(investment.getId());
//        System.out.println(i.toString());
    }
}
