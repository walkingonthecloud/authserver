package com.pilogix.authserver.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "code", "userMessage", "systemMessage", "detailLink" })
public class ApiError {
    private String code;
    private String userMessage;
    private String systemMessage;
    private String detailLink;

    public ApiError() {}

    public ApiError(String userMessage) {
        this.userMessage = userMessage;
    }

    public ApiError(String code, String userMessage, String systemMessage) {
        this.code = code;
        this.userMessage = userMessage;
        this.systemMessage = systemMessage;
    }

    public ApiError(String code, String userMessage, String systemMessage, String detailLink) {
        this.code = code;
        this.userMessage = userMessage;
        this.systemMessage = systemMessage;
        this.detailLink = detailLink;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getSystemMessage() {
        return systemMessage;
    }

    public void setSystemMessage(String systemMessage) {
        this.systemMessage = systemMessage;
    }

    public String getDetailLink() {
        return detailLink;
    }

    public void setDetailLink(String detailLink) {
        this.detailLink = detailLink;
    }

}
