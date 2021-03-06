package com.code.fuqinqin.jdk.reflect;

import lombok.Data;
import lombok.ToString;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 私有构造器测试案例
 * @author fuqinqin3
 * @date 2020-04-30
 * */
public class PrivateConstrTest {
    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Person> constructor = Person.class.getDeclaredConstructor(new Class[]{Long.class, String.class});
        constructor.setAccessible(true);
        Person person = constructor.newInstance(1L, "张三");
        System.out.println("person = " + person);
    }

    @Test
    public void EnumReflectTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*Constructor<PersonEnum> constructor = PersonEnum.class.getDeclaredConstructor(new Class[]{Byte.class, String.class});
        constructor.setAccessible(true);
        PersonEnum personEnum = constructor.newInstance((byte) 1, "p1");
        System.out.println("结果："+personEnum.codeOf((byte)3));*/

        Method method = PersonEnum.class.getMethod("codeOf", Byte.class);
        System.out.println("method ("+method.getName()+") is "+(Modifier.isStatic(method.getModifiers())?"":"not")+" static");
        PersonEnum personEnum = (PersonEnum) method.invoke(null, (byte) 1);
        System.out.println("personEnum = " + personEnum);
    }

    @Data
    private static class Person{
        private Long id;
        private String name;

        private Person(Long id, String name){
            this.id = id;
            this.name = name;
        }
    }

    @ToString
    private enum  PersonEnum {
        PERSON_1((byte)1, "p1"),
        PERSON_2((byte)2, "p1"),
        PERSON_3((byte)3, "p1"),
        ;

        PersonEnum(Byte code, String desc){
            this.code = code;
            this.desc = desc;
        }

        private Byte code;
        private String desc;

        public Byte code(){
            return this.code;
        }

        public String desc(){
            return this.desc;
        }

        public static PersonEnum codeOf(Byte code){
            if(code == null){
                return null;
            }
            for (PersonEnum personEnum : values()) {
                if(personEnum.code.byteValue() == code.byteValue()){
                    return personEnum;
                }
            }
            return null;
        }
    }
}
