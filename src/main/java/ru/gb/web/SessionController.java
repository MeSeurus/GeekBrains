package ru.gb.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.entity.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/sessions")
public class SessionController {

    private final Cart cart;

    public SessionController(Cart cart) {
        this.cart = cart;
    }

    @GetMapping
    public String checkSession(Model model, HttpSession httpSession) {
        Cart cart = (Cart) httpSession.getAttribute("cart");
        return "session";
    }

    @PostMapping
    public String saveSession(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Cart cart = new Cart();
        cart.date = new Date();
        session.setAttribute("cart", cart);
        return "session";
    }

    @DeleteMapping
    public String deleteSession(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return "session";
    }

}