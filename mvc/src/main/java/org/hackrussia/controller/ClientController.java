package org.hackrussia.controller;

import org.hackrussia.dto.CredentialReq;
import org.hackrussia.dto.RegistryData;
import org.hackrussia.dto.RegistryRequest;
import org.hackrussia.dto.Response;
import org.hackrussia.model.Client;
import org.hackrussia.repositories.ClientRepository;
import org.hackrussia.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ClientController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ClientRepository repository;

    @RequestMapping(value = "/auth/", method = RequestMethod.POST)
    @ResponseBody
    public Response auth(@RequestBody CredentialReq credential) {
        if (authService.authProcessor(credential.getLogin(), credential.getPassword())) {
            UUID uuid = UUID.randomUUID();
            return new Response(uuid, null, HttpStatus.OK);
        } else {
            return new Response(null, null, HttpStatus.BAD_GATEWAY);
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
        repository.save(client);
        return new Response(null, null, HttpStatus.OK);
    }
}