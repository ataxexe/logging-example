package com.example.logging;

import io.backpackcloud.fakeomatic.spi.FakeData;
import org.jboss.logging.Logger;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/logs")
public class LoggingResource {

  private final static Logger LOGGER = Logger.getLogger(LoggingResource.class);

  private final FakeData fakeData = FakeData.load(LoggingResource.class.getResourceAsStream("/META-INF/resources/logging.yaml"), FakeData.defaultConfigLocation());

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response log(@NotNull LogMessage logMessage) {
    LOGGER.log(Logger.Level.valueOf(logMessage.level().toUpperCase()), logMessage.message());
    return Response.ok(logMessage).build();
  }

  @POST
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response log() {
    return log(new LogMessage(fakeData.random("level"), fakeData.random("cause")));
  }

}