package ibrah.webg5.pae.web;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
@SpringBootTest
@AutoConfigureMockMvc
public class ControlCourseTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void home() throws Exception{
        mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("home"))
        .andExpect(content().string(Matchers.containsString("welcome to the annual student program management site.")));
    }

    // @Test
    // public void layout() throws Exception{
    //     mockMvc.perform(get("/layout"))
    //     .andExpect(status().isOk())
    //     .andExpect(view().name("layout"))
    //     .andExpect(content().string(Matchers.containsString("Ce contenu sera remplacé par le vrai")));
    // }

    // @Test
    // public void showIndex() throws Exception{
    //     mockMvc.perform(get("/send"))
    //     .andExpect(status().isOk())
    //     .andExpect(view().name("home"))
    //     .andExpect(content().string(Matchers.containsString("y=49")));
    // }

    // @Test
    // public void showCourses() throws Exception{
    //     mockMvc.perform(get("/courses"))
    //     .andExpect(status().isOk())
    //     .andExpect(view().name("courses"))
    //     .andExpect(content().string(Matchers.containsString("Cours de web 7")));
    // }

    // @Test
    // public void doSomeString() throws Exception{
    //     // mockMvc.perform(get("/courses/add"))
    //     // .andExpect(status().isOk())
    //     // .andExpect(view().name("courses"))
    //     // .andExpect(content().string(Matchers.containsString("Cours de web 7")));
    // }

    
    // @Test
    // public void showCourses2() throws Exception{
    //     mockMvc.perform(get("/courses/add"))
    //     .andExpect(status().isOk())
    //     .andExpect(view().name("courses"))
    //     .andExpect(content().string(Matchers.containsString("Developpement web 1")));
    // }

    // @Test
    // public void showDetail() throws Exception{
    //     // mockMvc.perform(get("/courses/details?cours=INT1"))
    //     // .andExpect(status().isOk())
    //     // .andExpect(view().name("detailCourse"))
    //     // .andExpect(content().string(Matchers.containsString("YOUSSEF")));
    // }

    // @Test
    // public void showDetailv2() throws Exception{
    //     // mockMvc.perform(get("/courses/INT1/details"))
    //     // .andExpect(status().isOk())
    //     // .andExpect(view().name("detailCourse"))
    //     // .andExpect(content().string(Matchers.containsString("YOUSSEF")));
    // }


}

