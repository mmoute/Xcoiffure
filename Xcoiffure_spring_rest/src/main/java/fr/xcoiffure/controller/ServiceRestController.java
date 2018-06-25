package fr.xcoiffure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import fr.xcoiffure.model.Service;
import fr.xcoiffure.model.Views;
import fr.xcoiffure.idao.IDAOService;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "*")
public class ServiceRestController {
    
    @Autowired
    private IDAOService daoService;
    

    @GetMapping("")
    @ResponseBody
    @JsonView(Views.ViewService.class)
    public List<Service> listService() {
        return daoService.findAll();
    }

    @PostMapping("")
    @ResponseBody
    @JsonView(Views.ViewService.class)
    public void create (@RequestBody Service service) {
        //System.out.println(service.getEntreprise().getId());
        daoService.save(service);
    }
    
    @PutMapping("/{id}")
    @JsonView(Views.ViewService.class)
    public void update(@RequestBody Service service) {
        daoService.save(service);
    }
    
    @DeleteMapping("/{id}")
    @JsonView(Views.ViewService.class)
    public void delete(@PathVariable Integer id) {
        daoService.deleteById(id);
    }
    
}