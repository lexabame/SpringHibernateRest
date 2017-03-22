package com.alex.login.remoting.rest.api;

import com.alex.login.dao.entities.UserEntity;
import com.alex.login.utils.mapper.UserMapper;
import com.alex.login.remoting.rest.data.UserCanonical;
import com.alex.login.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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

    @Autowired
    private UserMapper userMapper;

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") final String id) {

        UserEntity userEntity = userService.getUser(Long.parseLong(id));
        UserCanonical userCanonical = userMapper.map(userEntity);
        return Response.ok(userCanonical).build();

    }

    @GET
    public Response getUsers() {

        List<UserEntity> userEntities = userService.getUsers();
        List<UserCanonical> userCanonicals = userMapper.mapList(userEntities);

        return Response.ok(userCanonicals).build();
    }

    @POST
    public Response addUser(final UserCanonical userCanonical) {

        UserEntity user = userMapper.map(userCanonical);

        UserEntity userAdded = userService.addUser(user);

        UserCanonical userToReturn = userMapper.map(userAdded);

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
