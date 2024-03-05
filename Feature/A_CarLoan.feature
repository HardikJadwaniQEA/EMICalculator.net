Feature: CarLoan

Scenario: Perform and validate the slider functions of the car loan feature
Given The user is on the emicalculator website(title:"EMI Calculator for Home Loan, Car Loan & Personal Loan in India")
When User Clicks On the Car Loan radio button
And moves the Car loan slider to the desired width
Then verify if the value attribute of the amount slider is(Amount:"15,00,000")
When User moves the interest rate slider to the desired width
Then verify if the value attribute of the interest slider is(Interest:"9.5")
When User moves the tenure slider to the desired width
Then verify if the value attribute of the tenure slider is(Tenure:"1")
 
 Scenario: Verify the function that displays the principal and interest amount for one month in EMI Advance
 Given The user scrolls down to the emi option buttons
 When User clicks on the emi advance (button:"EMI in Advance")
 And User clicks on the more button in the (year: "2024",option:1)
 Then verify that the (principal:"₹ 1,19,650") and (interest:"₹ 10,842") amounts of one month are displayed 
 
 Scenario: Verify the function that displays the principal and interest amount for one month in EMI Arrears
 Given The user scrolls up to the emi option buttons
 When User clicks on the emi arrears (button:"EMI in Arrears")
 And User clicks on the more button in the (year: "2024",option:2)
 Then verify that the (principal:"₹ 1,20,597") and (interest:"₹ 10,928") amounts of one month are displayed  