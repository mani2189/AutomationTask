Feature: Registration

   #TC-1
   Scenario: Successfull Cookie Validation
    When User opens the URL "https://finanzen.check24.de/accounts/d/kreditkarte/result.html"
    And User performs the cookie validation
   
   #TC-2
   Scenario: Successfull Page navigation after filling email id 
   When User Enters the emailaddress
   Then User get navigated to next Registerationpage successfully
   
    
    #TC-3
   Scenario: Successfull Page navigation after clicking on the registration radio button
   When User click on the Registration radio button
   Then User get navigated to next personalinfopage successfully
   
    #TC-4
   Scenario: Successfull Error messages validation
   When User click on submit button without form data
   Then Validate the empty fields are shown with error message
  
   #TC-5
   Scenario: Successfull Submission of the form
   When User click on submit button with valid formdata
   Then User navigated to the next form page
