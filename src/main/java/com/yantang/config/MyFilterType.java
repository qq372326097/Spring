package com.yantang.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * MetadataReader：读取到当前正在扫描类的信息
 * MetadataReaderFactory：获取到其他任何类的信息
 */
public class MyFilterType implements TypeFilter{
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取到当前扫面类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取到当前扫描类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类的资源信息(如类的路径等)
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("当前扫描的类是："+className);
        if (className.contains("vice")){
            return true;
        }
        return false;
    }
}
