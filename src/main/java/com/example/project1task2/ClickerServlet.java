package com.example.project1task2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

/*Explanation:
* Author: Aditi Gupta - argupta
* Last Modified: September 22, 2023
This is a Java Servlet (ClickerServlet) that handles user voting and result retrieval for a simple clicker application.
The servlet is mapped to two URL patterns: "/submit" and "/getResults."
The ClickerModel instance is created to handle the underlying business logic of recording votes and managing results.
The doGet method is invoked when a client sends an HTTP GET request to the servlet.
It retrieves the "option" parameter from the request, which represents the user's vote choice.
If no option is selected (option is null), it redirects the user back to the index page (/index.jsp).
If an option is selected, it records the user's vote using the ClickerModel and forwards the request to the "submit.jsp" view, displaying the selected option.
If the request is for getting results (/getResults), it retrieves the voting results from the ClickerModel, sets them as an attribute for the "result.jsp" view, and then clears the results in the model to start fresh.
If the request is not for getting results, it redirects the user back to the index page.*/
@WebServlet(name = "ClickerServlet", urlPatterns = {"/submit", "/getResults"})
public class ClickerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ClickerModel clickerModel = new ClickerModel();

    // This method handles HTTP GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");

        // Code to not register a vote if no answer is selected
        if (option == null) {
            // If no option is selected, redirect back to the index page
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        // Record the user's vote using the ClickerModel
        clickerModel.recordVote(option);

        // Set the selected option as an attribute for the view
        request.setAttribute("option", option);

        // Forward the request to the "submit.jsp" view
        request.getRequestDispatcher("/submit.jsp").forward(request, response);

        // Check if the request is for getting results
        if (request.getServletPath().equals("/getResults")) {
            // Get the voting results from the ClickerModel
            Map<String, Integer> results = clickerModel.getResults();

            // Set the results as an attribute for the view
            request.setAttribute("results", results);

            // Forward the request to the "result.jsp" view
            request.getRequestDispatcher("/result.jsp").forward(request, response);

            // Clear the results in the ClickerModel after displaying them
            clickerModel.clearResults();
        } else {
            // If it's not a request for getting results, redirect back to the index page
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
