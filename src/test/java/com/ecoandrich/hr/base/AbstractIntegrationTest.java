package com.ecoandrich.hr.base;

import com.ecoandrich.hr.HrApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(
        classes = HrApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class AbstractIntegrationTest {

    @Autowired
    public ObjectMapper objectMapper;

    public <T> String toJson(T data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(data);
    }

    private static final String ENV_TZ = "TZ";
    private static final String ASIA_SEOUL = "Asia/Seoul";

    private static final String MARIA_DB_IMAGE_NAME = "mariadb:latest";
    @Container
    public static final MariaDBContainer<?> MARIA_DB_CONTAINER =
            new MariaDBContainer<>(DockerImageName.parse(MARIA_DB_IMAGE_NAME))
                    .withEnv(ENV_TZ, ASIA_SEOUL)
                    .withDatabaseName("hr")
                    .withUsername("test")
                    .withPassword("test")
                    .withCommand(
                            "--character-set-server=utf8mb4",
                            "--collation-server=utf8mb4_unicode_ci",
                            "--skip-character-set-client-handshake",
                            "--default-time-zone=+09:00"
                    );

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        MARIA_DB_CONTAINER.start();
        registry.add("spring.datasource.url",
                () -> String.format("jdbc:mariadb://localhost:%d/%s", MARIA_DB_CONTAINER.getFirstMappedPort(), MARIA_DB_CONTAINER.getDatabaseName()));
        registry.add("spring.datasource.username", MARIA_DB_CONTAINER::getUsername);
        registry.add("spring.datasource.password", MARIA_DB_CONTAINER::getPassword);
    }


}
