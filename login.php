<!DOCTYPE html>
<html>

<body>


    <h1>Login</h1>
    <form action="login.php" method="post">

      Username:
        <input name="username" />
      </br>
    </br>
        Password:
        <input name="password" />
      </br>
    </br>
        <input type="submit" value ="Login" />


        <?php
        if(isset($_POST["username"]) && isset($_POST["password"]))
        {
          $username = $_POST["username"];
          $password = $_POST["password"];
          if(preg_match('/^cbu/', $password) && strlen($password) >3 && preg_match('/.$/', $password) && preg_match('/[0-9]/', $password))
          {
            header("Location: aboutme.php");
          }
        }



        ?>



</br>


</body>

</html>
