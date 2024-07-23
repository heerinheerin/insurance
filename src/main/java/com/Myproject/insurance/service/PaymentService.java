package com.Myproject.insurance.service;

import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.Myproject.insurance.dto.PaymentCallbackRequest;
import com.Myproject.insurance.dto.RequestPayDto;

public interface PaymentService {
    // 결제 요청 데이터 조회
    RequestPayDto findRequestDto(Long id);
    // 결제(콜백)
    IamportResponse<Payment> paymentByCallback(PaymentCallbackRequest request);

    com.Myproject.insurance.entity.Payment paymentSearch(String UId);


}
