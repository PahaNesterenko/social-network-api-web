package org.social_network_api.rest;

import org.social_network_api.domain.User;
import org.social_network_api.process.VkImplProcess;
import org.social_network_api.vkImpl.VkImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Component
@Path("/users")
public class UserResource
{

    @Autowired
    private VkImplProcess vkImplProcess;

    @Autowired
    private VkImpl vk;

    private final String resourceURI = "/users";

   /* @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<User> list(@DefaultValue("0") @QueryParam("offset") int offset, @DefaultValue("20") @QueryParam("limit") int limit)
    {
        // Handles GET on /users. Lists all the users we have in our system.
        return userService.paginate(offset, limit);
    }*/


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public User get(@PathParam("userId") Long userId)
    {
        //return userService.find(userId);
        return vk.getUser(userId);
    }


    /*@POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response create(User user, @Context final HttpServletResponse response) throws URISyntaxException
    {
        // Handles POST on /users. Creates a new user and adds it into an repository.
        userService.save(user);
        response.setStatus(Response.Status.CREATED.getStatusCode());
        return Response.created(new URI(resourceURI + user.getId())).build();
    }


    @PUT
    @Path("/{userId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public User update(User user, @PathParam("userId") Long userId)
    {
        // Handles PUT on /users/userId. Updates the existing user with the new values.
        return userService.update(user, userId);
    }


    @DELETE
    @Path("/{userId}")
    public User delete(@PathParam("userId") Long userId)
    {
        // Handles DELETE on /users/userId. Deletes the existing user and returns the same.
        return userService.delete(userId);
    }*/
}
