package com.izana.OCMS.Controller;

import com.izana.OCMS.DTO.EnrollementRequest;
import com.izana.OCMS.Entity.Enrollement;
import com.izana.OCMS.Service.EnrollemenrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollements")
public class EnrollementController {
    @Autowired
    private EnrollemenrService enrollementService;

    @PostMapping("/add")
    public Enrollement addEnrollement(@RequestBody EnrollementRequest request){
        return enrollementService.addEnrollement(request);
    }

    @GetMapping("/{id}")
    public Enrollement getEnrollementById(@PathVariable Long id){
        return enrollementService.getEnrollementById(id);
    }

    @GetMapping()
    public List<Enrollement> getAllEnrollements(){
        return enrollementService.getAllEnrollements();
    }
}
