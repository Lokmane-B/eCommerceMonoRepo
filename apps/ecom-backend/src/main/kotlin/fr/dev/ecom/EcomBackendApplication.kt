package fr.dev.ecom

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EcomBackendApplication

fun main(args: Array<String>) {
	runApplication<EcomBackendApplication>(*args)
}
