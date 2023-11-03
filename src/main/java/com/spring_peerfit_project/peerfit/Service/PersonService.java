package com.spring_peerfit_project.peerfit.Service;

import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Person;;
import com.spring_peerfit_project.peerfit.model.Registration;
import com.spring_peerfit_project.peerfit.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private PersonEventRelationService personEventRelationService;

    //create a person, assume that we already have a person object when we call it from controller, already transformed from dto ?? ?
    @Transactional
    public Person createPerson(Person person) {
        if(isValidEmail(person.getEmail())) {
            throw new IllegalArgumentException("bad email format");
        }

        isValid(person);

        Person tmp = personRepo.findByEmail(person.getEmail());
        if(tmp != null) {
            throw new IllegalArgumentException("person with email already exists");
        }

        return personRepo.save(person);
    }

    //from stackoverflow https://stackoverflow.com/questions/8238586/email-validation-in-java
    //TODO test if it works
    private static void isValid(Person person)
    {
        String error = "";
        if(person.getEmail() == null || person.getEmail().isEmpty() || person.getPassword() == null || person.getPassword().isEmpty() || person.getFirstName() == null || person.getFirstName().isEmpty() ||
                person.getLastName() == null || person.getLastName().isEmpty()) {

            error += "parameters invalid";
        } else if(person.getPassword().length()<8) { //password check
            error += "password length than 8";
        } else if(!containsDigit(person.getPassword())) {
            error += "password doesnt contain digit";
        } else if(!containsLetter(person.getPassword())) {
            error += "password doesnt contain letter";
        } else if(!isValidEmail(person.getEmail())) { //email check
            error += "email not valid";
        }

        if(!error.isEmpty()) {
            throw new IllegalArgumentException(error);
        }
    }

    private static boolean isValidEmail(String email) {
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9[!#$%&'()*+,/\\-_\\.\"]]+@[a-zA-Z0-9[!#$%&'()*+,/\\-_\"]]+\\.[a-zA-Z0-9[!#$%&'()*+,/\\-_\"\\.]]+");
        Matcher m = emailPattern.matcher(email);

        return m.matches();
    }

    private static boolean containsDigit(String pass) {
        for(char c: pass.toCharArray()) {
            if(Character.isDigit(c)) return true;
        }
        return false;
    }

    private static boolean containsLetter(String pass) {
        for(char c: pass.toCharArray()) {
            if(Character.isAlphabetic(c)) return true;
        }
        return false;
    }

    @Transactional
    public Person getPersonById(int id) {
        Person person = personRepo.findPersonById(id);
        if(person == null) {
            throw new IllegalArgumentException("person with id doesn't exist");
        }

        return person;
    }

    @Transactional
    public Person getPersonByEmail(String email) {
        if(email == null || email.isEmpty() || !isValidEmail(email)) {
            throw new IllegalArgumentException("email null or empty or wrong format");
        }

        Person person = personRepo.findByEmail(email);
        if(person == null) {
            throw new IllegalArgumentException("person with email doesn't exist");
        }

        return person;
    }

    @Transactional
    public List<Person> getAllPeople() {
        return personRepo.findAll();
    }

    @Transactional
    public List<Person> getPersonsFromEvent(Event event) {

        if(event == null) {
            throw new IllegalArgumentException("event cant be null");
        }

        //event passed from eventRequestDto should have an id (maybe from path variable ?)
        return personEventRelationService.getPersonsFromEvent(event);
    }

    @Transactional
    public Person rate(Person person, float rating) {
        if(rating < 0 || rating >5) {
            throw new IllegalArgumentException("invalid value for rating, must be between 0 and 5");
        }

        //TODO maybe unnecessary, remove later
        if(person == null) {
            throw new IllegalArgumentException("invalid person input");
        }
        person = personRepo.findPersonById(person.getId());
        if(person == null) {
            throw new IllegalArgumentException("person doesn't exist");
        }

        int n = person.getNumberOfRatings();
        float average = person.getAverageRating();
        float sumRatings = average * n;

        sumRatings += rating;
        n += 1;
        person.setAverageRating(sumRatings/n);
        person.setNumberOfRatings(n);
        person = personRepo.save(person);
        return person;
    }

    @Transactional
    public Person changePassword(Person person, String oldPassword) {
        return null;
    }

    @Transactional
    public void delete(Person person) {
        //get all registrations and delete them all
        List<Registration> list = personEventRelationService.getRegistrationsByPerson(person);
        for(Registration registration: list) {
            personEventRelationService.deleteRegistration(registration);
        }
        personRepo.delete(person);
    }

}
