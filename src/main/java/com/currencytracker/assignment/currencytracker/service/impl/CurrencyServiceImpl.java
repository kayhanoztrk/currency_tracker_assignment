package com.currencytracker.assignment.currencytracker.service.impl;

import com.currencytracker.assignment.currencytracker.dto.CurrencyDto;
import com.currencytracker.assignment.currencytracker.entity.Currency;
import com.currencytracker.assignment.currencytracker.exception.CurrencyNotFoundException;
import com.currencytracker.assignment.currencytracker.exception.UnsupportedCurrencyCreationException;
import com.currencytracker.assignment.currencytracker.mapper.CurrencyDtoMapper;
import com.currencytracker.assignment.currencytracker.repository.CurrencyRepository;
import com.currencytracker.assignment.currencytracker.service.CurrencyService;
import com.currencytracker.assignment.currencytracker.util.BlackListCurrencyName;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyDtoMapper currencyDtoMapper;
    public CurrencyServiceImpl(CurrencyRepository currencyRepository,
                               CurrencyDtoMapper currencyDtoMapper){
        this.currencyRepository = currencyRepository;
        this.currencyDtoMapper = currencyDtoMapper;
    }

    @Override
    public CurrencyDto createCurrency(Currency currency) {
        String currencyName = currency.getName();
        if(BlackListCurrencyName.isBlackListCurrency(currencyName)){
           throw new UnsupportedCurrencyCreationException("unsupported currency name!");
        }
        currency.setCreatedTime(new Date());
        currencyRepository.save(currency);

        return currencyDtoMapper.convertToDto(currency);
    }

    @Override
    public CurrencyDto updateCurrency(Currency currency) {
        Currency currencyFromDb = currencyRepository.findById(currency.getId())
                .orElseThrow(() -> new CurrencyNotFoundException(currency.getId() +
                        " currencyId not found!"));

        currencyFromDb.setName(currency.getName());
        currencyFromDb.setSymbol(currency.getSymbol());
        currencyFromDb.setCurrentPrice(currency.getCurrentPrice());
        currencyFromDb.setEnabled(currency.isEnabled());
        currencyFromDb.setAlert(currency.getAlert());

        currencyRepository.save(currencyFromDb);
        return currencyDtoMapper.convertToDto(currencyFromDb);
    }

    @Override
    public void deleteCurrency(Long id) {
        Currency currencyFromDB = currencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("currencyId not found!"));
        currencyRepository.delete(currencyFromDB);
    }

    @Override
    public List<CurrencyDto> getCurrencyList() {
       List<CurrencyDto> currencyDtoList =  currencyRepository.findAllJustCurrenyList();
       return currencyDtoList;
    }

    @Override
    public Currency findById(Long id) {
        Currency currency =  currencyRepository.findById(id)
                .orElseThrow(() -> new CurrencyNotFoundException(id + " currency not found!"));

        return currency;
    }
}
