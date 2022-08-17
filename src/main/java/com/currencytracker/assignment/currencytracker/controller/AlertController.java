package com.currencytracker.assignment.currencytracker.controller;

import com.currencytracker.assignment.currencytracker.dto.AlertDto;
import com.currencytracker.assignment.currencytracker.entity.Alert;
import com.currencytracker.assignment.currencytracker.service.AlertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/currencyTracker/alert")
public class AlertController {

    private final AlertService alertService;
    public AlertController(AlertService alertService){
        this.alertService = alertService;
    }


    @GetMapping("/list")
    public ResponseEntity<List<AlertDto>> findAll(){
        List<AlertDto> alertList = alertService.findAll();
        return ResponseEntity.ok(alertList);
    }

    @PostMapping("/create/{currencyId}")
    public ResponseEntity<AlertDto> create(@PathVariable("currencyId") Long currencyId,
                                        @RequestBody Alert alert){
        AlertDto createdAlert = alertService.createAlert(currencyId, alert);
        return ResponseEntity.ok(createdAlert);
    }

    @PutMapping("/update")
    public ResponseEntity<AlertDto> update(@RequestBody Alert alert){
        AlertDto updatedAlert = alertService.editAlert(alert);
        return ResponseEntity.ok(updatedAlert);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        alertService.deleteAlert(id);
        return new ResponseEntity<String>(id + " alert is deleted", HttpStatus.ACCEPTED);
    }

    //close alert.
    @PutMapping("/close/{alertId}")
    public ResponseEntity<String> close(@PathVariable("alertId") Long alertId){
        alertService.updateAlertStatusAcked(alertId);
        return ResponseEntity.ok(alertId + " alert status acked!");
    }

    //cancel alert
    @PutMapping("/cancel/{alertId}")
    public ResponseEntity<String> cancel(@PathVariable("alertId") Long alertId){
        alertService.updateAlertStatusCanceled(alertId);
        return ResponseEntity.ok(alertId + " alert status canceled!");
    }
}
