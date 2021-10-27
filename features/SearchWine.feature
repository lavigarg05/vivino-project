#Author: lavigarg05@gmail.com

Feature: Search for a wine based on keyword
  
	@SearchWine
  Scenario Outline: Search Wine
  	Given Launch website <website> in <browser> browser
    When Search for "<keyword>"
    And collect information of all wines
    Then verify each wine data for "<keyword>"
    When select a random wine
    And collect information for selected wine
    Then verify selected wine data


    Examples: 
      | keyword         | website                  | browser   |
      #| California      | http://www.vivino.com    | chrome    |
      | California      | http://www.vivino.com    | firefox   |

