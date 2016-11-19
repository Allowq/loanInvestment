package org.hackrussia.controller;

import org.hackrussia.dto.Response;
import org.hackrussia.dto.request.RequestComplete;
import org.hackrussia.dto.response.ResponseData;
import org.hackrussia.services.AuthService;
import org.hackrussia.services.ClientService;
import org.hackrussia.services.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private AuthService authService;

    @Autowired
    private InvestmentService investmentService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Response getClientInfo(@RequestBody RequestComplete<String> request) {
        if (authService.isAuth(request.getUuid(), request.getData())) {
            return new ResponseData(
                    HttpStatus.OK,
                    request.getUuid(),
                    clientService.find(request.getData())
            );
        } else {
            return new Response(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/investment", method = RequestMethod.POST)
    @ResponseBody
    public Response getClientInfo(@RequestBody RequestComplete<String> request, @RequestParam String clientId) {
        if (authService.isAuth(request.getUuid(), clientId)) {
            investmentService.acceptInvestment(request.getData(), clientId);
            return new ResponseData(HttpStatus.OK, request.getUuid(), investmentService.find(request.getData()));
        } else {
            return new Response(HttpStatus.BAD_REQUEST);
        }
    }

}