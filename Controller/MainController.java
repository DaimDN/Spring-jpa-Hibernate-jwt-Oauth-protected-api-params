package microservices.Spring.Controller;

import microservices.Spring.Database.Access;
import microservices.Spring.Repository.TodoRepo;
import microservices.Spring.Services.Home;
import microservices.Spring.Services.MessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Controller
@RestController
public class MainController {

    ArrayList<Object> Js = new ArrayList<>();

    @Autowired
    public  TodoRepo todoRepo;

    @GetMapping(path="/api/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody Iterable<Access> getAllUsers() {
        return todoRepo.findAll();
    }

    @GetMapping(path = "/list/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody Object getId (@RequestParam int query){
        int n = query;
        Object data = todoRepo.findById(n);
        return data;
    }


    @PutMapping(path = "/java")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody Object getName(@RequestParam int query){
        int n = query;
        Object data = todoRepo.findById(query);
        return data;

    }

    @GetMapping("*")
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public Object ErrorHandling(){
        MessageGenerator message = new MessageGenerator("Error Occured Forbidden Access");
        return message;
    }

    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody Object addTodo(@RequestParam String todo, @RequestParam String desc ){
        Access newaccess = new Access();
        newaccess.setTodo(todo);
        newaccess.setDescription(desc);
        todoRepo.save(newaccess);
        return newaccess;


    }


    /***
     *
     * @ALl of the Dynamic Path
     */



}
