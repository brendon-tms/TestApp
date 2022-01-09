package com.application.testapp.TestApp;

import java.net.URI;
import java.util.List;

import com.application.testapp.entities.User;
import com.application.testapp.services.UserService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Response.Status;

@Path("/users")
public class UserResource {
	
	UserService userService = new UserService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() { // Returns a list
		List<User> list = userService.getUsers();
		return list;
	}
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User user, @Context UriInfo uri) {
        // create notification
        userService.create(user);
        
        URI location = uri.getAbsolutePathBuilder().path(Integer.toString(user.getUserId())).build();
        
        return Response.created(location).entity(user).build();
    }
	
	@POST
	@Path("/loginUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(String email, String password, @Context UriInfo uri) {
		
		User user =  userService.loginUser(email, password);
		
		URI location = uri.getAbsolutePathBuilder().path(Integer.toString(user.getUserId())).build();
		
		return Response.created(location).entity(user).build();
	}

}
