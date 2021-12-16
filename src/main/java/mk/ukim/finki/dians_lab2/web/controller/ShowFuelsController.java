package mk.ukim.finki.dians_lab2.web.controller;

import mk.ukim.finki.dians_lab2.model.Fuel;
import mk.ukim.finki.dians_lab2.model.Street;
import mk.ukim.finki.dians_lab2.model.exceptions.StreetByNameNotFoundException;
import mk.ukim.finki.dians_lab2.service.FuelService;
import mk.ukim.finki.dians_lab2.service.StreetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

import static java.lang.Math.abs;

@Controller
    @RequestMapping("/showFuels")
public class ShowFuelsController {

    private final FuelService fuelService;
    private final StreetService streetService;

    public ShowFuelsController(FuelService fuelService, StreetService streetService) {
        this.fuelService = fuelService;
        this.streetService = streetService;
    }

    @GetMapping
    public String showFuels(Model model, HttpServletRequest request){

        Float latitude = null;
        Float longitude = null;

        String name = (String) request.getSession().getAttribute("location");

        Optional<Street> street = this.streetService.findByName(name);

        if(street.isPresent()) {
            latitude = street.get().getLatitude();
            longitude = street.get().getLongitude();
        }

        List<Fuel> fuels = this.fuelService.findAll();

        Float razlikaLat = (float)1000;
        Float razlikaLong = (float)1000;
        Long fuelid = null;

        for (Fuel fuel:fuels) {
            Float fuelLat = fuel.getLatitude();
            Float fuelLong = fuel.getLongitude();

            if(abs(latitude - fuelLat)<razlikaLat && abs(longitude-fuelLong)<razlikaLong){
                razlikaLat = abs(latitude - fuelLat);
                razlikaLong = abs(longitude-fuelLong);
                fuelid=fuel.getId();
            }

        }

        model.addAttribute("fuel",this.fuelService.findById(fuelid));

        return "showFuels";
    }

    @PostMapping
    public String chosenFuel(HttpServletRequest request){

        Optional<Fuel> fuel = this.fuelService.findByName(request.getParameter("chosenFuel"));
        request.getSession().setAttribute("finalFuel",fuel);
        return "redirect:/chosen-fuel";
    }

}
