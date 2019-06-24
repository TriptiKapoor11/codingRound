# TestVagrant hiring challenge for applicants 

About the codebase:
---------------------------------
*This is a simple test project for testing a few scenarios on a sample flight/hotel booking website. There are **3 tests** in total spread over 3 test classes. Following tech stack has been used to develop the same.*

**Tech Stack:** *Java*  *Selenium* *TestNG*  *Gradle/Maven*

**The parameters of evaluation**
----------------------------------
1. Naming Conventions & readability of code
2. Modularization & Abstraction
3. Demonstration of OO concepts & Design Patterns
4. Etiquette of Version control

Problem Statement
----------------------------------
**Tasks:**

1. Test are failing which needs your expertise to fix it.
2. Review and point out design issues with the current codebase/framework, if any.
3. Improve/refactor the code to implement your suggestions.

**Expectation:**
1. Create a GitHub account if not existing already.
2. Fork this repo (DO NOT CLONE).
3. Fix the errors and refactor the code, consider **abstractions, reusability and maintenance.**
4. Make sure you make multiple check-ins in the process, we would love to see your progress bit by bit.
5. Also check-in a separate file where you should list all your code review comments.
6. Send us the link of your GitHub repo to **careers@testvagrant.com**. Also attach your **resume**.


**Review Comments,Resolution and Refactoring of Code & Future Implementations**

**Review Comments:

No Design pattern was followed, duplicate methods were used, initialization code was written repeatedly. 
Explicit Waits were not implemented,For hitting the url code was repeated in all the tests classes

**Resolution & Refactoring:

1. I have used POM Design pattern with Page factory using Maven as a build management tool.
Page factory is a class that has static method called initElements that will initialize all the Web Elements of page class without 
having to use FindElement or FindElements

2. As per POM i have maintained a class for every web page(SignInPage, HotelBookingPage, FLightBookingPage),
Each web page has a separate class that holds the functionality, locators and members of the web page.

3. Separate test related classes comes under tests (SignInPageTest, HotelBookingPageTest, FlightBookingPageTest)

4. I have used TestBase class in which initialization is done in set up method ,tear down method is implemented

5. I have used ConfigPropertyFile, this file contains information that is static throughout the framework,such as browser information, url 

6. I have captured Screenshots of the tests and that will be stored in Screenshots folder.

7. I have disabled the chrome notifications options

8. Implemented Explicit Waits

**Future Enhancements:

Implementation of  extent reporting with klov and mongodb so that history of the reports is maintained
Implementation of logger class and capture logs
Implementation of screenshots of only failed test cases
Implementation of retry on failure mechanism



