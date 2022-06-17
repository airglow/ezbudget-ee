package ir.ezbudget.controller;

import ir.ezbudget.dto.CustomerDto;
import ir.ezbudget.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/customers")
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index() {

        List<CustomerDto> customers = customerService.allCustomers();

        return Response.ok().entity(customers).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") Long id) {

        CustomerDto customer = customerService.findCustomerById(id);

        return Response.ok().entity(customer).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response store(CustomerDto customerDto) {

        Long customerId = customerService.createCustomer(customerDto);

        return Response.ok().entity(customerId).build();
    }

}
