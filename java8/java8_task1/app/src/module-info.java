module app {
    requires jmp.cloud.bank.impl;
    requires jmp.cloud.service.impl;
    requires jmp.dto;
    uses com.romanfill.modules.api.Bank;
    uses com.romanfill.modules.service.api.Service;
}