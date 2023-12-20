package org.kamar.mpi_ecom_web.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * app context configuration.
 * @author kamar baraka.*/

@Configuration
@EnableTransactionManagement
@EnableHypermediaSupport(type = {
        EnableHypermediaSupport.HypermediaType.HAL,
        EnableHypermediaSupport.HypermediaType.HAL_FORMS,
        EnableHypermediaSupport.HypermediaType.COLLECTION_JSON,
        EnableHypermediaSupport.HypermediaType.HTTP_PROBLEM_DETAILS,
        EnableHypermediaSupport.HypermediaType.UBER
})
@EnableScheduling
@EnableCaching
public class AppContConfig {
}
