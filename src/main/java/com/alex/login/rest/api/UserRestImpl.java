package com.alex.login.rest.api;

import com.alex.login.dao.entities.AccountEntity;
import com.alex.login.dao.entities.UserEntity;
import com.alex.login.rest.data.AccountCanonical;
import com.alex.login.rest.data.UserCanonical;
import com.alex.login.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by alejandro on 3/19/17.
 */
@Service("userRest")
@Path("/users")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class UserRestImpl {

    @Autowired
    private UserService userService;

   /* @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") final String id) {
        return Response.ok().build();
    }

    @GET
    public Response getUsers() {
        return Response.ok().build();
    }*/

    @POST
    public Response addUser(final UserCanonical userCanonical) {

        UserEntity user = new UserEntity();

        user.setFirstName(userCanonical.getFirstName());
        user.setLastName(userCanonical.getLastName());

        AccountEntity account = new AccountEntity();

        account.setEmail(userCanonical.getAccount().getEmail());
        account.setSecret(userCanonical.getAccount().getSecret());
        account.setRole(userCanonical.getAccount().getRole());
        account.setStatus(userCanonical.getAccount().getStatus());

        user.setAccount(account);

        UserEntity userAdded = userService.addUser(user);

        UserCanonical userToReturn = new UserCanonical();

        userToReturn.setId(userAdded.getId());
        userToReturn.setFirstName(userAdded.getFirstName());
        userToReturn.setLastName(userAdded.getLastName());


        AccountCanonical accountToReturn = new AccountCanonical();

        accountToReturn.setId(userAdded.getAccount().getId());
        accountToReturn.setEmail(userAdded.getAccount().getEmail());
        accountToReturn.setRole(userAdded.getAccount().getRole());
        accountToReturn.setStatus(userAdded.getAccount().getStatus());

        userToReturn.setAccount(accountToReturn);

        return Response.ok(userToReturn).build();
    }

    /*@POST
    public Response updateUser(final UserCanonical userCanonical) {
        return Response.ok().build();
    }

    @POST
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") final String id) {
        return Response.ok().build();
    }*/


}
