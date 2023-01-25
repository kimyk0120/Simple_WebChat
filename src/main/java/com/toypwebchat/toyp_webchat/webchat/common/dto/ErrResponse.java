package com.toypwebchat.toyp_webchat.webchat.common.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


//    Error Response EXAMPLE
//    {
//        "httpStatus": "401",
//            "errorCode": "2001",
//            "errorMessage": "Authorization failed",
//            "detailedMessage": "User doesn’t have permission to update user profile",
//            "moreInfo": "https://conlab.visitkorea.or.kr/apigw/docs/2001"
//    }

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrResponse extends BasicResponse{

    private int httpStatus;
    private String errorCode;
    private String errorMessage;
    private String detailedMessage;
    private String moreInfo;

    public ErrResponse(int httpStatus, String errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public ErrResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrResponse(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }


}
