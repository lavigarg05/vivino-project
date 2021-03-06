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
        "California",
        "http://www.vivino.com",
        "chrome"
      ],
      "line": 18,
      "id": "search-for-a-wine-based-on-keyword;search-wine;;2"
    },
    {
      "cells": [
        "All Wines",
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
  "duration": 4267000,
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
  "name": "Search for \"California\"",
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
  "name": "verify each wine data for \"California\"",
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
  "duration": 8694129500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "California",
      "offset": 12
    }
  ],
  "location": "CommonStepDefs.searchForKeyword(String)"
});
formatter.result({
  "duration": 4532111500,
  "status": "passed"
});
formatter.match({
  "location": "CommonStepDefs.collectInfo()"
});
formatter.result({
  "duration": 5343961500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "California",
      "offset": 27
    }
  ],
  "location": "CommonStepDefs.verifyItemdata(String)"
});
formatter.result({
  "duration": 9816800,
  "status": "passed"
});
formatter.match({
  "location": "CommonStepDefs.selectItem()"
});
formatter.result({
  "duration": 143309200,
  "status": "passed"
});
formatter.match({
  "location": "CommonStepDefs.selectItemInfo()"
});
formatter.result({
  "duration": 4103940200,
  "status": "passed"
});
formatter.match({
  "location": "CommonStepDefs.final_verification()"
});
formatter.result({
  "duration": 5292800,
  "status": "passed"
});
formatter.after({
  "duration": 874042300,
  "error_message": "java.lang.AssertionError: The following asserts failed:\nRating count mismatch (actual) 3375 ratings (expected) 3369 ratings\r\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:38)\r\n\tat stepDefinitions.CommonStepDefs.After(CommonStepDefs.java:48)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runAfterHooks(Runtime.java:206)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:46)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ExamplesRunner.run(ExamplesRunner.java:59)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ScenarioOutlineRunner.run(ScenarioOutlineRunner.java:53)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:89)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:41)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:542)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:770)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:464)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:210)\r\n",
  "status": "failed"
});
formatter.before({
  "duration": 90100,
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
  "name": "Search for \"All Wines\"",
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
  "name": "verify each wine data for \"All Wines\"",
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
  "duration": 10878219200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "All Wines",
      "offset": 12
    }
  ],
  "location": "CommonStepDefs.searchForKeyword(String)"
});
formatter.result({
  "duration": 462373300,
  "status": "passed"
});
formatter.match({
  "location": "CommonStepDefs.collectInfo()"
});
formatter.result({
  "duration": 13626668000,
  "error_message": "java.lang.AssertionError: Average rating for item 1 not found. Actual: null\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failEquals(Assert.java:185)\r\n\tat org.junit.Assert.assertNotEquals(Assert.java:161)\r\n\tat stepDefinitions.CommonStepDefs.collectInfo(CommonStepDefs.java:109)\r\n\tat ???.And collect information of all wines(SearchWine.feature:9)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "All Wines",
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
  "duration": 1506499600,
  "status": "passed"
});
});