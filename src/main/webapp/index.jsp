<!DOCTYPE html>
<html>
<head>
    <title>Smart Aid Eligibility Checker</title>
    <style>
        body {
            font-family: Arial;
            background: linear-gradient(to right, #36d1dc, #5b86e5);
            text-align: center;
        }

        .container {
            background: white;
            padding: 20px;
            margin: 80px auto;
            width: 300px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px gray;
        }

        input {
            width: 90%;
            padding: 8px;
            margin: 5px;
        }

        button {
            background: #5b86e5;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
        }

        button:hover {
            background: #36d1dc;
        }
    </style>
</head>

<body>

<div class="container">
    <h2>Smart Aid Checker</h2>

    <form action="check" method="post">
        <input type="text" name="name" placeholder="Name" required><br>
        <input type="number" name="age" placeholder="Age" required><br>
        <input type="number" name="income" placeholder="Income" required><br>
        <input type="text" name="category" placeholder="Category"><br>

        <button type="submit">Check Eligibility</button>
    </form>
</div>

</body>
</html>