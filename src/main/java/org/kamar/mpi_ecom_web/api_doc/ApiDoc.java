package org.kamar.mpi_ecom_web.api_doc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import org.springframework.web.bind.annotation.RestController;

/**
 * Api documentation properties.
 * @author kamar baraka.*/

@RestController
@OpenAPI31
@OpenAPIDefinition(
        tags = {},
        info = @Info(
                title = "MPI Resource Server Documentation",
                description = "This is the extensive documentation of the # MPI Resource server.",
                termsOfService = "",
                license = @License(
                        name = "MIT",
                        url = ""
                ),
                version = "v1.0.1",
                summary = "Documentation for the MPI ecommerce resource server Api.",
                contact = @Contact(
                        name = "kamar baraka",
                        email = "kamar254baraka@gmail.com"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:9080",
                        description = "MPI Resource Server."
                )
        },
        security = {}
)
public class ApiDoc {
}
