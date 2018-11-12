/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package lrouter.app.com.processor.compiler;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import lrouter.app.com.processor.Config;
import lrouter.app.com.processor.annotation.LClass;
import lrouter.app.com.processor.annotation.LMethod;
import lrouter.app.com.processor.annotation.LParam;
import lrouter.app.com.processor.utils.LogUtils;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class LRouterProcessor extends AbstractProcessor {

    private Types mTypes;
    private Elements mElements;
    private Filer mFilter;
    private Messager mMessager;

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        // 这里处理我们的注解解析，以及生成相应的java 文件。
        for(Element elementOfAnnotated:roundEnvironment.getElementsAnnotatedWith(LClass.class)){
            if(elementOfAnnotated.getKind()!=ElementKind.CLASS){
                throw new IllegalArgumentException("un suitable recognized modifier");
            }
            //生成注解代码
            generateRoutes(elementOfAnnotated);
        }
        return true;
    }

    private void generateRoutes(Element classElement) {
        LClass annotation = classElement.getAnnotation(LClass.class);
        String name = annotation.classname();
        String generateCls = name + Config.SUFFIX;
        MethodSpec getMessage=MethodSpec.methodBuilder("getMessage")
                .addModifiers(Modifier.PUBLIC)
                .returns(String.class)
                .addStatement("return $S","hello result ！！！!")
                .build();
        TypeSpec classGenerate=TypeSpec.classBuilder(generateCls)
                .addModifiers(Modifier.PUBLIC)
                .addMethod(getMessage)
                .build();
        JavaFile generateFile=JavaFile.builder(Config.LROUTER_ABSOLUTELY_PATH,classGenerate)
                .build();
        try {
            generateFile.writeTo(System.out);
            generateFile.writeTo(processingEnv.getFiler());
        } catch (Exception e) {
            LogUtils.LOGWARNNING(e.getLocalizedMessage());
        }
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mTypes=processingEnv.getTypeUtils();
        mElements=processingEnv.getElementUtils();
        mFilter=processingEnv.getFiler();
        mMessager=processingEnv.getMessager();
        LogUtils.init(mMessager);
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations=new LinkedHashSet<>();
        annotations.add(LClass.class.getCanonicalName());
        annotations.add(LMethod.class.getCanonicalName());
        annotations.add(LParam.class.getCanonicalName());
        return annotations;
    }
}
