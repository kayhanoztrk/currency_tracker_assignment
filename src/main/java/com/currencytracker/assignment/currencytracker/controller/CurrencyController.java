package com.currencytracker.assignment.currencytracker.controller;

import com.currencytracker.assignment.currencytracker.dto.CurrencyDto;
import com.currencytracker.assignment.currencytracker.entity.Currency;
import com.currencytracker.assignment.currencytracker.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/currencyTracker/currency")
public class CurrencyController {

    private final CurrencyService currencyService;
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<CurrencyDto>> findAll() {
        List<CurrencyDto> currencyList = currencyService.getCurrencyList();
        return ResponseEntity.ok(currencyList);
    }

    @PostMapping("/create")
    public ResponseEntity<CurrencyDto> create(@Valid @RequestBody Currency currency) {
        CurrencyDto currencyDto = currencyService.createCurrency(currency);
        return ResponseEntity.ok(currencyDto);
    }

    @PutMapping("/update")
    public ResponseEntity<CurrencyDto> update(@Valid @RequestBody Currency currency){
        CurrencyDto currencyDto = currencyService.updateCurrency(currency);
        return ResponseEntity.ok(currencyDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        currencyService.deleteCurrency(id);
        return new ResponseEntity<String>(id + " currency is deleted", HttpStatus.OK);
    }
}
