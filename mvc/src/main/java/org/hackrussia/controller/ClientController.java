package org.hackrussia.controller;

import org.hackrussia.dto.Response;
import org.hackrussia.dto.response.ResponseClient;
import org.hackrussia.services.AuthService;
import org.hackrussia.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/clients/")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
    @ResponseBody
    public Response getClientInfo(@PathVariable String clientId, @RequestParam UUID uuid) {
        if (authService.isAuth(uuid, clientId)) {
            return new ResponseClient(uuid,
                    clientService.find(clientId),
                    HttpStatus.OK);

        } else {
            return new Response(null, HttpStatus.BAD_REQUEST);
        }
    }

}