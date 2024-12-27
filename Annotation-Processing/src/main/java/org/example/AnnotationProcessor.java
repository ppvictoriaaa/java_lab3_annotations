package org.example;

import com.google.auto.service.AutoService;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.tools.Diagnostic;
import java.lang.reflect.Modifier;
import java.util.Set;


@AutoService(Processor.class)
@SupportedAnnotationTypes({
        "org.example.NotNull",
        "org.example.StringLength",
        "org.example.MaxValue",
        "org.example.MinValue"
})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class AnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            if (annotation.getQualifiedName().toString().equals(NotNull.class.getCanonicalName())) {
                validateNotNull(roundEnv);
            } else if (annotation.getQualifiedName().toString().equals(StringLength.class.getCanonicalName())) {
                validateStringLength(roundEnv);
            } else if (annotation.getQualifiedName().toString().equals(MaxValue.class.getCanonicalName())) {
                validateMaxValue(roundEnv);
            } else if (annotation.getQualifiedName().toString().equals(MinValue.class.getCanonicalName())) {
                validateMinValue(roundEnv);
            }
        }
        return true;
    }

    private void validateNotNull(RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(NotNull.class)) {
            if (element.getKind() != ElementKind.FIELD) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        "@NotNull has to be used only for fields!", element);
            }
        }
    }

    private void validateStringLength(RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(StringLength.class)) {
            if (element.getKind() != ElementKind.FIELD) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        "@StringLength has to be used only for fields!", element);
                continue;
            }

            VariableElement field = (VariableElement) element;
            if (!field.asType().toString().equals("java.lang.String")) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        "@StringLength has to be used only for String fields!", field);
            }
        }
    }

    private void validateMaxValue(RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(MaxValue.class)) {
            if (element.getKind() != ElementKind.FIELD) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        "@MaxValue has to be used only for fields!", element);
                continue;
            }

            VariableElement field = (VariableElement) element;
            if (!field.asType().toString().equals("int") && !field.asType().toString().equals("java.lang.Integer")) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        "@MaxValue has to be used only for int/Integer fields!", field);
            }
        }
    }

    private void validateMinValue(RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(MinValue.class)) {
            if (element.getKind() != ElementKind.FIELD) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        "@MinValue has to be used only for fields!", element);
                continue;
            }

            VariableElement field = (VariableElement) element;
            if (!field.asType().toString().equals("int") && !field.asType().toString().equals("java.lang.Integer")) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        "@MinValue has to be used only for int/Integer fields!", field);
            }
        }
    }
}

