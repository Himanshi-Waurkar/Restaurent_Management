<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Form Submission Successful</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            list-style: none;
            text-decoration: none;
            scroll-behavior: smooth;
        }

        body {
            background-color: rgba(0, 0, 0, 0.900);
            color: white;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        h2, p {
            text-align: center;
        }

        /* Add some decoration and animation */
        h2 {
            font-size: 3em;
            margin-bottom: 20px;
            color: orange;
            font-family: 'Overpass', sans-serif;
        }

        p {
            font-size: 1.5em;
            margin-top: 10px;
        }

        /* Animation */
        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        h2, p {
            animation: fadeIn 1.5s ease-in-out;
        }
    </style>
</head>
<body>
    <h2>Form Submission Successful!</h2>
    <p>Thank you for your message.</p>
</body>
</html>
