package com.romanfill.modules.dto.impl;

import com.romanfill.modules.dto.BankCard;
import com.romanfill.modules.dto.User;

public class CreditBankCard extends BankCard {

    public CreditBankCard(String number, User user) {
        super(number, user);
    }
}
