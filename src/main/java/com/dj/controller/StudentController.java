package com.dj.controller;
import com.dj.domain.Student;
import com.dj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by 24742 on 2017/6/22.
 */
@Controller
//类级别的mapping
@RequestMapping("/a/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Controller
    public class StudentController1 {
        //方法级别的mapping
//        @RequestMapping(value = "/", method = RequestMethod.GET)
//        public String showStudent(ModelMap model) {
//            model.addAttribute("message", "你好呀！");
//            return "student";
//        }
        //处理/student/
        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
         @ResponseBody
        public Student get(@PathVariable long id) {
            return studentService.findByStudentId(id);
        }
    }

        @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
         @ResponseBody
        public boolean delete(@PathVariable long id){
            return studentService.delete(id);
        }

        @RequestMapping(value = "/count",method = RequestMethod.GET)
         @ResponseBody
        public int countAll(){
            return studentService.countAll();
        }
        //插入学生 返回学生id

        @RequestMapping(value = "/",method = RequestMethod.POST)
         @ResponseBody
        public long insert( @RequestBody Student student ){
            return studentService.insert(student);
        }
        //根据id更新学生信息

    //update方法  原本是想 更改某个已知id更新学生信息 但在这里 把URl里面的id给了post 方法里 @RequestBody 传入的id
        //好像也还是达到了把按id 更改学生的目的呢
        @RequestMapping(value = "/{id}",method = RequestMethod.POST)
        @ResponseBody
        public boolean update(@PathVariable long id,@RequestBody Student student){
            student.setId(id);
            return studentService.update(student);
        }

//        @RequestMapping(value = "/view",method = RequestMethod.GET)
//        public String ViewCourse(@RequestParam("id"), Model model){
//
//            return "view";
//        }
}
