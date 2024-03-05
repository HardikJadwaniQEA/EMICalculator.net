Feature: LoanTenureCalculator

Scenario: To verify the functionalities of the LoanTenure Calculator feature in LoanCalculator module
Given User Successfully navigates to the LoanCalculator page of the web application(title:"Loan Calculator — Calculate EMI, Affordability, Tenure & Interest Rate")
When user clicks on the Loan Tenure Calculator button
Then Validate the LoanAmount(Slider:2)
And Validate the LoanAmount(Unit:"₹",option:2)
And Validate the LoanAmount(scale:-1,1,0)
And Validate the EMI(Unit:"₹",option:1)
And Validate the EMI(scale:-1,-1,1)
And Validate the InterestRate(Slider:2)
And Validate the InterestRate(Unit:"%",option:2)
And Validate the InterestRate(scale:-1,-1,2)
And Validate the Fees&Charges(Slider:3)
And Validate the EMI(Slider:2)
And Validate the Fees&Charges(Unit:"₹",option:3)
And Validate the Fees&Charges(scale:-1,-1,4)