Feature: Candidate_Validate End to End Review process Flow for Eligibility Route 1
@ClearDB
  Scenario: Clear Application and exam from Database
    Given : Connect to DB
    When :Run cleanup query for Applications
    And :Run Cleanup query for Exams
    Then :Application should be cleared

@Application
  Scenario: Submit the only Application from Candidate
    Given Candidate launch Chrome Browser
    When Candidate opens URL "https://credentiauat.examroom.ai/"
    And Candidate click on GetStarted button
    And  Candidate Enters Email as "jmcandidatems@mailinator.com" and password as "Exam@123"
    And Candidate click on login button
    #Then Candidate can view Dashboard details
    #When Candidate click on Dashboard
    And Click on Start New Application
    And Click on Eligibility Route 1
    And click on check box
    And click on Start button
    When Candidate Fill the Application Form_EnterTraining Program
    And  Candidate Fill the Application Form_Select Course Completion Date
    And  Select ACCOMMODATIONS as No
    And  Certify REGISTRANT CERTIFICATION
    And  Click on Submit Button
    Then Candidate can view confirmation message  "Successfully Saved Response."
    #And close browser
@AppApprove
  Scenario: Approve Application from Training program
    Given TP switch to new tab in Chrome Browser
    When TP opens URL "https://credentiauat.examroom.ai/"
    And TP click on GetStarted button
    And  TP Enters Email as "jmtrainingms1@mailinator.com" and password as "Exam@123"
    And TP click on login button
    And TP click on Candidate Search
    And TP Search with candidate name
    And TP click on Action button for candidate
    And select radio button as No Changes
    And Click on Submit Button for Approval
    Then Validate Approved success message
    Then login to candidate and validate approved status.




