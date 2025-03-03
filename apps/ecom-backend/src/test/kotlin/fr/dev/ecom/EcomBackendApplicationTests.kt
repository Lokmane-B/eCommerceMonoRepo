package fr.dev.ecom

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest
@Testcontainers(disabledWithoutDocker = true)
class EcomBackendApplicationTests {


  @Test
  fun `it should start the app normally`() {
  }


  companion object {

    private val container: MongoDBContainer = MongoDBContainer("mongo:latest").withExposedPorts(27017)

    @BeforeAll
    @JvmStatic
    fun startDBContainer() {
      container.start()
    }

    @AfterAll
    @JvmStatic
    fun stopDBContainer() {
      container.stop()
    }

    @JvmStatic
    @DynamicPropertySource
    fun registerDbContainer(registry: DynamicPropertyRegistry) {
      registry.add("spring.data.mongodb.host", container::getHost);
      registry.add("spring.data.mongodb.port", container::getFirstMappedPort);
    }
  }

}
