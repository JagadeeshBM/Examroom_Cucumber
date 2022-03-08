$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/Candidate.feature");
formatter.feature({
  "name": "Candidate_Validate End to End Review process Flow for Eligibility Route 1",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Submit the only Application from Candidate",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Application"
    }
  ]
});
formatter.step({
  "name": "Candidate launch Chrome Browser",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.candidate_launch_Chrome_Browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Candidate opens URL \"https://credentiauat.examroom.ai/\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.candidate_opens_URL(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Candidate click on GetStarted button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.candidate_click_on_GetStarted_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Candidate Enters Email as \"jmcandidatems@mailinator.com\" and password as \"Exam@123\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.candidate_Enters_Email_as_and_password_as(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Candidate click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.candidate_click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Start New Application",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.click_on_Start_New_Application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Eligibility Route 1",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.click_on_Eligibility_Route(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on check box",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.click_on_check_box()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Start button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.click_on_Start_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Candidate Fill the Application Form_EnterTraining Program",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.candidate_Fill_the_Application_Form_EnterTraining_Program()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Candidate Fill the Application Form_Select Course Completion Date",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.candidate_Fill_the_Application_Form_Select_Course_Completion_Date()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select ACCOMMODATIONS as No",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.select_ACCOMMODATIONS_as_No()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Certify REGISTRANT CERTIFICATION",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.certify_REGISTRANT_CERTIFICATION()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Submit Button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.click_on_Submit_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Candidate can view confirmation message  \"Successfully Saved Response.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.candidate_can_view_confirmation_message(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve Application from Training program",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@AppApprove"
    }
  ]
});
formatter.step({
  "name": "Launch Chrome Browser",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.launch_Chrome_Browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "TP opens URL \"https://credentiauat.examroom.ai/\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.tp_opens_URL(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "TP click on GetStarted button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.tp_click_on_GetStarted_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "TP Enters Email as \"jmtrainingms1@mailinator.com\" and password as \"Exam@123\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.tp_Enters_Email_as_and_password_as(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "TP click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.tp_click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "TP click on Candidate Search",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.tp_click_on_Candidate_Search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "TP Search with candidate name",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.tp_Search_with_candidate_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "TP click on Action button for candidate",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.tp_click_on_Action_button_for_candidate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select radio button as No Changes",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.select_radio_button_as_No_Changes()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Submit Button for Approval",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.click_on_Submit_Button_for_Approval()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate Approved success message",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.validate_Approved_success_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login to candidate and validate approved status.",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.login_to_candidate_and_validate_approved_status()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Candidate should be able to Register for Exam",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegisterForExam"
    }
  ]
});
formatter.step({
  "name": "Click on Register for Exam",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.click_on_Register_for_Exam()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Candidate select Nurse Aide Written exam",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.candidate_select_Nurse_Aide_Written_exam()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select online exam radio button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.select_online_exam_radio_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select Timezone",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.select_Timezone()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select date",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.select_date()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select Range",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.select_Range()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select Avilable Slots",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.select_Avilable_Slots()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Add Cart",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.click_on_Add_Cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate Added to cart Successfully Message",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.validate_Added_to_cart_Successfully_Message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on pay now",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.click_on_pay_now()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter the card details and click on Save Card",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.enter_the_card_details_and_click_on_Save_Card()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate Card Saved Successfully message",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.validate_Card_Saved_Successfully_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on saved card radio button",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.click_on_saved_card_radio_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter CVV",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.enter_CVV()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Pay button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.click_on_Pay_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate Payment Successful message",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.validate_Payment_Successfull_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate Status should be changed to Exam scheduled in Exam Schedule Board.",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.validate_Status_shoud_be_changed_to_Exam_scheduled_in_Exam_Schedule_Board()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Dashboard and take the screen shot of it",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepCandidate.click_on_Dashboard_and_take_the_screen_shot_of_it()"
});
formatter.result({
  "status": "passed"
});
});