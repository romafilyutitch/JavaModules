module jmp.cloud.service.impl {
    requires transitive jmp.service.api;
    requires jmp.dto;
    exports com.romanfill.modules.cloud.service.impl;
    provides com.romanfill.modules.service.api.Service with com.romanfill.modules.cloud.service.impl.DefaultService;
}