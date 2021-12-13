package com.iftm.ms.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.ms.hrworker.entities.Worker;
import com.iftm.ms.hrworker.services.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerService service;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {		
		/*
		int i = 1;
		if (i == 1)
			throw new RuntimeException("test");
			
		*/	
		
		try {
			Thread.sleep(4500L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
}
