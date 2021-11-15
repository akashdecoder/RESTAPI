package org.example.servlet;

import io.swagger.jaxrs.config.BeanConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class SwaggerConfigurationServlet extends HttpServlet {
    private static final long serialVersionUID=1L;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setBasePath("RESTAPI/");
        beanConfig.setHost("localhost:8091/");
        beanConfig.setTitle("Jersey API Swagger Docs");
        beanConfig.setResourcePackage("org.example");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);
        beanConfig.setSchemes(new String[] {"http"});
        beanConfig.setVersion("1.0");

    }
}
