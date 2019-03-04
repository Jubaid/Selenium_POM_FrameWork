Feature: Spree login functionality
  This explain how verious login functionality will work
  Only valid user should be able to login
  1. Valid user with valid password can login
  2. Invalid user or invalid password can not login

	@DataSource(file=/src/test/resources/data/LoginData.xlsx)
	Scenario Outline: 1.Valid user with valid password
	  Given Not a validated user
	  When User browse to the site
	  Then Spree home page should display
	  When User click login link
	  Then Browser display Login page
	  When User enter user email as "<TCID>:=USER_EMAIL"
	  And User enter password as "<TCID>:=PASSWORD"
	  And User click login button
	  Then Home page should display
	  And Login success message display
	Examples:
	|TCID	|
	|TC001	|
	|TC002	|
	|TC003	|
	|TC004	|
	|TC005	|