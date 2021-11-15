package org.example;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.example.dao.Employee;
import org.example.dao.EmployeeDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/jersey")
@Api("/REST API")
@SwaggerDefinition(tags = {@Tag(name = "REST API", description = "REST Endpoint for RESTAPI")})
public class MyResource {

    @GET
    @Path("/employess")
    @Produces("application/json")
    public List<Employee> getEmployee() {
        EmployeeDAO dao = new EmployeeDAO();
        List employees = dao.getEmployees();
        return employees;
    }


    @POST
    @Path("/create")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addEmployee(Employee emp){
        emp.setName(emp.getName());
        emp.setAge(emp.getAge());

        EmployeeDAO dao = new EmployeeDAO();
        dao.addEmployee(emp);

        return Response.ok().build();
    }

    @PUT
    @Path("/update/{id}")
    @Consumes("application/json")
    public Response updateEmployee(@PathParam("id") int id, Employee emp){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.updateEmployee(id, emp);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    public Response deleteEmployee(@PathParam("id") int id){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.deleteEmployee(id);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}
