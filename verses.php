<html>
<style type="text/css">
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
<body bgcolor=<?php
	  $colorsArray = file("colors.txt");
        print $colorsArray[rand(0, count($colorsArray)-1)];
    ?>
  >

	<div id="sidediv">
	  <?php include "side_menu.html"; ?>
	</div>
	<div id ="content">
    <h1>Verse of the Day</h1>

<?php
  $versesArray = file("verses.txt");
  $randomNumber = rand(0,count($versesArray)-1);
  echo"<p>" .$versesArray[$randomNumber]."</p>";
  ?>

</br>
  <a href="blog.php">Link back to Blog</a>
</div>
</body>

</html>
