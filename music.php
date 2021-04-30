<html>
<style type="text/css">
#music2{
  border: 3px solid green;
  padding: 0.5em;
  background-color: lightslategray;
  overflow: auto;
  padding-top: 1px;
  margin-top: 10px;
  clear: none;

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
  <div id="sidediv">
	  <?php include "side_menu.html"; ?>
	</div>
  <div id="content">


  <div id="music2">

       <h1 style="color:#8b0000"> My favorite music: </h1>
       <form action="music.php">
  <div>
        <?php
        if(isset($_GET["sorted"]))
        {
          $sort = TRUE;
          printSongs2($sort);
        }else
        {
          $sort = FALSE;
          printSongs2($sort);
        }
               function printSongs2($sort)
               { ?>
                 <ol type="i">
                 <?php
                  if($sort==FALSE)
                {
                  foreach (file("songs.txt") as $book)
                  {
                      list($title, $author, $link, $img) = explode(",", $book);
                      ?>
                      <li><img src=<?=$img?> width=100 height=100 />
                        <p><a href="<?= $link ?>"><?= $title ?> by <?= $author ?></a>&emsp; size: </p></li>
                        <?php
                    }
                  }
                   if($sort==TRUE)
                   {
                   ?> <ol type="i"> <?php
                     $array2 = array();
                     foreach (file("songs.txt") as $book)
                      {
                       array_push($array2, $book);
                     }
                     sort($array2);

                     for($i = 0; $i < count($array2); $i++)
                     {
                     list($title, $author, $link, $img) = explode(",", $array2[$i]);
                         ?>
                         <li><img src=<?=$img?> width=100 height=100 />
                           <p><a href="<?= $link ?>"><?= $title ?> by <?= $author ?></a>&emsp; size: </p></li>
                           <?php
                     }
                   }
                   ?>
                 </ol> <?php
               }
                ?>
                <input type="checkbox" name="sorted" />Sort by title
                <input type="submit" value ="Sort" />
  </div>
      </form>
      <form action="music.php"  method="post" enctype="multipart/form-data">
        <div>
            Title: <input name="title" minlength="1" />
            Artist: <input name="artist" minlength="1" />
            Link: <input name="link"  minlength="1" />
            Upload Image: <input type="file" name="imgcover" />
                  <input type="submit" name="add" value="Add New Song" />
                </div>
                <?php
                if(isset($_POST["add"]))
{
                  $title = $_POST["title"];
                  $artist = $_POST["artist"];
                  $link = $_POST["link"];
                  if(preg_match('/youtube/', $link) && strlen($title) > 1 && strlen($artist)>1)
                  {
                    $text = $title. ", ".$artist.", ".$link.", ".count(file("songs.txt")).".jpg" ."\n";
                    file_put_contents("songs.txt", $text, FILE_APPEND);
                  }else if(strlen($title) < 1){
                    echo"<p>Title not Correct</p>";}
                  else if(strlen($artist) < 1){
                    echo"<p>Artist not Correct</p>";
                  }else{
                    echo"<p>Link not Correct</p>";}
                  if (is_uploaded_file($_FILES["imgcover"]["tmp_name"])){
                      move_uploaded_file($_FILES["imgcover"]["tmp_name"],
                      "".(count(file("songs.txt"))-1).".jpg");
                    } else {
                      print "Error: required file not uploaded";}
                    header("Refresh:0");} ?>
              </form>
  </div>
</div>
</body>

</html>
