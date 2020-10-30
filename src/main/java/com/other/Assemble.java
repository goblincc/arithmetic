package com.other;

import java.util.HashMap;
import java.util.Map;

public class Assemble {
    private static final String PLACEHOLDER_PREFIX= "${";
    private static final String PLACEHOLDER_SUFFIX = "}";
    private static final String[] PLACEHOLDER_CHARS = new String[]{"$", "{", "}"};

    public static void main(String[] args) {
        Map<String, String> attribute = new HashMap<>();
        attribute.put("anchornick", "zoo");
        attribute.put("nickname", "cc");
        Assemble assemble = new Assemble();
        String content = "hi ${nickname}, ${anchornick} is online";
        String make = assemble.make(content, attribute);
        System.out.println(make);
        System.out.println(String.format("hago://voiceRoom/quickJoin?game_id=%s&source=push","yangyangdazuozhan"));
    }

    public void initialPlaceholders(){

    }

    public String make(String text, Map<String, String> attribute){
        String output = text;
        int prefixIndx = output.indexOf(PLACEHOLDER_PREFIX);
        System.out.println(prefixIndx);
        int suffixIndx = output.indexOf(PLACEHOLDER_SUFFIX);
        System.out.println(suffixIndx);
        while(prefixIndx >= 0 && suffixIndx >= 0 && suffixIndx > prefixIndx){
            String key = output.substring(prefixIndx + PLACEHOLDER_PREFIX.length(), suffixIndx);
            String value = attribute.getOrDefault(key, "");
            if(value.isEmpty()){
                return null;
            }
            output =output.substring(0, prefixIndx) + value + output.substring(suffixIndx + PLACEHOLDER_SUFFIX.length());

            prefixIndx = output.indexOf(PLACEHOLDER_PREFIX);
            suffixIndx = output.indexOf(PLACEHOLDER_SUFFIX);
        }

        if (valid(output)) {
            return output;
        }
        return null;
    }

    public boolean valid(String text){
        for(String str: PLACEHOLDER_CHARS){
            if(text.contains(str)){
                return false;
            }
        }
        return true;
    }

}
