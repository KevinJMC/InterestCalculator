package stg;

import org.springframework.web.bind.annotation.*;

/**
 * Created by michaelwolfe on 3/3/17.
 */
@RestController
public class Controller {

    @CrossOrigin
    @RequestMapping(value = "/interestCalculator", method = RequestMethod.POST, consumes = {"application/json"})
    public @ResponseBody InterestCalculator getInterest(@RequestBody InterestCalculator calc){
        return calc;
    }
}