package com.tapture.resumablefileupload

import com.tapture.resumablefileupload.service.UploadFileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ResumableFileUploadApplication: CommandLineRunner {
    @Autowired
    lateinit var uploadFileService: UploadFileService

    override fun run(vararg args: String?) {
        uploadFileService.init()
            .onFailure { throw RuntimeException("System cannot start up because no uploads folder is set up") }
    }
}

fun main(args: Array<String>) {
    runApplication<ResumableFileUploadApplication>(*args)
}
