package com.libertytree.commerce;

import com.libertytree.commerce.EcommerceChassisApp;
import com.libertytree.commerce.config.AsyncSyncConfiguration;
import com.libertytree.commerce.config.EmbeddedElasticsearch;
import com.libertytree.commerce.config.EmbeddedKafka;
import com.libertytree.commerce.config.EmbeddedMongo;
import com.libertytree.commerce.config.EmbeddedRedis;
import com.libertytree.commerce.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { EcommerceChassisApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedRedis
@EmbeddedMongo
@EmbeddedElasticsearch
@EmbeddedKafka
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public @interface IntegrationTest {
}
