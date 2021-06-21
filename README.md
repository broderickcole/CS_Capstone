# CS_Capstone
Computer Science Capstone

This is a program that users and input flight data and organize it so that it is easily readable. 

**Professional Self-Assessment:**
	Completing the coursework throughout my education has not only help me expand my knowledge in the computer science field but has also taught me patience, persistence and that there is more than one way to complete a task. Furthermore, the concepts covered in the Southern New Hampshire (SNHU) Computer Science program has prepared me for my professional career. Learning how to collaborate in a team environment is one of the most important aspects of Software development as many companies work in Teams since their objective is to deliver a product or service to a mass audience. 

During my time at SNHU, I took was Software Development Lifecyle which introduced me to what working on a Team during the Software Development lifecycle (SDLC). The main topic we discussed in the course was the different methodologies that take place in Software development such as the Agile methodology. Unlike the waterfall method, which works from the top down, Agile allows Teams to work on sprints for a project and continuously refine the artifact until the goal is met during the SDLC. This class allowed me to walk in the ‘shoes’ of each role that is on a Scrum Team, which aided in my success in the classes I took later on that used this SDLC methodology and have prepared me for my professional career. 

The Scrum Master/Team Lead ensures team coordination and supports the progress of the project between individual team members. They are responsible for software delivery and estimation times the Product Owners (stakeholders) want completed. The quality estimation provides a clear vision of the whole development process, scope of work and resources needed. 

That said, SDLC is great for peer code review, which allows programmers to expand their knowledge and help ensure that that the code is not vulnerable to attacks. Knowing that there is more than one way of doing something, such as writing a program that produces the same output, we also know there is more than one way for there to be a security breach. By having more than one set of eyes on the project, it allows for potential security flaws to be discovered since someone may approach a hack differently then you. 

In my final project, I used GitHub to make adjustments where they were needed so that I could commit and push them to the master just as a programmer would do while they were working on a team project. For the data structures and algorithms & software engineering section of my project, I created new code that allowed data that an airline would use to pull reports so that they could properly build their flight schedules where the demand is needed. This included getting the load factor of flights so that they could determine which flights were profitable along with getting rid of duplicate flight data that may have been included on accident, which would have thrown off reports. 

For the database and security part of my project, I created a remote service that can only be accessed if the users IP address is whitelisted on the server and has the correct credentials. Once users have access, they will be able to insert reports into a MongoDB that will filter out any duplicate flights so that they can later be called on to summarize reports for the Network Operations Team. The topics will be discussed more in depth in the artifact section of my paper. 

**Informal Code Review:**
[Click here](https://drive.google.com/file/d/1oZc4IMBpLZtUlXO_ty8daN8XWxCpE01d/view?usp=sharing) to view the code review  

**ePortfolio:**
[Click here](https://github.com/broderickcole/CS_Capstone) to view my GitHub repository. 

**Artifact & Narrative:**
	The artifact I have chosen to use throughout this course isn’t a project that I have done in school; rather, it is a coding assignment I was given during an interview that I didn’t do well on. I applied to be an Associate Software Engineer with Southwest Airlines and, if I’m being completely honest, I wasn’t prepared for the face-to-face interview. During my phone interview, I asked the recruiter for any tips so that I could prepare for the face-to-face interview. I was advised to just be able to talk about what I have done in school, why I want the position, and that there wouldn’t be any coding involved. I’m confident he didn’t intentionally set me up for failure and I honestly should have been more prepared, which is why I am excited that we get to pick a project of our choosing for this class. 

See, when they called to let me know I didn’t get the job, they also advised me that they didn’t hire anyone due to their Senior Software Engineers (SSE) deciding that they just not having the time to train anyone new. However, he did let me know I was the favorite of the group and that the hiring manager was so close to hiring me, but the SSE’s asked him to wait and let me reapply in June. So, with all that being said, I want to use this real-life experience for my project so when June comes, I can show how much I have improved.   

**Algorithms and Data Structure:** 
	The artifact I choose for the Algorithms and data Structure was to create a sorting method that would group flights by their aircraft ID. I created the method in week four of this course. This method will be helpful when pulling reports to analyze trends, which in return, would allow an airline to forecast seat trajectory and any promotions they would like to do. 

I originally wanted to do a has map and key for this method but decided to go with what I know, which is bubble sorting. The method calls the compareTo method that is imported in the java.util.ArrayList library to compare the aircrafts ID. It loops through the array and uses a temporary variable to hold the object whenever a swap is needed. 

After running the program and having the flights sorted by the groupByAircraftID and then printed by my printFlights method, they were all printed in their new groups, which means I successfully completed what I was intending to do. However, One of the challenges I ran into was getting the bubble sorting down. See, for the second loop in the method ( for (int j = 0; j < n - i - 1; j++) ), I had to do a lot of trail and error to get it to work correctly.

**Software Design and Engineering:**
	I have created a printNoDuplicate method during week 3 that passes in the Flight Data array of objects that was previously created. In the method, I created a new empty array list that is later used to store the flights that are not duplicates. I use a for loop to go through the Flight Data array and if the flight isn’t already seen in the new array list, it appends it to the array list. 

It is designed to get rid of the duplicate flights that may have accidently been logged. See, Airlines use this data to create reports so they can analyze the trends with flight capacities. This allows them to plan the next year’s schedule and, if they need to, they will make adjustments to maximize their fleet. If there are duplicate flights, it could throw off their reports, which would cost them money. 

**Databases:**
	For the database section of my final project, I decided to use MongoDB. MongoDB is a nonrelational database that is easily scalable compared to other databases such as SQL. Rather than having to set the number of ‘rows’ and ‘columns’, it allows the user to insert collections and doesn’t need to always have the same number of items. After much trial and error with MongoDB, I was able to establish a connection and have the code working properly. I have added code that allows me to access a collection in the database that then loops through the collection to print out the name of each document that is in the database. 

One of the challenges I was running into with my MongoDB was the authorization. The code below is what I used to start my database without requiring authorization so that I could then change the databases security settings.

	#start mongo without authentication

	/usr/local/bin/mongod_ctl start-noauth

	#or

	/usr/local/bin/mongod_ctl start

It took me numerous attempts to be able to access the database and kept having to set up a new one since I only have the free version of AWS and my Ec2 instance would run out of time. I used the code below to create an admin account for my database; by doing this, it will keep any unwanted users from accessing my data, which will help with the security aspect of my program since the data is going to be stored on a remote server. 
 
	use admin

	db.createUser(

	  {
	    user: “ColeB",
	    pwd: “BrodericksPassword”, 
	    roles: [ { role: "userAdminAnyDatabase", db: "admin" }, "readWriteAnyDatabase" ]
	  }
	)

