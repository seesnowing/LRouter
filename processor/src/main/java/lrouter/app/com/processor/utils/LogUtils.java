/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package lrouter.app.com.processor.utils;

import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;

public class LogUtils {

    private static Messager messager;
    private static boolean CLOSE=false;
    public static void init(Messager m){
        messager=m;
    }

    public static void LOGI(String i){
        if(CLOSE){
            return;
        }
        if(messager==null){
            throw new IllegalStateException("Messager mustn't be null !");
        }
        messager.printMessage(Diagnostic.Kind.NOTE,i);
    }

    public static void LOGERROR(String i){
        if(CLOSE){
            return;
        }

        if(messager==null){
            throw new IllegalStateException("Messager mustn't be null !");
        }

        messager.printMessage(Diagnostic.Kind.ERROR,i);
    }

    public static void LOGWARNNING(String i){
        if(CLOSE){
            return;
        }

        if(messager==null){
            throw new IllegalStateException("Messager mustn't be null !");
        }
        messager.printMessage(Diagnostic.Kind.WARNING,i);
    }
}
