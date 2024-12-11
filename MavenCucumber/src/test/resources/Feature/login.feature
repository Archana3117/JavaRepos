Feature: User Login  
  As a user, I want to log in to the application so that I can access my account.  

    Background:
    Given The user navigates to the login page 
    And Clicks the login button 
     
  Scenario Outline: Successful login with valid credentials  
  
   
    When The user enters valid email "<username>"
    And Enter valid password "<password>"
    Then The user should be redirected to the dashboard  
    
    Examples:
     |username|password|
     |user1|pass123|
     |user2|pass245|
     |user3|pss111|
    

 Scenario: Login attempt with invalid credentials  
   
    When The user enters invalid email "ravilella@gmail.com"
    And Enter valid password "ravi123456"
    Then An error message Invalid username or password should be displayed  

  Scenario: Login with invalid user and invalid password credentials  
   
    When The user enters invalid email "ravilella@gmail.com"
    And Enter invalid password "ravi123456"
    Then user should get proper warning message

  Scenario: Login with valid user and invalid password credentials  
  
    
    When The user enters valid email "ravilella@gmail.com" 
    And Enter invalid password "ravi123456"
    Then user should get proper warning message
    
    
   
  	