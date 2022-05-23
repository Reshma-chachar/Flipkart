Feature: Manage Addresses Functionality

Background: User is on Flipkart main page and mouse over on Login button
Given user open "Chrome" browser with exe 
Given user enter url as 
Given user cancle initial Login window
Given user move on Login button
Given user click on my profile
Given user enter "9168313434" as username
Given user enters "DDDD@1234" as password
Given user click on Login button


@RegressionTest
Scenario: Manage addresses functionality with valid data
When user click on manage addresses
When user click on Add a new address
When user enter "abc" as name
When user enter "9309146478" as mobile number
When user enter "414111" as pincode
When user enter "midc" as locality
When user enter "navnagapur" as address
When user select Home as address type
When user click on save button
Then application shows new address added successfully
