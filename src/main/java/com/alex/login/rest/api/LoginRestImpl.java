package com.alex.login.rest.api;

import com.alex.login.dao.model.UserEntity;
import com.alex.login.rest.data.User;
import com.alex.login.services.api.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by alejandro on 8/20/16.
 */

@Service("loginRest")
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginRestImpl {

    @Autowired
    private LoginService loginService;

    @POST
    @Path("/authenticate")
    public Response authenticate(User user) {

        UserEntity userInputService = new UserEntity();

        userInputService.setUsername(user.getUsername());
        userInputService.setPassword(user.getPassword());

        UserEntity userOutputService = loginService.authenticate(userInputService);

        User userOutputRest = new User(userOutputService.getUsername(), userOutputService.getPassword(), userOutputService.getFirstName(), userOutputService.getLastName(), userOutputService.getRole());

        return Response.ok(userOutputRest).build();

    }


}
