package com.gestorhoteles.core;

import com.gestorhoteles.core.workerqueues.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkerGestorHotelesApplication implements CommandLineRunner {

    @Autowired
    private Worker worker;

    public static void main(String[] args) {
        SpringApplication.run(WorkerGestorHotelesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Iniciando worker Worker Gestor Hoteles");
        worker.processWork();
    }
}
