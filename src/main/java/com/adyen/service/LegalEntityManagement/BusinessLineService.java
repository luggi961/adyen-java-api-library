package com.adyen.service.LegalEntityManagement;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.legalEntityManagement.BusinessLine;
import com.adyen.model.legalEntityManagement.BusinessLineInfo;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.LegalEntityManagementResource;

import java.io.IOException;

public class BusinessLineService extends Service {
    public BusinessLineService(Client client) {
        super(client);
    }

    public BusinessLine create(BusinessLineInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, "/businessLines");
        String jsonResult = resource.request(jsonRequest);
        return BusinessLine.fromJson(jsonResult);
    }

    public BusinessLine retrieve(String businessLineId) throws IOException, ApiException {
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/businessLines/%s", businessLineId));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return BusinessLine.fromJson(jsonResult);
    }

    public BusinessLine update(String businessLineId, BusinessLineInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        LegalEntityManagementResource resource = new LegalEntityManagementResource(this, String.format("/businessLines/%s", businessLineId));
        String jsonResult = resource.request(jsonRequest, ApiConstants.HttpMethod.PATCH);
        return BusinessLine.fromJson(jsonResult);
    }
}
