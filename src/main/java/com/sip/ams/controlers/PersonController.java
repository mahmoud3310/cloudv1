package com.sip.ams.controlers;
import java.util.ArrayList;
import java.util.List;
import com.sip.ams.entitis.Person;
import com.sip.ams.forms.PersonForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class PersonController {

	private static List<Person> persons = new ArrayList<Person>();
	 
    static {
        persons.add(new Person("Albert", "Einstein"));
        persons.add(new Person("Frederic", "Gauss"));
    }
 
    // Inject via application.properties
    @Value("${welcome.message}")
    private String message;
 
    @Value("${error.message}")
    private String errorMessage;
 
    @RequestMapping(value = { "/indexPerson", "/Person" }, method = RequestMethod.GET)
    public String index(Model model) {
 
        model.addAttribute("message", message);
 
        return "Person/index";
    }
 
    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String personList(Model model) {
 
        model.addAttribute("persons", persons);
 
        return "person/personList";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {
 
        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);
 
        return "person/addPerson";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
    public String savePerson(Model model, //
    	       @ModelAttribute("personForm") PersonForm personForm) {
    	 
        String firstName = personForm.getFirstName();
        String lastName = personForm.getLastName();
 
        if (firstName != null && firstName.length() > 0 //
                && lastName != null && lastName.length() > 0) {
            Person newPerson = new Person(firstName, lastName);
            persons.add(newPerson);
 
            return "redirect:personList";
        }
 
        model.addAttribute("errorMessage", errorMessage);
        return "pages/person/addPerson";
    }
 
}
