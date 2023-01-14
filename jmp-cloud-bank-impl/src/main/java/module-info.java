module jmp.cloud.bank.impl {
    requires transitive jmp.bank.api;
    requires jmp.dto;
    exports com.romanfill.modules.bank.impl;
    provides com.romanfill.modules.api.Bank with com.romanfill.modules.bank.impl.DefaultBank;
}