# Library-Management-System

## Overview
The **Library Management System** is a web-based application developed using **Spring Boot, Thymeleaf, and MySQL**. It allows users to manage books by adding, updating, searching, and deleting them.

## Features
- 📌 **Add New Book**  
- 🔍 **Search Book by ID & Title**  
- 📖 **View Book Details**  
- ✏️ **Edit Book Information**  
- ❌ **Delete Book**  
- 📃 **List All Books**  

## Technologies Used
- **Backend:** Spring Boot (Spring MVC, Spring Data JPA)  
- **Frontend:** Thymeleaf, HTML, CSS  
- **Database:** MySQL  
- **Tools:** Spring Tool Suite (STS), MySQL Workbench  

## Setup Instructions
### Prerequisites
- Install **Java JDK (11 or higher)**
- Install **Spring Tool Suite (STS)**
- Install **MySQL Database**
- Configure MySQL with a database named `library_db`

### Steps to Run the Project
1. **Clone the Repository**  
   ```sh
   git clone https://github.com/your-repo/library-management-system.git
   cd library-management-system
   ```

2. **Configure Database**  
   - Open `application.properties`
   - Update MySQL credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/library_db
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Run the Application**  
   - Open **Spring Tool Suite (STS)**  
   - Import the project  
   - Run `LibraryManagementSystemApplication.java`  
   - Open **`http://localhost:8080/`** in a browser

## Endpoints
| URL | Description |
|------|-------------|
| `/` | Home Page |
| `/books/list` | View All Books |
| `/books/add` | Add a New Book |
| `/books/details/{id}` | View Book Details |
| `/books/edit/{id}` | Edit Book Information |
| `/books/delete/{id}` | Delete a Book |
| `/books/searchById?bookId=1` | Search Book by ID |
| `/books/searchByTitle?title=Java` | Search Book by Title |

## Future Enhancements
- 📊 **User Authentication (Login/Signup)**  
- 📅 **Book Borrowing & Return System**  
- 📦 **API Support for External Integration**  

## Contributors
👤 S.Niharika, K.Harika  
📧 surampudiniharika@gmail.com  
📂 GitHub:https://github.com/NiharikaSurampudi

