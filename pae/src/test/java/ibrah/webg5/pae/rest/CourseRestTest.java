// package ibrah.webg5.pae.rest;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import java.util.Optional;

// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;

// import ibrah.webg5.pae.model.Course;
// import ibrah.webg5.pae.service.CourseService;




// @WebMvcTest
// public class CourseRestTest {

//     @Autowired
//     private MockMvc mvc;

//     @MockBean
//     private CourseService courseService;

//     @Test
//     public void getUserByName() throws Exception {
//         String id = "MCD";
//         Course course = new Course("MCD", "mdldm", 4, null);
        
        
//         // Mockito.when(courseService.getCourseById(name)).thenReturn(course); // mtn on suposse que le service fonctionne correctement
//         Mockito.when(courseService.getCourseById(id)).thenReturn(Optional.of(course).get());

//         mvc.perform(get("/api/courses/MCD")) // Test une URL
//             .andExpect(status().isOk()) // s'attend à recevoir le status 200 <=> isOk() <=> HttpStatus.OK
//             .andExpect(jsonPath("$.id").value(id)); // s'attend à ce que le code JS $.name a comme valeur "MCD"
//     }
// }
