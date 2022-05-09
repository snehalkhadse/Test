# Page Object model Test automation framework using Selenium with Java, TestNG and Maven-
This is a sample project to demonstrate what is page object model framework and how it can used in selenium to automate any application.
TestNG is used as test framework.

## Dependency
Java
Maven

## libraries used
Selenium
TestNG


###### Working
In this project i have created two test cases as below

1. IMDBTest case
   Open browser
   open the url https://www.imdb.com/ website
   Enter movie name in search box and search
   Extract movie date and country
   store the movie details in movie_details.properties file

2. WikiTest case
   Here we have 2 different test case for verifying the relase date and country 
   verifyDateWikiDate() and verifyDateWikiCountry
   Here is the steps for above case 
   Open browser
   open the url https://en.wikipedia.org/wiki/ website
   Enter movie name in search box and search
   Extract movie date and country and compare with IMDB site details(details are featuring movie_details.properties file) with help of testng assertion.
    
## execution 
Configure test case in textng.xml file pls run this file
Individual case run flow
1.IMDBTest case
2.WikiTest case

Note: Under WikiTest case verifyDateWikiDate() case will get failed because of date format is different on both the site 

## This project support maven commands 


