package org.example;

import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.mapper.StudentMapper;
import org.example.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api("Api接口")
@RestController
@SuppressWarnings("all")
@CrossOrigin(origins = {"*", "null"})
public class Controller {
    @Autowired
    private StudentMapper studentMapper;
    private Gson gson=new Gson();

    @ApiOperation("测试接口")
    @GetMapping("/test")
    public String test(){
        HashMap hashMap = new HashMap(1024);
        return "success";
    }

    @GetMapping("/students")
    public String getStudents(){
        List<Student> students = studentMapper.selectList(null);
        return gson.toJson(students);
    }
    @PostMapping("/add")
    public  void addStudent(@RequestBody Student student){
        studentMapper.insert(student);
    }
    @PostMapping("delete")
    public void removeStudent(@RequestBody Student student){
        studentMapper.deleteById(student);
    }
    @PostMapping("update")
    public void updateStudent(@RequestBody Student student){
        studentMapper.updateById(student);
    }
}
