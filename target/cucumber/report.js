$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SearchWine.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: lavigarg05@gmail.com"
    }
  ],
  "line": 3,
  "name": "Search for a wine based on keyword",
  "description": "",
  "id": "search-for-a-wine-based-on-keyword",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 6,
  "name": "Search Wine",
  "description": "",
  "id": "search-for-a-wine-based-on-keyword;search-wine",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@SearchWine"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Launch website \u003cwebsite\u003e in \u003cbrowser\u003e browser",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Search for \"\u003ckeyword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "collect information of all wines",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "verify each wine data for \"\u003ckeyword\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "select a random wine",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "collect information for selected wine",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "verify selected wine data",
  "keyword": "Then "
});
formatter.examples({
  "line": 16,
  "name": "",
  "description": "",
  "id": "search-for-a-wine-based-on-keyword;search-wine;",
  "rows": [
    {
      "cells": [
        "keyword",
        "website",
        "browser"
      ],
      "line": 17,
      "id": "search-for-a-wine-based-on-keyword;search-wine;;1"
    },
    {
      "cells": [
        "New Wines",
        "http://www.vivino.com",
        "chrome"
      ],
      "line": 18,
      "id": "search-for-a-wine-based-on-keyword;search-wine;;2"
    },
    {
      "cells": [
        "Australian",
        "http://www.vivino.com",
        "firefox"
      ],
      "line": 19,
      "id": "search-for-a-wine-based-on-keyword;search-wine;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5477900,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Search Wine",
  "description": "",
  "id": "search-for-a-wine-based-on-keyword;search-wine;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@SearchWine"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Launch website http://www.vivino.com in chrome browser",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Search for \"New Wines\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "collect information of all wines",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "verify each wine data for \"New Wines\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "select a random wine",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "collect information for selected wine",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "verify selected wine data",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.vivino.com",
      "offset": 15
    },
    {
      "val": "chrome",
      "offset": 40
    }
  ],
  "location": "CommonStepDefs.launchWebsite(String,String)"
});
formatter.result({
  "duration": 7281066300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "New Wines",
      "offset": 12
    }
  ],
  "location": "CommonStepDefs.searchForKeyword(String)"
});
formatter.result({
  "duration": 3375300600,
  "status": "passed"
});
formatter.match({
  "location": "CommonStepDefs.collectInfo()"
});
formatter.result({
  "duration": 10237867600,
  "error_message": "java.lang.AssertionError: Average rating for item 1 not found. Actual: null\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failEquals(Assert.java:185)\r\n\tat org.junit.Assert.assertNotEquals(Assert.java:161)\r\n\tat stepDefinitions.CommonStepDefs.collectInfo(CommonStepDefs.java:104)\r\n\tat ✽.And collect information of all wines(SearchWine.feature:9)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "New Wines",
      "offset": 27
    }
  ],
  "location": "CommonStepDefs.verifyItemdata(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CommonStepDefs.selectItem()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CommonStepDefs.selectItemInfo()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CommonStepDefs.final_verification()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 106100,
  "status": "passed"
});
formatter.before({
  "duration": 85500,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Search Wine",
  "description": "",
  "id": "search-for-a-wine-based-on-keyword;search-wine;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@SearchWine"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Launch website http://www.vivino.com in firefox browser",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Search for \"Australian\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "collect information of all wines",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "verify each wine data for \"Australian\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "select a random wine",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "collect information for selected wine",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "verify selected wine data",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.vivino.com",
      "offset": 15
    },
    {
      "val": "firefox",
      "offset": 40
    }
  ],
  "location": "CommonStepDefs.launchWebsite(String,String)"
});
formatter.result({
  "duration": 10466575600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Australian",
      "offset": 12
    }
  ],
  "location": "CommonStepDefs.searchForKeyword(String)"
});
formatter.result({
  "duration": 521624900,
  "status": "passed"
});
formatter.match({
  "location": "CommonStepDefs.collectInfo()"
});
formatter.result({
  "duration": 4303257900,
  "error_message": "java.lang.AssertionError: Region or country for item 14 not found\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat stepDefinitions.CommonStepDefs.collectInfo(CommonStepDefs.java:102)\r\n\tat ✽.And collect information of all wines(SearchWine.feature:9)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Australian",
      "offset": 27
    }
  ],
  "location": "CommonStepDefs.verifyItemdata(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CommonStepDefs.selectItem()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CommonStepDefs.selectItemInfo()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CommonStepDefs.final_verification()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 54100,
  "status": "passed"
});
});