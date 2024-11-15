package com.eltonmessias.Electricity_Billing.controller;

import com.eltonmessias.Electricity_Billing.dto.ReadingDTO;
import com.eltonmessias.Electricity_Billing.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @PostMapping("/readings")
    public ResponseEntity<Object> SaveConsumption(@RequestBody ReadingDTO consumptionDTO) {
        return new ResponseEntity<>(readingService.registerConsumption(consumptionDTO), HttpStatus.CREATED) ;
    }

    @GetMapping("/readings")
    public ResponseEntity<List<ReadingDTO>> getReadings() {
        return new ResponseEntity<>(readingService.getAllConsumptions(), HttpStatus.OK);
    }

    @GetMapping("/readings/{id}")
    public ResponseEntity<ReadingDTO> getReading(@PathVariable("id") long id) {
        return new ResponseEntity<>(readingService.getReadingById(id), HttpStatus.OK);
    }

    @PutMapping("/readings/{id}")
    public ResponseEntity<ReadingDTO> updateReading(@PathVariable("id") long id, @RequestBody ReadingDTO readingDTO) {
        return  new ResponseEntity<>(readingService.updateReading(readingDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("readings/{id}")
    public ResponseEntity<String> deleteReading(@PathVariable("id") long id) {
        readingService.deleteReading(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
