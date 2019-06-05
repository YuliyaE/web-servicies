package com.epam.webservices.training.demo;

import com.epam.webservices.training.model.user.Company;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonDemo {

    public static void main(String[] args) {
        parseToGson();
        parseFromGson();

    }

    public static void parseToGson() {
        Company company = new Company();
        company.setName("Coca-cola");
        company.setCatchPhrase("ABC");
        company.setBs("zxcv");
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(company));
    }

    public static void parseFromGson() {
       String jsonText = "{\"name\":\"Coca-cola\",\"catchPhrase\":\"ABC\",\"bs\":\"zxcv\",\"additionalProperties\":{}}";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Company company = gson.fromJson(jsonText, Company.class);
        System.out.println("Company name:" + company.getName() + " catchPhrase: " + company.getCatchPhrase() + " bs: " + company.getBs());
    }

}
