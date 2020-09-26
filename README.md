# Hospital Management System


### _YouTube Video Link: [https://youtu.be/SwE4mxQxhEI](https://youtu.be/SwE4mxQxhEI)_

## Description-
   In this Project we aim to solve the traditional issues of hospital management. The existing system provided paper based solution for keeping OPD records of patients and hospital staff, but it gives overload to Doctor, Receptionist and Administrator.  The main issues were inappropriate data keeping, time wastage in storage, retrieval also patients were unable to understand the prescription etc. These issues are solved by providing a separate user account for doctors and other staff. Keeping each patient’s data separate and track previous visits in a single click. 
   
   This project uses MYSQL as backend and is developed in Java so it provides features such as platform independence, high performance and security. It is a web application which mainly uses SpringMVC and Hibernate frameworks. 
   
   It provides some enhanced features such as: an easy interface to add, remove employees as well as it provides PDF of prescription. Thus, reducing need to manually write  and  sign  by doctor.

## Technologies Used-

![TechStack](https://github.com/rid17pawar/HospitalManagement/blob/master/projectReportPPT/imagesForReadMe/techStack.png)


### Front end Technologies:
  1. HTML
  2. CSS
  3. Bootstrap
  4. JavaScript
  
### Back end Technologies:
  1. SpringMVC 
  2. Hibernate
  
### Database:
  - MySQL
  
### Project management tool:
  - Maven
  
### Webserver:
  - Apache Tomcat
  

## Issues that proposed system overcomes:
   - It is digital system rather than paper based.
   - Inappropriate data keeping (receptionist used register for patients entry and doctor used prescription pad).
   - Time wastage in data storage and retrieval.
   - Human error possibility in maintainance.
   - Patient's were unable to understand prescriptions due to handwriting issue.
   - Durability issues (data may lost if prescriptions goes missing).


## Features:
  1. Doctor module-
      - Seperate accounts for doctors
      - Each patients previous visits history is easily to access.
      - Doctor can generate prescription and it will be automatically sent to receptionist.
      - Doctor can remove patient from OPD queue.
      
  2. Receptionist module-
      - Register/add new patient's info.
      - Modify patients personal details
      - Search existing patient by name/ mobile no./ PID/ aadhar no.
      - Remove patient from OPD queue.
      - Take print of prescriptions.
      
  3. Administrator module-
      - Add new employee for following roles,
                      i) Doctor
                     ii) Receptionist
                    iii) Admin (another one)
      - Remove/edit existing employee. 
      - Displays currently active employees in system.
      
  4. Password Encryption-
      - *_Bcrypt Encoding_* is used for password encryption. Bcrypt is a password hashing function designed by Niels Provos and David Mazières. It is based on the Blowfish cipher. Bcrypt uses adaptive hash algorithm to store password. BCrypt internally generates a random salt while encoding passwords and hence it is obvious to get different encoded results for the same string. But one common thing is that everytime it generates a String of length 60.


## Snapshots:

1. Homepage

![Homepage](https://github.com/rid17pawar/HospitalManagement/blob/master/projectReportPPT/imagesForReadMe/loginpg.png)


2. Login page

![Login page](https://github.com/rid17pawar/HospitalManagement/blob/master/projectReportPPT/imagesForReadMe/loginpg.png)


3. Administrator Dashboard

![Administrator Dashboard](https://github.com/rid17pawar/HospitalManagement/blob/master/projectReportPPT/imagesForReadMe/adminAll.png)


4. Doctor Dashboard

![Doctor Dashboard - patient observation](https://github.com/rid17pawar/HospitalManagement/blob/master/projectReportPPT/imagesForReadMe/doctorObservation.png)


![Doctor Dashboard - patient prescription](https://github.com/rid17pawar/HospitalManagement/blob/master/projectReportPPT/imagesForReadMe/doctorPrescription.png)


5. Receptionist Dashboard

![Receptionist Dashboard search patient](https://github.com/rid17pawar/HospitalManagement/blob/master/projectReportPPT/imagesForReadMe/receptionistSearch.png)

![Receptionist Dashboard add patient to opd](https://github.com/rid17pawar/HospitalManagement/blob/master/projectReportPPT/imagesForReadMe/receptionistAdd.png)


### Thank You !


  
