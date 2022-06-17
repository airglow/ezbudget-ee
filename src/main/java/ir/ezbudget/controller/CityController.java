package ir.ezbudget.controller;

import ir.ezbudget.dto.CityDto;
import ir.ezbudget.service.CityService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cities")
public class CityController {

    @Inject
    private CityService cityService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index() {

        List<CityDto> cities = cityService.list().stream().map(CityDto::entityToDto).toList();

        return Response.ok().entity(cities).build();
    }

}
