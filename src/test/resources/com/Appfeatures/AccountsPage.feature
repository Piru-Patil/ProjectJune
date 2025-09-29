Feature: Account page feature

Background: 
Given user has already logged in to application
|username|password|
|piragoudasp@gmail.com| King@18|

Scenario: Account page title
Given User is on Accounts page
When user gets the title of the page
Then page title should be "My account - My Shop"

Scenario: Account section count
Given User is on Accounts page
Then user gets the accounts section
|ADD MY FIRST ADDRESS|
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
| Home|
And Account section count shoud be 6