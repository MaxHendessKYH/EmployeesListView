# EmployeesListView
A program that lets you register employees and shows a list of your employees
This was one of my earlier Android Projects, where I started to learn about shared preferences, JSON, objects, adapters, listviews and validation.
You can add a new employee, your input goes through validation checks, where regex is used to check that int input fields only have numbers.
I also do empty checks on string input fields. Employees are then registered in shared preferences as a json String, making use of the GSON library to
convert objects into strings and strings into objects. In the EmployeesActivity view you can see all employees and information about them.
This data is displayed in a list view with the help of an adapter. In employee view you also have a button to delete all employees, removing them from Shared preferences.
