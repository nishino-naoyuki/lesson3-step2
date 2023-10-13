package com.classroom.assignment.controller.view;

import com.classroom.assignment.controller.ArchievementController;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ArchievementControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ArchievementController controller;

  @Test
  void contextLoads() {
    // given
    // when
    // then
    assertThat(controller).isNotNull();
  }

  @Test
  public void shouldReturnArchievements() throws Exception {
    // given
    // when
    // then
    this.mockMvc.perform(get("/archievement")).andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("ITパスポート")))
        .andExpect(content().string(containsString("基本情報")))
        .andExpect(content().string(containsString("portal作成")));
  }
}
