package ir.ezbudget.controller;

import ir.ezbudget.dto.CustomerDto;
import ir.ezbudget.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
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

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response destroy(@PathParam("id") Long id) {

        customerService.deleteCustomer(id);

        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, CustomerDto customerDto) {

        customerService.updateCustomer(id, customerDto);

        return Response.ok().build();
    }

}
