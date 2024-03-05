Feature: EMICalculator

Scenario: To verify the functionalities of the EMI Calculator feature in LoanCalculator module
Given User Successfully navigates to the LoanCalculator page of the web application(title:"Loan Calculator — Calculate EMI, Affordability, Tenure & Interest Rate")
When user clicks on the EMI Calculator button
Then Validate the LoanAmount(Slider:1)
And Validate the LoanAmount(Unit:"₹",option:1)
And Validate the LoanAmount(scale:0,-1,-1)
And Validate the InterestRate(Slider:1)
And Validate the InterestRate(Unit:"%",option:1)
And Validate the InterestRate(scale:2,-1,-1)
And Validate the LoanTenure(Slider:1)
And Validate the LoanTenure(scale:3,-1,-1)
And Validate the Fees&Charges(Slider:1)
And Validate the Fees&Charges(Unit:"₹",option:1)
And Validate the Fees&Charges(scale:4,-1,-1)
