package com.theironyard;

import javax.crypto.AEADBadTagException;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        HashMap<String, ArrayList<Country>> countryMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a letter");
        String letter = scanner.nextLine();
        if (letter.length() != 1) {
            throw new Exception("Invalid input");
        }

        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);
        while(fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country(columns[0], columns[1]);
            //System.out.println(country);
            String firstLetter = String.valueOf(country.name.charAt(0));
            if (!countryMap.containsKey(firstLetter)) {
                 countryMap.put(firstLetter, new ArrayList<>());
            }
            ArrayList<Country> arrayList = countryMap.get(firstLetter);
            arrayList.add(country);
        }
        System.out.println(countryMap);

        File file = new File(letter + "_countries.txt");
        FileWriter fw = new FileWriter(file);

        ArrayList<Country> arr = countryMap.get(letter);
        for (Country country : arr) {
           String line = String.format("%s | %s\n", country.abbre, country.name);
            fw.append(line);
        }
        fw.close();
    }
}
