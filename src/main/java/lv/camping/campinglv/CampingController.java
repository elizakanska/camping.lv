package lv.camping.campinglv;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CampingController {

    @GetMapping("/")
    public String home() {
        return "/lv/index";
    }

    @GetMapping("/eng/")
    public String eng-home() {
        return "/eng/index";
    }

    @GetMapping("/lv/katalogs")
    public String katalogs() {
        return "/lv/katalogs"; 
    }

    @GetMapping("/lv/karte")
    public String karte() {
        return "/lv/karte"; 
    }

    @GetMapping("/aktualitates")
    public String aktualitates() { return "/aktualitates";}

    @GetMapping("/lv/asociacija")
    public String asociacija() {
        return "/lv/asociacija"; 
    }

    @GetMapping("/lv/saites")
    public String saites() {
        return "/lv/saites"; 
    }

    @GetMapping("/lv/kontakti")
    public String kontakti() {
        return "/lv/kontakti"; 
    }
}
