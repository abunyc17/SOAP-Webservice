# SOAP-Webservice
Intern task to create a SOAP web service(NYSC) | by Mr Wizdom August 2019
create a SOAP web service with 2 endpoints
1) create a user and 2) to fetch a user

Requirements for creating a user
1) collect the firstname, middlename, lastname, phoneNo, email, date of birth.
2) firstname, lastname and phoneNo are compulsory.
3) firstname, middlename, lastname, username should be on a separate table from phoneNo,, email, date of birth
4) username is a concatenation of firstname and lastname with hyphen separating them
5) call a database procedure to create the user

Requirements to fetch a user
1) collect search criteria
2) fetch ALL user's details when any of the following is used as the search criteria : email, phoneNo, username.

NOTE: *all your xml request and response when using SOAP UI to test should be in capital letters and underscore should separate names
e.g 
<pre>
&ltREQUEST&gt
  &ltFIRST_NAME&gtAbubakar&lt/FIRST_NAME&gt
  &ltEMAIL&gtsample string 1&lt/EMAIL&gt
&lt/REQUEST&gt
</pre>
