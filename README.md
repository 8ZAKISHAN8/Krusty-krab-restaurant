# Krusty Krab Digital Kiosk
**A Full-Stack Java Ordering System with MySQL Integration**
Welcome to the **Krusty Krab Digital Kiosk**, a high-performance desktop
ordering system designed for Bikini Bottom's favorite eatery. This project
demonstrates advanced Java Swing UI design, relational database management, and
object-oriented logic.



## How to Run
Since this project is in the development environment and does not have a
standalone desktop shortcut:
1. **Prepare Database:** Import the `krusty_krab_database.sql` file into your
MySQL server (using MySQL Workbench or Command Line).
2. **Open Project:** Open the project folder in **Apache NetBeans**.
3. **Configure Connection:** Ensure `DatabaseConnection.java` has your correct
MySQL username and password.
4. **The Entry Point:** Navigate to the `restaurant` package, right-click on
**`Mainjava.java`**, and select **Run File**.
## Features
- **Dynamic Ordering:** Choose between Krabby Patty sizes (Small, Medium, Large)
with real-time price updates.
- **Combo Logic:** Automated 20% discount applied when selecting the "Make it a
Combo" option.
- **Loyalty System:** Tracks and updates customer loyalty points directly in the
MySQL database.

- **Service Flexibility:** Supports Dine-In, Take Away, and Delivery (Squidward-
approved!).

- **Digital Receipt:** Automated tax calculation and order summary generation.
## Technical Stack
- **Frontend:** Java Swing (GUI)
- **Backend:** Java (JDK 8+)
- **Database:** MySQL
- **Driver:** MySQL Connector J 9.5.0

Krusty Krab Digital Kiosk - Portfolio Ready

## Key Files
- `Mainjava.java`: The primary **startup file** and home screen.
- `DatabaseConnection.java`: Logic for MySQL handshake.
- `krusty_krab_database.sql`: The database schema and table definitions.
---
*Developed by Karim Mohamed Zaki and Team.*
