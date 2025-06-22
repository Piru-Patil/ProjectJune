Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Shop"

Scenario: Forgot Password Link
Given user is on login page
Then forgot password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "piragoudasp@gmail.com"
And user enters password "King@18"
And user clicks on login button

#Same step definition as line no 5 and 6 for below scenarios( reusable)

Then user gets the title of the page
And page title should be "My account - My Shop"