package com.example.demo.service

import kotlinx.coroutines.*
import org.springframework.stereotype.Service

@Service
class ProcessService {
    val runMap = mapOf(
        "which" to listOf("java"),
        "java" to listOf("--version"),
        "echo" to listOf("Running Process 3")
    )

    suspend fun runService() = coroutineScope {
        runMap.map {
            launch(Dispatchers.Default) {
                createProcessRunner().runProcess(it.key, it.value)
            }
        }
    }

    fun createProcessRunner(): ProcessRunner {
        return ProcessRunner()
    }
}