package com.project.survey.controller;

import com.project.survey.repo.ResponseRepo;
import com.project.survey.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@CrossOrigin("*")
@Controller
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    ExcelService excelService;

    @Autowired
    ResponseRepo responseRepo;

    @GetMapping("/download/{response_id}")
    public ResponseEntity<Resource> getFile(@PathVariable Integer[] response_id) {


        InputStreamResource file = new InputStreamResource(excelService.load(response_id));


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment");


        return ResponseEntity
               .ok()
               .header(String.valueOf(headers))
               .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
               .body(file);
    }

}

