package co.edu.unimonserrate.webproject.student.application.controller;

import co.edu.unimonserrate.webproject.student.application.StudentService;
import co.edu.unimonserrate.webproject.student.domain.dto.StudentDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * This class represents the controller for the login of the student.
 *
 * @see StudentService
 * @see StudentDTO
 */
@Controller
public final class LoginStudentController {
  private final StudentService studentService;

  public LoginStudentController(final @NotNull StudentService studentService) {
    this.studentService = studentService;
  }

  /**
   * This method creates a new student.
   *
   * @return a new student
   */
  @ModelAttribute
  private StudentDTO student() {
    return new StudentDTO();
  }

  /**
   * This method shows the login page.
   *
   * @return the login page
   */
  @GetMapping("/")
  public String show() {
    return "index";
  }

  /**
   * This method login a student.
   *
   * @param student the student to login
   * @return the home page if the student exists, the login page otherwise
   */
  @PostMapping("/login")
  public String login(@ModelAttribute("student") final @NotNull StudentDTO student) {
    if (this.studentService.getStudent(student) != null) {
      return "redirect:/home";
    }
    return "redirect:/?error";
  }
}
