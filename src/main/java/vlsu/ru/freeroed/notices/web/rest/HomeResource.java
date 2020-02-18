package vlsu.ru.freeroed.notices.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeResource {
    @RequestMapping("/index")
    public String retIndex(Model m){
        return "../../index";
    }
}
