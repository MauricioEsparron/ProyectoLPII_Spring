package pe.com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String mostrarLogin(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("errorMessage", "Usuario o contraseña incorrectos.");
		}
		return "login"; // Asegúrate de que este nombre coincide con tu archivo login.html
	}

	@GetMapping("/logout")
	public String logout() {

		return "redirect:/login";
	}
}
