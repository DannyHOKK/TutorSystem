package com.TutorCentres.TutorSystem.core.dto;

public class TwilioOtpDTO {
    private String phone;
    private String otpCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }
}
