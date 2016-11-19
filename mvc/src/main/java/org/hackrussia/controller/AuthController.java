package org.hackrussia.controller;

import org.hackrussia.dto.Response;
import org.hackrussia.dto.request.CredentialReq;
import org.hackrussia.dto.request.RegistryRequest;
import org.hackrussia.dto.request.data.RegistryData;
import org.hackrussia.dto.response.ResponseClient;
import org.hackrussia.model.Client;
import org.hackrussia.model.dto.ClientDTO;
import org.hackrussia.services.AuthService;
import org.hackrussia.services.ClientService;
import org.hackrussia.utils.HttpSessionEmulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private HttpSessionEmulator sessionEmulator;

    @RequestMapping(value = "/auth/", method = RequestMethod.POST)
    @ResponseBody
    public Response auth(@RequestBody CredentialReq credential) {
        Client client = authService.authProcessor(credential.getLogin(), credential.getPassword()).get(0);
        if (client != null) {
            UUID uuid = UUID.randomUUID();
            sessionEmulator.put(uuid, client.getId());
            return new ResponseClient(uuid, new ClientDTO(client.getId(), null, null, null, null), HttpStatus.OK);
        } else {
            return new Response(null, HttpStatus.BAD_GATEWAY);
        }
    }

    @RequestMapping(value = "/register/", method = RequestMethod.POST)
    @ResponseBody
    public Response register(@RequestBody RegistryRequest request) {
        RegistryData registryData = request.getData();
        Client client = new Client(
                registryData.getLogin(),
                registryData.getPassword(),
                registryData.getBGuid(),
                registryData.getDSignature());
        clientService.save(client);
        return new Response(null, HttpStatus.OK);
    }
}