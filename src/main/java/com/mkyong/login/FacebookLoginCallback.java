package com.mkyong.login;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/login/facebook")
public class FacebookLoginCallback {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getFacebookResponse(@QueryParam("code") String code) {





    return Response.ok().build();
  }


}
