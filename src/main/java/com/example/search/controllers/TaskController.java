package com.example.search.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.search.domains.Task;
import com.example.search.mappers.TaskMapper;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	private final TaskMapper taskMapper;
	
    @Autowired
    public TaskController(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Task> tasks = taskMapper.all();
        model.addAttribute("tasks", tasks);
        
    	List<Task> members = taskMapper.allMember();
    	model.addAttribute("members", members);
        return "tasks/index";
    }
    
    @GetMapping("/search")
    public String search(int memberId, Model model) {
        List<Task> tasks = taskMapper.findByMemberTask(memberId);
        model.addAttribute("tasks", tasks);
        
    	List<Task> members = taskMapper.allMember();
    	model.addAttribute("members", members);
        return "tasks/index";
    }
    
    @GetMapping("/noComplite")
    public String noCompliteTaskSearch(Model model) {
        List<Task> tasks = taskMapper.findNotComplite();
        model.addAttribute("tasks", tasks);
        
    	List<Task> members = taskMapper.allMember();
    	model.addAttribute("members", members);
        return "tasks/index";
    }
    
    @GetMapping("/add")
    public String showCreateFrom(Model model) {
    	List<Task> members = taskMapper.allMember();
    	model.addAttribute("members", members);
    	return "tasks/add";
    }
    
    @PostMapping("/add")
    public String add(@RequestParam String title, @RequestParam Date timelimit, @RequestParam int memberId) {
    	try {
    		Task task = new Task(title, timelimit, memberId);
    		taskMapper.add(task);
    	} catch(Exception e) {
    		e.printStackTrace();
    	    System.out.println(e);
    	}
    	return "redirect:/tasks/index";
    }
    
    @PutMapping("/complite/{id}")
    public String complite(@PathVariable int id) {
    	taskMapper.compliteTask(id);
    	return "redirect:/tasks/index";
    }
}
