package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private Map<String, List<String>> phonebook;
    List<String> teleNumbers = new ArrayList<>();

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;

    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        teleNumbers.add(phoneNumber);
        phonebook.put(name, teleNumbers);
    }

    public void addAll(String name, String... phoneNumbers) {
//        for(String thisNumber : phoneNumbers){
//            teleNumbers.add(thisNumber);
//
//        }
        teleNumbers.addAll(Arrays.asList(phoneNumbers));
        phonebook.put(name, teleNumbers);
    }


    public void remove(String name) {
        phonebook.remove(name);
    }


    public Boolean hasEntry(String name, String phoneNumber) {
        return phonebook.containsKey(name) ;
    }
    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber) {

        for (Map.Entry<String, List<String>> nameList : phonebook.entrySet()) {
            if (nameList.getValue().contains(phoneNumber)) {
                return nameList.getKey();
            }


        } return null;
    }

    public List<String> getAllContactNames() {
        List<String> nameList = new ArrayList<String>(phonebook.keySet());

        return nameList;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
