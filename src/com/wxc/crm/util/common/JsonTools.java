package com.wxc.crm.util.common;

import com.alibaba.fastjson.JSON;

public class JsonTools {
    public static String createJsonString(Object object){
        String jsonString="";
        try {
            jsonString = JSON.toJSONString(object);
        }catch (Exception e){

        }
        return jsonString;
    }
}
