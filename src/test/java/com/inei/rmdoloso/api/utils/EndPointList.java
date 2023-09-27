package com.inei.rmdoloso.api.utils;

public class EndPointList {
    public static String getEndPoint(String endpoint) {
        switch (endpoint) {
            case "APK":
                return "APK";
            case "login":
                return "login";
            case "fsupmultitransferdata":
                return "fsupmultitransferdata";
            case "fstrackingmultiple":
                return "fstrackingmultiple";
            case "fstrackingdetmultiple":
                return "fstrackingdetmultiple";
            default:
                return endpoint;
        }
    }
}
