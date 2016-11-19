package org.hackrussia.controller;

import org.hackrussia.dto.Response;
import org.hackrussia.dto.request.RequestComplete;
import org.hackrussia.dto.response.ResponseData;
import org.hackrussia.model.Client;
import org.hackrussia.model.Proposition;
import org.hackrussia.model.dto.PropositionResp;
import org.hackrussia.services.AuthService;
import org.hackrussia.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/propositions/search", method = RequestMethod.POST)
    @ResponseBody
    public Response searchProposition(@RequestBody RequestComplete<String> req) {
        if (authService.isAuth(req.getUuid(), req.getData())) {
            List<Client> byCriteria = clientService.findAll();
            List<Pair<String, PropositionResp>> pairs = new ArrayList<>();

            for (Client client : byCriteria) {
                for (Proposition p : client.getPropositions()) {
                    if (!p.isClosed()) {
                        pairs.add(Pair.of(client.getId(), new PropositionResp(p.getId(), p.getTitle(), p.getDisc(), p.getSum(), p.isClosed())));
                    }
                }
            }

            return new ResponseData(HttpStatus.OK, req.getUuid(), pairs);
        } else {
            return new Response(HttpStatus.BAD_REQUEST);
        }
    }
}
