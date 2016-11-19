package org.hackrussia.controller;

import org.hackrussia.dto.Response;
import org.hackrussia.dto.request.RequestComplete;
import org.hackrussia.dto.response.ResponseUUID;
import org.hackrussia.model.dto.PropositionReq;
import org.hackrussia.services.AuthService;
import org.hackrussia.services.PropositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients/")
public class PropositionController {

    @Autowired
    private PropositionService propositionService;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/propositions", method = RequestMethod.POST)
    @ResponseBody
    public Response putProposition(@RequestParam String clientId, @RequestBody RequestComplete<PropositionReq> req) {
        if (authService.isAuth(req.getUuid(), clientId)) {
            propositionService.addProposition(clientId, req.getData().getTitle(), req.getData().getDisc(), req.getData().getSum());
            return new ResponseUUID(HttpStatus.OK, req.getUuid());
        } else {
            return new Response(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/propositions/delete", method = RequestMethod.POST)
    @ResponseBody
    public Response removeProposition(@RequestParam String clientId, @RequestBody RequestComplete<String> req) {
        if (authService.isAuth(req.getUuid(), clientId)) {
            propositionService.removeProposition(clientId, req.getData());
            return new ResponseUUID(HttpStatus.OK, req.getUuid());
        } else {
            return new Response(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/propositions/close", method = RequestMethod.POST)
    @ResponseBody
    public Response closeProposition(@RequestParam String clientId, @RequestBody RequestComplete<String> req) {
        if (authService.isAuth(req.getUuid(), clientId)) {
            propositionService.closeProposition(req.getData());
            return new ResponseUUID(HttpStatus.OK, req.getUuid());
        } else {
            return new Response(HttpStatus.BAD_REQUEST);
        }
    }

}
