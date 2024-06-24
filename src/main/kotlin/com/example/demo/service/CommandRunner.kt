package com.example.demo.service

import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@Component
class CommandLineFirstComponent(private val processService: ProcessService) : CommandLineRunner {

    private val log = LoggerFactory.getLogger(CommandLineFirstComponent::class.java)

    override fun run(vararg args: String?) {
        log.info("Running process service")
        runBlocking {
            processService.runService()
        }
        log.info("Run Completed!")
    }
}