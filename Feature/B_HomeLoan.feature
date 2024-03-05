Feature: HomeLoan

Scenario: Verify the home loan page functionalities of the application

Given the user is on the home loan page of the website with (title: "Home Loan EMI Calculator with Prepayments, Taxes & Insurance")
When user scrolls down to the loan table 
Then verify that the loan table is being stored in the excel file