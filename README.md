# Hospital Management System

### _YouTube Video Link: [https://youtu.be/SwE4mxQxhEI](https://youtu.be/SwE4mxQxhEI)_

## Description-
   In this Project we aim to solve the traditional issues of hospital management. The existing system provided paper based solution for keeping OPD records of patients and hospital staff, but it gives overload to Doctor, Receptionist and Administrator.  The main issues were inappropriate data keeping, time wastage in storage, retrieval also patients were unable to understand the prescription etc. These issues are solved by providing a separate user account for doctors and other staff. Keeping each patient’s data separate and track previous visits in a single click. 
   
   This project uses MYSQL as backend and is developed in Java so it provides features such as platform independence, high performance and security. It is a web application which mainly uses SpringMVC and Hibernate frameworks. 
   
   It provides some enhanced features such as: an easy interface to add, remove employees as well as it provides PDF of prescription. Thus, reducing need to manually write  and  sign  by doctor.  <br>
  #### PPT Presentation: [click here](https://drive.google.com/file/d/1L6zUvNPXV4mYNnl2zLYyxvyz2RwoUt1G/view?usp=sharing)  <br>
  #### Project SRS: [click here](https://drive.google.com/file/d/11DQDP_ZN2h7Cq3hiIRw3pCzPhR_VCL8p/view?usp=sharing)  <br>
  #### Project Report: [click here](https://drive.google.com/file/d/128Qn3pqBFj84w6OXBSwuWXYpag_Wn0dT/view?usp=sharing)
  
## Steps to configure this HMS web-application on your system:

1. To import this project to your system, you need to first install below softwares: 
   - Eclipse for Java EE Developers and Tomcat server. You can refer this video: https://youtu.be/9iHKCnxUWqQ
   - MySQL Workbench. You can refer this video: https://youtu.be/OM4aZJW_Ojs

2. Then get the code from this GitHub repository on your system. You can clone this repository or download as zip file.

3. Choose 'import existing maven project' option in eclipse. 
<br> You can search for those steps online, just search 'how to import existing maven project in eclipse'. 

4. Then import the database files in your MySQL database. Database files are provided [here](https://github.com/rid17pawar/HospitalManagement/tree/master/databaseFiles%20and%20demoLoginCredentials/hospitaldb).
<br> You can refer this video: https://youtu.be/9icY7xwXbJo

5. You can then run this web-application on your Tomcat server. For login use the credentials provided in [this](https://github.com/rid17pawar/HospitalManagement/blob/master/databaseFiles%20and%20demoLoginCredentials/loginPasswordsForDemo.txt) file. (Select correct role and fill the Username and Password) 
<br> If you want to add more users just login as admin and choose 'add employee' option and fill all the details. It will create new employee with his own login credentials. The Aadhar no. will be the default password and Empid will be the username.

## Technologies Used-

![techStack](https://github.com/rid17pawar/HospitalManagement/assets/47048717/0b9e95e2-b3f0-41bb-b76f-75c275273389)

### 1. Front end Technologies:
  - HTML
  - CSS
  - Bootstrap
  - JavaScript
  
### 2. Back end Technologies:
  - SpringMVC 
  - Hibernate
  
### 3. Database:
  - MySQL
  
### 4. Project management tool:
  - Maven
  
### 5. Webserver:
  - Apache Tomcat
  

## Issues that proposed system overcomes-
   - It is digital system rather than paper based.
   - Inappropriate data keeping (receptionist used register for patients entry and doctor used prescription pad).
   - Time wastage in data storage and retrieval.
   - Human error possibility in maintainance.
   - Patient's were unable to understand prescriptions due to handwriting issue.
   - Durability issues (data may lost if prescriptions goes missing).


## Features-
  1. Doctor module:
      - Seperate accounts for doctors
      - Each patients previous visits history is easily to access.
      - Doctor can generate prescription and it will be automatically sent to receptionist.
      - Doctor can remove patient from OPD queue.
      
  2. Receptionist module:
      - Register/add new patient's info.
      - Modify patients personal details
      - Search existing patient by name/ mobile no./ PID/ aadhar no.
      - Remove patient from OPD queue.
      - Take print of prescriptions.
      
  3. Administrator module:
      - Add new employee for following roles,
                      i) Doctor
                     ii) Receptionist
                    iii) Admin (another one)
      - Remove/edit existing employee. 
      - Displays currently active employees in system.
      
  4. Password Encryption:
      - *_Bcrypt Encoding_* is used for password encryption. Bcrypt is a password hashing function designed by Niels Provos and David Mazières. It is based on the Blowfish cipher. Bcrypt uses adaptive hash algorithm to store password. BCrypt internally generates a random salt while encoding passwords and hence it is obvious to get different encoded results for the same string. But one common thing is that everytime it generates a String of length 60.


## Snapshots-

1. Homepage

![homepg](https://github.com/rid17pawar/HospitalManagement/assets/47048717/ed1a7bcd-a327-4703-8954-f647d405272a)

2. Login page

![loginpg](https://github.com/rid17pawar/HospitalManagement/assets/47048717/87120956-e508-4d5b-b48f-c823f5e29851)

3. Administrator Dashboard

![adminDashboard](https://github.com/rid17pawar/HospitalManagement/assets/47048717/5223bfda-cd29-40f8-aa5b-988972d529fe)

![adminAll](https://github.com/rid17pawar/HospitalManagement/assets/47048717/88587d2b-515a-4912-8b76-469b68cb167f)

4. Doctor Dashboard

![doctorObservation](https://github.com/rid17pawar/HospitalManagement/assets/47048717/00dfe2c3-8802-48e9-8de7-daa71a1a89b4)

![doctorPrescription](https://github.com/rid17pawar/HospitalManagement/assets/47048717/1ff1d095-3ed9-434d-8ed5-5d9228d489d9)

5. Receptionist Dashboard

![receptionistSearch](https://github.com/rid17pawar/HospitalManagement/assets/47048717/dcbce603-9d5a-47b7-9138-1221458f323e)

![receptionistAdd](https://github.com/rid17pawar/HospitalManagement/assets/47048717/5f987507-0510-4edc-adc2-545f69123291)

## System Diagrams

1. Usecase Diagram

![Usecase Diagram](https://github.com/rid17pawar/HospitalManagement/assets/47048717/53f12eb6-0789-42ed-8ec9-569b9895ac82)

2. Activity Diagram

![Activity Diagram](https://github.com/rid17pawar/HospitalManagement/assets/47048717/1d506cd6-4add-413f-a4cc-159a16c98760)

3. Class Diagram

![Class Diagram](https://github.com/rid17pawar/HospitalManagement/assets/47048717/1e52efac-4641-4ee0-a079-2da921c996dd)

4. Sequence Diagram

![Sequence Diagram](https://github.com/rid17pawar/HospitalManagement/assets/47048717/b0ecdef9-e21c-44d0-a9d9-6273d91e8aaf)

5. State Diagram

![State Diagram](https://github.com/rid17pawar/HospitalManagement/assets/47048717/c60747f3-ba73-4611-bc46-ce6413799cf4)

### Thank You !
