package com.ttn.exercise.json;

/**
 * Created by akhil on 12/4/17.
 */

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;


public class JsonCreate {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        Company user = createJSON();

        try {
            mapper.writeValue(new File("json.txt"), user);

            String jsonInString = mapper.writeValueAsString(user);
            System.out.println(jsonInString);

            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
            System.out.println(jsonInString);


        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Company createJSON() {

        Competency competency1 = new Competency();
        competency1.setName("JVM");
        competency1.setHead("Raghu");
        competency1.setEmployees("500");

        Competency competency2 = new Competency();
        competency2.setName("Drupal");
        competency2.setHead("Karan");
        competency2.setEmployees("30");

        Competency competency3 = new Competency();
        competency3.setName("Mobility");
        competency3.setHead("Ken");
        competency3.setEmployees("50");

        Competency competency4 = new Competency();
        competency4.setName("Sales");
        competency4.setHead("Abhishek");
        competency4.setEmployees("30");

        Competency competency5 = new Competency();
        competency5.setName("HR");
        competency5.setHead("Karan");
        competency5.setEmployees("7");

        Competency[] competenciesForTechnology= new Competency[3];
        competenciesForTechnology[0]=competency1;
        competenciesForTechnology[1]=competency2;
        competenciesForTechnology[2]=competency3;

        Competency[] competenciesForManagement= new Competency[2];
        competenciesForManagement[0]=competency4;
        competenciesForManagement[1]=competency5;

        Department department1 = new Department();
        department1.setName("technology");
        department1.setCompetency(competenciesForTechnology);

        Department department2 = new Department();
        department2.setName("Management");
        department2.setCompetency(competenciesForManagement);

        Department[] departments= new Department[2];
        departments[0]=department1;
        departments[1]=department2;

        TTN ttn = new TTN();
        ttn.setDepartment(departments);

        Company company= new Company();
        company.setTtn(ttn);

        return company;

    }
}
