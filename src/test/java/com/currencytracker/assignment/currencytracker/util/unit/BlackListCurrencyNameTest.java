package com.currencytracker.assignment.currencytracker.util.unit;

import com.currencytracker.assignment.currencytracker.util.BlackListCurrencyName;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link BlackListCurrencyName}
 *
 * @author Kayhan Öztürk
 * @version 0.0.1
 * @since   0.0.1
 */
public class BlackListCurrencyNameTest {

    @Test
    public void when_NotInBlackListName_ReturnFalse(){
        boolean isInBlackList = BlackListCurrencyName.isBlackListCurrency("btc");
        Assert.assertNotNull(isInBlackList);
    }

    @Test
    public void when_InBlackListName_ReturnFalse(){
        boolean isInBlackList = BlackListCurrencyName.isBlackListCurrency("ETH");
        Assert.assertNotNull(isInBlackList);
    }
}
