package org.hackrussia.controller;

import org.hackrussia.dto.Response;
import org.hackrussia.dto.response.ResponseSearch;
import org.hackrussia.model.Client;
import org.hackrussia.model.dto.PropositionDTO;
import org.hackrussia.services.AuthService;
import org.hackrussia.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class SearchController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/propositions", method = RequestMethod.GET)
    @ResponseBody
    public Response searchProposition(@RequestParam UUID uuid) {
        if (authService.isAuth(uuid)) {
            List<Client> byCriteria = clientService.findAll();
            Map<String, PropositionDTO> map = new HashMap<>();

            byCriteria.forEach(client -> client.getPropositions().stream()
                    .filter(proposition -> !proposition.isClosed())
                    .forEach(proposition ->
                            map.put(
                                    client.getId(),
                                    new PropositionDTO(proposition.getId(), proposition.getTitle(), proposition.getDisc(), proposition.getSum(), proposition.isClosed()))));

            return new ResponseSearch(uuid, map, HttpStatus.OK);
        } else {
            return new Response(null, HttpStatus.BAD_REQUEST);
        }
    }
}
