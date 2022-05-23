Feature: Login Functionality

Background: User is on Flipkart main page and mouse over on Login button
Given user open "Chrome" browser with exe 
Given user enter url as 
Given user cancle initial Login window
Given user move on Login button


@SmokeTest
Scenario: Login functionality with valid credentials
When user click on my profile
When user enter "9168313434" as username
When user enters "DDDD@123" as password
When user click on Login button
Then Applications shows profile to user

