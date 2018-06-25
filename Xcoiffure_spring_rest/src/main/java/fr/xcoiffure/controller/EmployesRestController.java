package fr.xcoiffure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.xcoiffure.model.Employes;
import fr.xcoiffure.model.Views;
import fr.xcoiffure.idao.IDAOEmployes;


@RestController
@RequestMapping("/employes")
public class EmployesRestController {
    
    @Autowired
    private IDAOEmployes daoEmployes;
    

    @GetMapping("")
    @ResponseBody
    @JsonView(Views.ViewEmployes.class)
    public List<Employes> listEmployes() {
        return daoEmployes.findAll();
    }

    @PostMapping("")
    @ResponseBody
    @JsonView(Views.ViewEmployes.class)
    public void create (@RequestBody Employes employes) {
        daoEmployes.save(employes);
    }
    
    @PutMapping("/{id}")
    @JsonView(Views.ViewEmployes.class)
    public void update(@RequestBody Employes employes) {
        daoEmployes.save(employes);
    }
    
    @DeleteMapping("/{id}")
    @JsonView(Views.ViewEmployes.class)
    public void delete(@PathVariable Integer id) {
        daoEmployes.deleteById(id);
    }
    
}