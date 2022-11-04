package com.smf.acg.sendmessagefast;

import com.google.gson.Gson;

public class CountCodes {


    private String code1;
    private String code2;
    private String code3;
    private String code4;
    private String code5;
    private String code6;
    private String code7;

    public CountCodes(String code1, String code2, String code3, String code4, String code5, String code6,String code7) {
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
        this.code4 = code4;
        this.code5 = code5;
        this.code6 = code6;
        this.code7 = code7;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public void setCode4(String code4) {
        this.code4 = code4;
    }

    public void setCode5(String code5) {
        this.code5 = code5;
    }

    public void setCode6(String code6) {
        this.code6 = code6;
    }

    public String getCode7() {
        return code7;
    }

    public void setCode7(String code7) {
        this.code7 = code7;
    }

    public String getCode1() {
        return code1;
    }

    public String getCode2() {
        return code2;
    }

    public String getCode3() {
        return code3;
    }

    public String getCode4() {
        return code4;
    }

    public String getCode5() {
        return code5;
    }

    public String getCode6() {
        return code6;
    }

    public String serialize() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
