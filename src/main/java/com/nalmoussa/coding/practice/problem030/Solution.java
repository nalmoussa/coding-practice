package com.nalmoussa.coding.practice.problem030;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  Using the example urls below:
  urls = [
           'https://thedyrt.com/about/us',
           'https://catholiceldercare.org/contact',
           'https://reportshealthcare.com/our-team',
           'https://womensfitnessclubs.com/careers/'
         ]

  Write a function that accepts a list of urls and extracts all emails from every webpage in the list and
  Returns a list where every element is a dictionary with url and email keys populated with extracted values:
    [
      {'url': "https://catholiceldercare.org/contact", 'email':"dlucas@catholiceldercare.org"},
      {'url': "https://thedyrt.com/about/us", 'email':"info@thedyrt.com"},
      ...
    ]

  Feel free to google anything you need to (as long as it is not "how to get emails from a webpage" or anything similar)
 */
public class Solution {
  public static void main(String[] args) {
    List<String> inputList = new ArrayList<>();
    inputList.add("https://thedyrt.com/about/us");
    inputList.add("https://catholiceldercare.org/contact");
    inputList.add("https://reportshealthcare.com/our-team");
    inputList.add("https://womensfitnessclubs.com/careers/");

    List<Map<String, String>> results = getAllEmails(inputList);
    printResults(results);
  }

  private static void printResults(List<Map<String, String>> results) {
    for (Map<String, String> map : results) {
      System.out.println("Url: " + map.get("url"));
      System.out.println("Email: " + map.get("email"));
    }
  }

  private static String getUrl(String url) {
    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(url))
          .build();

      HttpResponse<String> response = client.send(request,
          HttpResponse.BodyHandlers.ofString());

      return response.body();
    } catch (Exception e) {
      return "";
    }
  }

  private static List<Map<String, String>> getAllEmails(List<String> urls) {
    List<Map<String, String>> output = new ArrayList<>();
    for (String url : urls) {
      output.addAll(getAllEmails(url));
    }

    return output;
  }

  private static List<Map<String, String>> getAllEmails(String url) {
    List<Map<String, String>> output = new ArrayList<>();
    String body = getUrl(url);
    // check if body has emails
    List<String> emails = getEmails(body);
    mapEmailsToUrl(url, emails, output);

    return output;
  }

  private static void mapEmailsToUrl(String url, List<String> emails, List<Map<String, String>> output) {
    for (String email : emails) {
      Map<String, String> map = new HashMap<>();
      map.put("url", url);
      map.put("email", email);
      output.add(map);
    }
  }

  private static List<String> getEmails(String body) {
    List<String> emails = new ArrayList<>();
    String regex = "([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+.[a-zA-Z0-9_-]+)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(body);
    while (matcher.find()) {
      emails.add(matcher.group());
    }

    return emails;
  }
}