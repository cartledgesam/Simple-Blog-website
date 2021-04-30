<!DOCTYPE html>
<html>

  <style type="text/css">
  #topmenu{
    border: 3px solid blue;
    padding: 0.5em;
    background-color: blue;
    margin-bottom: 10px;
    clear: none;

  }
  h1{
    text-align: right;
  }
  #ooo{

    text-align: right;
  }

  #music{
    border: 3px dotted red;
    padding: 0.5em;
    background-color: lavender;
    overflow: auto;
    padding-top: 1px;
    margin-top: -1px;
    clear: none;

  }
  #music2{
    border: 3px solid green;
    padding: 0.5em;
    background-color: lightslategray;
    overflow: auto;
    padding-top: 1px;
    margin-top: 10px;
    clear: none;

  }

  #first{
    border: 3px solid blue;
    padding: 0.5em;
    background-color: yellow;
    overflow: auto;
    padding-top: 1px;
    margin-top: 10px;
    clear: none;

  }
  #second{
    border: 3px dotted blue;
    padding: 0.5em;
    background-color: pink;
    overflow: auto;
    padding-top: 1px;
    margin-top: 10px;


  }
  #third{
    border: 3px dashed black;
    padding: 0.5em;
    background-color: orange;
    overflow: auto;
    padding-top: 1px;
    margin-top: 10px;


  }
  #fourth{
    border: 3px solid red;
    padding: 0.5em;
    background-color: pink;
    overflow: auto;
    padding-top: 1px;
    margin-top: 10px;
    clear: none;


  }
  #fifth{
    border: 3px solid black;
    padding: 0.5em;
    background-color: orange;
    overflow: auto;
    padding-top: 1px;
    margin-top: 10px;
  }


  .image1{
    width: 250px;
    height: 150px;
    float:right;
  }
  .image2{
    width: 300px;
    height: 150px;
    float:right;
  }
  .image3{
    width: 300px;
    height: 150px;
    float:right;
    padding-right: 10px;
  }
  .image3{
    width: 300px;
    height: 150px;
    float: right;
    padding-right: 10px;
  }
  .image4{
    width: 300px;
    height: 150px;
    float: left;
    padding-right: 10px;
  }
  .space{
    margin-left: 30px;

  }
  #bottommenu{
    background-color: grey;
    position: fixed;
    bottom: 0;
    left: 0;
    right: 0;
    margin: 0 auto;

  }
  #bottommenu-wrapper{
    height: 100%;
  }
  #sidediv{
    width: 15%;
    height: 100%;
    float: left;
    font-size: x-large;
    background-color: grey;
    overflow: hidden;
    margin-right: 10px;

  }

  #content{
    width:84%;
    height: 100%;
    float: right;
    margin-bottom: 100px;
    position: relative;
  }




  </style>

<body>
  <title>My Blog</title>
 <div id="topmenu">
  <h1>My Blog</h1>
  <p id="ooo">Because I need to share my thoughts to random people<p>

<hr/>
</div>


<div id="sidediv">
  <?php include "side_menu.html"; ?>
</div>
<div id="content">
  <div id="music">
     <h2><u>3/11/2012- Music Musik Musico Musica Musickcoca</u></h2>
       <p style="color:#8b0000"> My favorite music: </p>
       <form action="blog.php">
  <div>
      Search for title:
        <input name="title" />
        <input type="submit" value ="Search" />
        <?php
        if(isset($_GET["title"]))
        {
            $searchTitle = $_GET["title"];

        }
           ?>
           <p><a href="blog.php?sort=TRUE">Sort by song title</a>

             <a class="space" href="blog.php?sort=FALSE">Unsorted</a></p>
             <?php
              if(isset($_GET["sort"]))
              {
                $doSort= $_GET["sort"];
              }

               function printSongs($searchTitle="", $doSort="FALSE")
               { ?>
                 <ol type="i">
                 <?php

                  if($searchTitle=="")
                {
                  foreach (file("songs.txt") as $book)
                  {
                      list($title, $author, $link) = explode(",", $book);


                      ?>
                      <li><p><a href="<?= $link ?>"><?= $title ?> by <?= $author ?></a></p></li>
                        <?php

                    }
                  }else
                  {
                    foreach (file("songs.txt") as $book)
                    {
                      list($title, $author, $link) = explode(",", $book);

                        if(stristr($book, $searchTitle) !==false){
                          ?>
                          <li><p><a href="<?= $link ?>"><?= $title ?> by <?= $author ?></a></p></li>
                            <?php
                        }


                    }
                   }
                   ?>
                 </ol> <?php

               }
                if(isset($searchTitle))
                {
                   printSongs($searchTitle);
                }
                if(isset($doSort))
                {
                  if($doSort == "TRUE")
                  {
                    echo "<p><b>My List in Sorted Order: </b></p> ";
                  ?> <ol type="i"> <?php
                    $array = array();
                    foreach (file("songs.txt") as $book)
                     {

                      array_push($array, $book);

                    }
                    sort($array);
                    for($i = 0; $i < count($array); $i++)
                    {
                      list($title, $author, $link) = explode(",", $array[$i]);
                      ?>
                      <li><p><a href="<?= $link ?>"><?= $title ?> by <?= $author ?></a></p></li>
                        <?php
                    }
                  ?> </ol> <?php

                  }
                  if($doSort == "FALSE")
                  {
                    ?> <ol type="i"> <?php
                      foreach (file("songs.txt") as $book)
                       {
                        list($title, $author, $link) = explode(",", $book);
                        ?>
                        <li><p><a href="<?= $link ?>"><?= $title ?> by <?= $author ?></a></p></li>
                          <?php
                      }
                       }


                }

                ?>
  </div>
      </form>
  </div>
  <div id="music2">
     <h2><u>3/14/2012- Music Musik Musico Musica Musickcoca 2</u></h2>
       <p style="color:#8b0000"> My favorite music: </p>
       <form action="blog.php">
  <div>
      Search for title:
        <input name="title2" />
        <input type="checkbox" name="sorted" />Sort?
        <input type="submit" value ="Search" />
        <?php
        $sort = FALSE;
        if(isset($_GET["title2"]))
        {
            $searchTitle2 = $_GET["title2"];
        }
        if(isset($_GET["sorted"]))
        {
          $sort = TRUE;
        }
               function printSongs2($searchTitle2, $sort)
               { ?>
                 <ol type="i">
                 <?php
                  if($searchTitle2=="" && $sort==FALSE)
                {
                  foreach (file("songs.txt") as $book)
                  {
                      list($title, $author, $link) = explode(",", $book);
                      ?>
                      <li><p><a href="<?= $link ?>"><?= $title ?> by <?= $author ?></a></p></li>
                        <?php
                    }
                  }if($sort==TRUE && $searchTitle2 !="")
                  {
                      echo "<p><b>My List in Sorted Order: </b></p> ";
                    ?> <ol type="i"> <?php
                      $array2 = array();
                      foreach (file("songs.txt") as $book)
                       {
                        array_push($array2, $book);
                      }
                      sort($array2);

                      for($i = 0; $i < count($array2); $i++)
                      {
                      list($title, $author, $link) = explode(",", $array2[$i]);

                        if(stristr($array2[$i], $searchTitle2) !==false){
                          ?>
                          <li><p><a href="<?= $link ?>"><?= $title ?> by <?= $author ?></a></p></li>
                            <?php
                        }
                      }
                   } if($searchTitle2 !="" && $sort==FALSE)
                   {
                     ?> <ol type="i"> <?php
                       $array2 = array();
                       foreach (file("songs.txt") as $book)
                        {
                         array_push($array2, $book);
                       }
                       for($i = 0; $i < count($array2); $i++)
                       {
                       list($title, $author, $link) = explode(",", $array2[$i]);

                         if(stristr($array2[$i], $searchTitle2) !==false){
                           ?>
                           <li><p><a href="<?= $link ?>"><?= $title ?> by <?= $author ?></a></p></li>
                             <?php
                         }
                       }
                   }
                   if($searchTitle2=="" && $sort==TRUE)
                   {
                     echo "<p><b>My List in Sorted Order: </b></p> ";
                   ?> <ol type="i"> <?php
                     $array2 = array();
                     foreach (file("songs.txt") as $book)
                      {
                       array_push($array2, $book);
                     }
                     sort($array2);

                     for($i = 0; $i < count($array2); $i++)
                     {
                     list($title, $author, $link) = explode(",", $array2[$i]);
                         ?>
                         <li><p><a href="<?= $link ?>"><?= $title ?> by <?= $author ?></a></p></li>
                           <?php
                     }
                   }
                   ?>
                 </ol> <?php
               }
                if(isset($searchTitle2))
                {
                   printSongs2($searchTitle2, $sort);
                }
                ?>
  </div>
      </form>
      <form action = "blog.php" method="post">
        <textarea name="textarea"
        rows="10" cols="100"
        placeholder="Enter new song in this format: Title, Artist, Youtube Link"></textarea>
        <input type="submit" value="Enter" />
        <?php
        $text="";

        if($_POST && !empty($_POST['textarea']))
        {
          $text = $_POST['textarea'];
          $text= $text . "\n";
          file_put_contents("songs.txt", $text, FILE_APPEND);
          header("Refresh:0; url=blog.php");
        }

        ?>
      </form>
      <form action="blog.php">
        <div>
	          Title: <input name="title" minlength="1" />
	          Artist: <input name="artist" minlength="1" />
	          Link: <input name="link"  minlength="1" />

	                <input type="submit" name="add" value="Add New Song" />
                </div>
                <?php
                if(isset($_GET["add"]))
                {
                  $title = $_GET["title"];
                  $artist = $_GET["artist"];
                  $link = $_GET["link"];
                  if(preg_match('/youtube/', $link) && strlen($title) > 1 && strlen($artist)>1)
                  {
                    $text = $title. ", ".$artist.", ".$link."\n";
                    file_put_contents("songs.txt", $text, FILE_APPEND);
                  }else if(strlen($title) < 1)
                  {
                    echo"<p>Title not Correct</p>";
                  }
                  else if(strlen($artist) < 1)
                  {
                    echo"<p>Artist not Correct</p>";
                  }else
                  {
                    echo"<p>Link not Correct</p>";
                  }
                }

                 ?>
              </form>

  </div>
<div id="first">
   <h2><u>2/22/2021- "Great Scott!"</u></h2>
     <p> <img src="https://bulletproofautomotive.com/wp-content/uploads/2641356870_54e01957bb_b.jpg" alt="Stanced Delorean" class="image1" />
       Learned that people have done Deloreans in Boso Style, I'll take it <br> Stanced Delorean or stanced 250 TR? </p>

</div>


<div id="second">
  <h2><u>3/23/2021- "Drop it low"</u></h2>
  <p> <img src="https://www.tuningblog.eu/wp-content/uploads/2020/08/Slammed-Ferrari-Testarossa-Camber-Tuning-Airride-Header.jpg" alt="Stanced 250 TR" class="image2" />
    <img src="https://static3.hotcarsimages.com/wordpress/wp-content/uploads/2020/12/testarossa-e1607685057547.jpg" alt="Stanced 250 TR 2" class="image3" />
    These things are nasty-stanced, but bags save the day once again... </p>

  </div>


  <div id="third">
    <h2><u>3/26/2021- "Need to buy this kit"</u></h2>
    <p> <img src="https://i.ytimg.com/vi/ebwSoR3OAzI/maxresdefault.jpg" alt="Aspec TL" class="image4" />

      I really really need to buy the A-spec kit</p>

    </div>

    <div id="fourth">
       <h2><u>9/32/2021- "HW11 Arrays"</u></h2>

       <?php

       $cities = array("Tokyo", "Rio", "New York City", "Abu Dhabi", "Dubai", "Berlin", "Moscow", "Singapore", "Rome", "Paris");


       for ($i = 0; $i < count($cities); $i++)
       {
         if($i == (count($cities)-1))
           {
          echo("$cities[$i]");
        } else {
       echo("$cities[$i], ");

        }
        }
        echo "<br>";
        echo "<br>";
       sort($cities);

       for ($i = 0; $i < count($cities); $i++)
       {
         if($i == (count($cities)-1))
           {
          echo("$cities[$i]");
        } else {
       echo("$cities[$i], ");
        }
        }
        echo "<br>";
        echo "<br>";
        array_push($cities, "Portland");
        array_reverse($cities);
        for ($i = 0; $i < count($cities); $i++)
       {
         if($i == (count($cities)-1))
           {
          echo("$cities[$i]");
        } else {
       echo("$cities[$i], ");

        }
        }
        echo "<br>";

        if(in_array("Van", $cities)==true)
        {
          ?> <p>Yay!</p> <?php
        }else{
          ?> <p>Huh?</p> <?php
        }
        $string = implode("^^", $cities);
        ?><p><?= $string ?></p> <?php

       $array = explode("^^", $string);

       for ($i = 0; $i < count($array); $i++)
       {
         if($i == (count($array)-1))
           {
          echo("$array[$i]");
        } else {
       echo("$array[$i], ");

        }
        }
        echo "<br>";
        echo "<br>";
        echo "<br>";
        echo "<br>";
        echo "<br>";
       ?>




    </div>
    <div id="fifth">
      <h2><u>5/23/2021- "Some Good Music"</u></h2>
      <ol>
      <?php foreach (file("music.txt") as $book) {
        list($title, $author, $link) = explode(",", $book);
        ?>
        <li><p><a href="<?= $link ?>"><?= $title ?> by <?= $author ?></a></p></li>
          <?php
        }
        ?>
      </ol>

      </div>

      <div id="margin">
      </div>
</div>


<div class="bottommenu-wrapper">
    <div id="bottommenu">

     <?php include "bottom_menu.html"; ?>
    </div>
</div>






</body>
</html>
