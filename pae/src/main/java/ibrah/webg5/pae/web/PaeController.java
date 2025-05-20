package ibrah.webg5.pae.web;

import java.io.Console;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.Errors;

import ibrah.webg5.pae.business.PAE;
import ibrah.webg5.pae.dto.CoursesStudentDto;
import ibrah.webg5.pae.model.Course;
import ibrah.webg5.pae.model.Student;
import ibrah.webg5.pae.repository.CourseDB;
import ibrah.webg5.pae.repository.StudentDB;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PaeController {
    private static final Logger logger = LoggerFactory.getLogger("PAE Controller");
    @Autowired
    PAE pae;// je dit que c'est pas moi qui va l'instancier, si je ft pas un service alors
            // que peut pas fr de @autowaried

    @Autowired
    private CourseDB courseDB;

    @Autowired
    private StudentDB studentDB;

    // @Autowired
    // private CoursesStudentDto coursesStudentDto;

    @GetMapping("/")
    public String home() {
        // List<Course> coursesWithCredits = courseDB.findByCreditsGreaterThanEqual(3);
        // System.out.println("Cours avec des crédits >= 3 :");
        // for (Course course : coursesWithCredits) {
        // System.out.println(course.getTitle());
        // }

        // Course course = courseDB.findByTitleContaining("Math");
        // System.out.println(course.getTitle());

        // List<String> l = studentDB.findNameStudent();
        // for (String s : l) {
        //     System.out.print(s + " - ");
        // }

        return "home";
    }

    @GetMapping("/courses")
    public String courses(Model model) {

        // List<Course> courses = PAE.getCourses();

        model.addAttribute("courses", pae.getCourses());
        model.addAttribute("course", new Course());

        return "course";
    }

    @GetMapping("/students")
    public String students(Model model, @RequestParam(name = "filter", required = false) String filter) {
        
        List<Student> students = pae.getStudents();

        if (filter != null && !filter.isEmpty()) {
            students = studentDB.findByNomContainingIgnoreCase(filter);
            model.addAttribute("students", students);
            model.addAttribute("student", new Student());
        } else {
            model.addAttribute("students", students);

            model.addAttribute("student", new Student());

        }

        return "student";
    }

    @PostMapping("/students/add")
    public String add(@Valid Student student, Errors errors, Model model) {
        // @valid par rapport au contrainte que j'ai mis dans la classe course, ex.:
        // notBlank
        if (errors.hasErrors()) {
            model.addAttribute("students", pae.getStudents());// ajouter pour qua affiche liste
            return "student";
        }
        logger.info("Ajout du " + student);
        studentDB.save(student);
        // redirect si pas de probleme
        return "redirect:/students";
    }

    @PostMapping("/courses/add")
    public String add(@Valid Course course, Errors errors, Model model) {
        // @valid par rapport au contrainte que j'ai mis dans la classe course, ex.:
        // notBlank
        if (errors.hasErrors()) {
            model.addAttribute("courses", pae.getCourses());// ajouter pour qua affiche liste
            return "course";
        }
        logger.info("Ajout du " + course);
        courseDB.save(course);
        // redirect si pas de probleme
        return "redirect:/courses";
    }

    @GetMapping("/courses/details/{courseId}")
    public String detailCourse(@PathVariable(value = "courseId") String courseId, Model model) {
        CoursesStudentDto coursesStudentDto = new CoursesStudentDto();
        coursesStudentDto.setCourseId(courseId); 

        // log.trace("debut cours", courseId);
        model.addAttribute("course", pae.getCourse(courseId));
        //test
        model.addAttribute("coursesStudentDto",coursesStudentDto);
        // log.trace("fin cours",courseId);
        return "courseDetail";
    }

    @GetMapping("/students/details/{studentId}")
    public String detailStudent(@PathVariable(value = "studentId") Long studentId, Model model) {
        CoursesStudentDto coursesStudentDto = new CoursesStudentDto();
        //test
        model.addAttribute("coursesStudentDto",coursesStudentDto);

        model.addAttribute("student", pae.getStudent(studentId));
        return "studentDetail";
    }

    @PostMapping("/courses/addStudent")
    public String addUserCoursises(@ModelAttribute("coursesStudentDto") CoursesStudentDto coursesStudentDto,Long studentId, String courseId) {



         Course course = courseDB.findById(coursesStudentDto.getCourseId()).get();
         Student student = studentDB.findById(coursesStudentDto.getStudentId()).get();

        // Course course = courseDB.findById(courseId).get();// rrecuperer optional en get
        //Student student = studentDB.findById(studentId).get();
        
        //faire ça dans pae
        course.getStudents().add(student);
        courseDB.save(course);

        // ausso      
        student.getCourses().add(course);
        studentDB.save(student);
        return "redirect:/courses";
    }

    @PostMapping("/students/addCourse")
    public String addUserstudent(@ModelAttribute("coursesStudentDto") CoursesStudentDto coursesStudentDto,String courseId, Long studentId) {

        Course course = courseDB.findById(coursesStudentDto.getCourseId()).get();
        Student student = studentDB.findById(coursesStudentDto.getStudentId()).get();

        // Course course = courseDB.findById(courseId).get();// rrecuperer optional en get
         //Student student = studentDB.findById(studentId).get();

         //faire ça dans pae
        course.getStudents().add(student);
        courseDB.save(course);

        student.getCourses().add(course);
        studentDB.save(student);

        return "redirect:/students";
    }

}
