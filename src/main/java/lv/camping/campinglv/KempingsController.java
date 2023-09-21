package lv.camping.campinglv;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;

@Controller
public class KempingsController {
    private final KempingsRepository kempingsRepository;

    @Autowired
    public KempingsController(KempingsRepository kempingsRepository) {
        this.kempingsRepository = kempingsRepository;
    }

    @GetMapping("/kempings/{id}")
    public String showKempings(@PathVariable int id, Model model) {
        try {
            Kempings kempings = kempingsRepository.getKempingsById(id);
            model.addAttribute("kempings", kempings);
            return "kempings";
        } catch (IOException e) {
            // Handle the exception
            return "error"; // You can create an error page for handling exceptions.
        }
    }
}

