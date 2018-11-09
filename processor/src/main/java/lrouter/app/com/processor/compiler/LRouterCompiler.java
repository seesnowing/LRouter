/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package lrouter.app.com.processor.compiler;

import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;


@SupportedAnnotationTypes("lrouter.app.com.processor.annotation.LParamInjector")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class LRouterCompiler extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        System.out.print("=====================start==============");
        return false;
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }
}
