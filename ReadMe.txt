1) This project is to search,select and verify wines data on website www.vivino.com

2) The technology stack used is Selenium+Java+Cucumber+Maven

3) The search keyword is configurable - can be passed from Examples table of Scenario Outline in cucumber feature.

4) This project can be easily scaled up by adding more test data in feature file and can handle cross browser testing as well.

5) The data that is being verified for each search result is:
   Title
   Region
   Country
   Average Rating
   Total rating Count
   If any of these items is not present in card of each item in search results, Test will be marked as fail
   Also keyword presence is verified in Title, Region, Country of each card

6) All the above fields are also verified for the selected wine.

7) It uses page object model where in all WebElements are stored in page wise classes in package src/main/java/objectRepository.
8) Test is stored in 'features' folder
   Glue code is present in src/main/java/stepDefinitions
   Test Runner file is present at : /src/test/java/TestRunner.java
   To run the test --> TestRunner.java --> Run As --> JUnit Test



