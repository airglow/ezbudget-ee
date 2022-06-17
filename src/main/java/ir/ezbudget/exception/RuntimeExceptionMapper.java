package ir.ezbudget.exception;

import jakarta.json.bind.JsonbException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.ProcessingException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException exception) {

        if (exception instanceof ProcessingException ||
            exception instanceof JsonbException ||
            exception instanceof IllegalArgumentException) {

            return Response.status(Response.Status.BAD_REQUEST).build();

        } else if (exception instanceof EntityNotFoundException) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
