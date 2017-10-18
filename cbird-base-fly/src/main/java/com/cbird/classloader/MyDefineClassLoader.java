package com.cbird.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * <p>自定义classloader</p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author cuiyh9
 * @version 1.0
 * @Date Created in 2017年10月13日 20:13
 * @since 1.0
 */
public class MyDefineClassLoader extends  ClassLoader {

    private String path = "/Users/cuiyuhui/person/workspace/cbird/cbird-base-fly/target/classes/";

    public MyDefineClassLoader(){

    }
    public MyDefineClassLoader(ClassLoader cl) {
        super(cl);
    }

    @Override
    public Class<?> findClass(String name) {
        byte[] data = loadClassData(name);
        return defineClass(name, data, 0 ,data.length);
    }

    public byte[] loadClassData(String name) {
        name = name.replace(".", "/");
        name = path + name + ".class";
        System.out.println("path:" + name);
        try(FileInputStream fis = new FileInputStream(new File(name));
            ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            int b;
            while( (b = fis.read()) > -1) {
                baos.write(b);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Class findLoadedClassBy(String name) {
        return this.findLoadedClass(name);
    }




    public class  Ann2{

        public void sayHello() {
            System.out.println("I am Ann2,Hello Word");
        }
    }
}
