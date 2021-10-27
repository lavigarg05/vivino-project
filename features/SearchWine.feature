#Author: lavigarg05@gmail.com

Feature: Search for a wine based on keyword
  
	@SearchWine
  Scenario Outline: Search Wine
  	Given Launch website <website> in <browser> browser
    #When Search for <keyword>
    #And collect information of all items
    #Then verify item data for <keyword>
    #When select a random wine
    And collect information for selected item


    Examples: 
      | keyword       | website                  | browser   |
      | High rating    | http://www.vivino.com   | chrome    |

