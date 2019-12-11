<h3>Server architecture: </h3>
<ul>
  <li>Controller</li>
  <li>Service</li>
  <li>Repository</li>
 </ul>
 
<b> Repository and Service uses only entities from domain. </b> <br>
<b> Controller receives and send to the client only DTOs. </b> <br> 
The conversion from entity to DTO and vice versa can be done in controller using mappers. <br>
<br>
Throw an exception when something wents wrong, catch it in TopController and send it to the client as a HTTP error code. <br>
<b>Never push to master.</b> Create a new branch (named like the task) when you start developing a task. When you finish, pull the changes from master, then push the new branch and create a Pull Request. <br>
<br>
<i>Note: The initial commit uses PostgreSQL database. If you want other DB you must update your application.properties and gradle imports. </i> <br>
<b> Never commit the <i>application.properties</i> file ! </b>
