package com.example.demo.service

import org.slf4j.LoggerFactory
import java.lang.RuntimeException
import java.time.LocalDateTime

class ProcessRunner {
    private val log = LoggerFactory.getLogger(ProcessRunner::class.java)

    fun runProcess(cmd: String, args: List<String>) {
        log.info("Starting process ${LocalDateTime.now()}")
        val exitCode = ProcessBuilder(cmd, args.joinToString(" "))
            .inheritIO()
            .start().waitFor()
        if (exitCode > 0) {
            throw RuntimeException("Process failed with code $exitCode")
        }

    }
}