package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.dto.FacultyDtoIn;
import ru.hogwarts.school.dto.FacultyDtoOut;
import ru.hogwarts.school.dto.StudentDtoOut;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping(value = "/faculty")
public class FacultyController {

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    private final FacultyService facultyService;




    @PostMapping                            // POST http://localhost:8080/faculty
    public FacultyDtoOut createFaculty(@RequestBody FacultyDtoIn facultyDtoIn) {
        return facultyService.createFaculty(facultyDtoIn);
    }

    @GetMapping("/{id}")                             // GET http://localhost:8080/faculty
    public FacultyDtoOut readFaculty(@PathVariable("id") long id) {
        return facultyService.readFaculty(id);
    }


    @PutMapping("/{id}")                      // PUT http://localhost:8080/faculty/1
    public FacultyDtoOut updateFaculty(@PathVariable("id") long id, @RequestBody FacultyDtoIn facultyDtoIn) {
        return facultyService.updateFaculty(id, facultyDtoIn );
    }

    @DeleteMapping("/{id}")                         // DELETE http://localhost:8080/faculty/1
    public FacultyDtoOut deleteFaculty(@PathVariable("id") long id) {
        return facultyService.deleteFaculty(id);
    }


    @GetMapping
    public List<FacultyDtoOut> endpointFaculty(@RequestParam(required = false) String color){
        return facultyService.findAll(color);
    }

    @GetMapping("/filter")
    public List<FacultyDtoOut> findByColorOrName(@RequestParam String colorOrName){
        return facultyService.findByColorOrName(colorOrName);
    }

    @GetMapping("/{id}/student")
    public List<StudentDtoOut> findStudent(@PathVariable("id") long id){
        return facultyService.findStudent(id);
    }

}
