Feature: Navigation
	
	Scenario: The user can try the navigation examples
		Given I am at the home page
		When I touch the "Page navigation via row." text
		Then I should see "Hello World"
	
		When I go back
		Then I am at the home page
		
		
