package com.alex.login.rest.api;

import com.alex.login.dao.entities.AccountEntity;
import com.alex.login.dao.entities.UserEntity;
import com.alex.login.rest.data.UserRestInput;
import com.alex.login.rest.data.UserRestOutput;
import com.alex.login.service.api.LoginService;
import com.alex.login.service.exceptions.UserAuthenticationExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by alejandro on 8/20/16.
 */

@Service("loginRest")
@Path("/login")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class LoginRestImpl {

    @Autowired
    private LoginService loginService;

    @POST
    @Path("/authenticate")
    public Response authenticate(UserRestInput user) {

        UserRestOutput userRestOutput = null;

        UserEntity userEntity = new UserEntity();
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setEmail(user.getEmail());
        accountEntity.setSecret(user.getPassword());

        userEntity.setAccount(accountEntity);

        try {

            UserEntity userOutService = loginService.authenticate(userEntity);

            userRestOutput = new UserRestOutput();

            userRestOutput.setFirstName(userOutService.getFirstName());
            userRestOutput.setLastName(userOutService.getLastName());
            userRestOutput.setEmail(userOutService.getAccount().getEmail());
            userRestOutput.setRole(userOutService.getAccount().getRole());

        } catch (UserAuthenticationExeption userAuthenticationExeption) {
            userAuthenticationExeption.printStackTrace();
            return Response.status(401).build();

        }
        return Response.ok(userRestOutput).build();
    }


}
