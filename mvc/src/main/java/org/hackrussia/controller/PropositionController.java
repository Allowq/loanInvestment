package org.hackrussia.controller;

import org.hackrussia.dto.Response;
import org.hackrussia.dto.request.PropositionReq;
import org.hackrussia.dto.request.RequestPropClose;
import org.hackrussia.services.AuthService;
import org.hackrussia.services.PropositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/clients/{clientId}/")
public class PropositionController {

    @Autowired
    private PropositionService propositionService;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/propositions", method = RequestMethod.PUT)
    @ResponseBody
    public Response putProposition(@PathVariable String clientId, @RequestBody PropositionReq req) {
        if (authService.isAuth(req.getUuid(), clientId)) {
            propositionService.addProposition(clientId, req.getData().getTitle(), req.getData().getDisc(), req.getData().getSum());
            return new Response(req.getUuid(), HttpStatus.OK);
        } else {
            return new Response(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/propositions/{propositionId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Response removeProposition(@PathVariable String clientId, @RequestParam UUID uuid, @PathVariable String propositionId) {
        if (authService.isAuth(uuid, clientId)) {
            propositionService.removeProposition(clientId, propositionId);
            return new Response(uuid, HttpStatus.OK);
        } else {
            return new Response(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/propositions/{propositionId}", method = RequestMethod.POST)
    @ResponseBody
    public Response removeProposition(@PathVariable String clientId, @PathVariable String propositionId, @RequestBody RequestPropClose req) {
        if (authService.isAuth(req.getUuid(), clientId)) {
            propositionService.closeProposition(propositionId);
            return new Response(req.getUuid(), HttpStatus.OK);
        } else {
            return new Response(null, HttpStatus.BAD_REQUEST);
        }
    }

}
