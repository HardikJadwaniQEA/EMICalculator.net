Feature: LoanAmountCalculator

Scenario: To verify the functionalities of the LoanAmount Calculator feature in LoanCalculator module
Given User Successfully navigates to the LoanCalculator page of the web application(title:"Loan Calculator — Calculate EMI, Affordability, Tenure & Interest Rate")
When user clicks on the Loan Amount Calculator button
Then Validate the EMI(Slider:1)
And Validate the EMI(Unit:"₹",option:1)
And Validate the EMI(scale:-1,1,-1)
And Validate the InterestRate(Slider:2)
And Validate the InterestRate(Unit:"%",option:2)
And Validate the InterestRate(scale:-1,2,-1)
And Validate the LoanTenure(Slider:2)
And Validate the LoanTenure(scale:-1,3,-1)
And Validate the Fees&Charges(Slider:2)
And Validate the Fees&Charges(Unit:"₹",option:2)
And Validate the Fees&Charges(scale:-1,4,-1)
