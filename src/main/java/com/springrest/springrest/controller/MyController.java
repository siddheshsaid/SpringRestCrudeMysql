package com.springrest.springrest.controller;


import com.springrest.springrest.entity.Courses;
import com.springrest.springrest.service.CourseService;
import com.springrest.springrest.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
  private CourseService courseService;
    @GetMapping("/home")
    public String home(){
        return "This is home page";
    }
    //GET THE COURSES
@GetMapping("/courses")
    public List<Courses> getCourses(){
return this.courseService.getCourses();
    }
    @GetMapping("/courses/{courseId}")
    public  Courses getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));
    }
    @PostMapping("/courses" )
    public Courses addCourse(@RequestBody Courses course){
        return this.courseService.addCourse(course);
    }

//    @PutMapping("/courses/{courseId}"):-USED IF NOT SAVING TO DATABASE
    @PutMapping("/courses")//USED IF WANT TO SAVE TO DATABASE
    public Courses updateCourse(@RequestBody Courses course){
        return this.courseService.updateCourse(course);
    }
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try {
            this.courseService.deleteCourse(Long.parseLong((courseId)));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
