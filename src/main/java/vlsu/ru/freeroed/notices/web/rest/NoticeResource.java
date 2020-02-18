package vlsu.ru.freeroed.notices.web.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vlsu.ru.freeroed.notices.dao.NoticieDAO;
import vlsu.ru.freeroed.notices.domain.Notice;

import java.util.List;

@Controller
public class NoticeResource {

    @Autowired
    NoticieDAO noticieDAO;

    private static final Logger logger = Logger.getLogger(NoticeResource.class);

    @GetMapping("/noticies")
    public String getAllNoticies(Model model){
        logger.debug("Controller requesr for get all Noticies");
        List<Notice> notices = noticieDAO.getAll();
        model.addAttribute("list", notices);
        return "noticies";
    }

    @RequestMapping("/noticies/new")
    public String newNotice(Model model) {
        model.addAttribute("command", new Notice());
        return "create-notice";
    }
    @PostMapping("/noticies/create")
    public String create(@ModelAttribute("emp") Notice notice){
        logger.debug("Controller request for create notice: {}" + notice.toString());
        noticieDAO.create(notice);
        return "redirect:/noticies";
    }

    @RequestMapping(value = "/edit-notice/{id}")
    public String edit(@PathVariable int id, Model model){
        Notice notice = noticieDAO.findById(id);
        model.addAttribute("command", notice);
        return "edit-notice";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("emp") Notice notice){
        logger.debug("Controller request for update notice: {}" + notice.toString());
        noticieDAO.update(notice);
        return "redirect:/noticies";
    }

    @GetMapping("/delete-notice/{id}")
    public String delete(@PathVariable int id){
        logger.debug("Controller request for delete notice with id: {}" + id);
        noticieDAO.delete(id);
        return "redirect:/noticies";
    }


}
