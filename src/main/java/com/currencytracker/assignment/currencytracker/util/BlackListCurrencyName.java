package com.currencytracker.assignment.currencytracker.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BlackListCurrencyName {

    private BlackListCurrencyName(){}
    private static List<String> blackListCurrencySymbol =
            Arrays.asList("ETH", "LTC", "ZKN", "MRD", "LPR", "GBZ");

    public static boolean isBlackListCurrency(String currencyName){
        List<String> blackListExist = blackListCurrencySymbol.stream()
                .filter(symbol -> symbol.equals(currencyName.toUpperCase()))
                .collect(Collectors.toList());

        if(blackListExist.size() > 0)
           return true;

        return false;
    }
}