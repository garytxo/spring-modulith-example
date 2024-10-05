package com.example.orders.infrastructure.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = ["com.example.orders.infrastructure.persistence"],
  //  entityManagerFactoryRef = "techBlogEntityManagerFactory",
 //   transactionManagerRef = "techBlogTransactionManager"
)
class DataPersistenceConfig {
}