package org.hackrussia.controller;

import org.hackrussia.dto.Response;
import org.hackrussia.dto.request.RequestData;
import org.hackrussia.model.Client;
import org.hackrussia.model.Investment;
import org.hackrussia.model.dto.InvestmentReq;
import org.hackrussia.services.ClientService;
import org.hackrussia.services.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/investments")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Response createInvestment(@RequestBody RequestData<InvestmentReq> req) {
        Client investor = clientService.findOne(req.getData().getInvestor());
        Client borrower = clientService.findOne(req.getData().getBorrower());
        Investment investment = new Investment(investor, borrower, req.getData().getRisk());
        investmentService.save(investment);
        return new Response(HttpStatus.OK);
    }
}
