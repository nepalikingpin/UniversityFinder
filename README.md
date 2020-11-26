# University Finder

## *Find the perfect university for you based on your interests, major choice, and location!*

The applications intends to help high school and university students find the perfect university for them.

**The problem with the current system**
- Current university finder applications only focus on the intended major, location and the cost of attending.
- These applications can be hard to use, and contain redundant information.
- It is difficult to find a university based on your extracurricular interests (eg. Soccer, E-sports).

**How does this application solve the problem**
- This application takes into account student's interests while suggesting them university. 
- The universities suggested to students will always rank in the order of interests, while also accounting for 
world rankings and cost. 

The application will likely be used by high school students looking for their dream university, and by university 
students looking to transfer from their current university.

**Personal Interest**
- While I was looking for a good university to study abroad a couple of years ago, I struggled with this problem.
- Coming from a conservative East Indian family, academic performance and world rankings were always a bigger priority 
for my parents when compared to extracurricular interests. I want to build this platform so that students can find a 
highly ranked university that also satisfies their extracurricular interests.

**User Stories**
- As a user, I want to be able to add my interests, major choice and location for finding a university 
and add to my choices. I want to do this interactively by selecting options on the GUI panel.
- As a user, I want to be able to view the all universities in the database. I want these universities to be displayed
in a pop up message.
- As a user, I want to be able to get the website / full information page link of the recommended universities.
- As a user, I want to be able to view the top universities recommended for me based on my choices. I want
this information to be displayed as a pop up message.
- As a user, I want to be able to save the universities recommended for me, to a file. I want to be able to do this
interactively, by clicking a button after I am finished selecting these universities.
- As a user, I want to be able to load the recommended universities from the file. I want to be able to do this 
interactively, by clicking a button as soon as the program starts. 

**Phase 4: Task 2**
- Made the SuggestUniversity class robust. 
- There are no requires clauses, and a check exception (NoSuggestionsException) gets thrown when no universities that
adhere to the user's choices are found.

**Phase 4: Task 3**
- The design is good for the model and persistence package. There is high cohesion, low coupling and minimal code 
duplication. 
- The design for ui is not great, because the entire GUI is handled by the console class, this could be refactored
to make multiple classes to improve readability. 
- If I had more time, I would have refactored the Console class in ui. I would have made different classes for different 
functionalities, instead of creating a lot of methods within the same class. This would have significantly increased the 
readability of the code.
