Feature: To validate login functionality of facebook
Scenario: To validate invalid username and invalid password
Given The should launch the chrome browser
When User should type the url
And The user should maxmize the window
And The user should type invalid username and invalid password
And The user should click the login button
Then The user should navigate to incorrect credential page