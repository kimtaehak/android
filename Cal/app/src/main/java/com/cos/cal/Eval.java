package com.cos.cal;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Eval{

    public static String generate(String value){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            Object result = engine.eval(value);
            return result.toString();
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }
}
