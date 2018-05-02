@Feature
Feature: Alchemy main page validations

Scenario Outline: This scenario validates the Login functionality
	Given open ApplicationUrl
	When Login to Website with "<UserName>" and "<Password>"
	Then Validate Login is "<LoginStatus>"
	And Logout of the Website "<LoginStatus>"
Examples:
| 			UserName 				 | 			Password 				  | 			LoginStatus 				|
| LoginPage.TestCase_1.UserName      | LoginPage.TestCase_1.Password      | 	LoginPage.TestCase_1.LoginStatus	|
| LoginPage.TestCase_2.UserName      | LoginPage.TestCase_2.Password      | 	LoginPage.TestCase_2.LoginStatus 	|
