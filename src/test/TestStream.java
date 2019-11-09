import com.enjoy.domain.Student;
import com.enjoy.util.TimeUtil;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description :使用stream
 * @param :
 * @author :liqy
 * @version :1.0.0.1
 * @data :2019-11-06 21:04
 */
public class TestStream {

    public static void main(String [] args){

        //获取学生集合
        List<Student> list = getStudent();
        //根据年龄从大到小排序
        getStudentOrderByIdDesc(list);
        //获取名字包含指定字符的对象
        //getStudentNameCantonsWord(list,"五");

        //获取所有人的名字，用 / 分割
        getStudent(list);

        //获取年龄最小的学生
        getMinAgeStudent(list);

        //获取年龄等于15的学生
        getStudentByAge(list,15);


    }

    //根据年龄从大到小排序
    public static void getStudentOrderByIdDesc(List<Student> list){
        List<Student> studentList = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        studentList.forEach(s-> System.out.println(s));

    }

    //获取名字包含指定字符的对象
    public static void getStudentNameCantonsWord(List<Student> list,String word){
        List<Student> studentList = list.stream().filter(s -> s.getName().contains(word)).collect(Collectors.toList());
        studentList.forEach(s -> System.out.println(s));
    }

    //获取所有人的名字，用 / 分割
    public static void getStudent(List<Student> list){
        List<String> nameList = list.stream().map(Student::getName).collect(Collectors.toList());
        String join = String.join("/", nameList);
        System.out.println(join);

    }

    //获取年龄最小的学生
    public static void getMinAgeStudent(List<Student> list){
        Optional<Student> first = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).findFirst();
        if(first.isPresent()){
            Student student = first.get();
            System.out.println(student);
        }
    }


    public static void getStudentByAge(List<Student> list,Integer age){
        Optional<Student> any = list.stream().filter(s -> s.getAge() == age).findAny();
        if (any.isPresent()){
            System.out.println(any.get());
        }

    }

















    public static List<Student> getStudent(){
        ArrayList<Student> list = Lists.newArrayList();
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("张三");
        s1.setAge(12);
        s1.setBirthday(new Date());
        list.add(s1);


        Student s2 = new Student();
        s2.setId(2);
        s2.setName("李四");
        s2.setAge(14);
        s2.setBirthday(new Date());
        list.add(s2);

        Student s3 = new Student();
        s3.setId(3);
        s3.setName("王五");
        s3.setAge(17);
        s3.setBirthday(new Date());
        list.add(s3);

        Student s4 = new Student();
        s4.setId(3);
        s4.setName("王五");
        s4.setAge(15);
        s4.setBirthday(new Date());
        list.add(s4);


        return list;
    }




}
