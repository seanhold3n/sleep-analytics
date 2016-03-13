<!-- html about page for our sleep analytics project --> 
<html>

	<head>
		
		<!-- titles go in heads, and this will make text appear on the tab --> 
		<title> ABOUT I can has sleep?  </title> 
	</head> 

	<style>
	/* Rebecca's first time using CSS */ 
/* styling for aboutIcanHazSleep.html */ 
/* PolyHacks 2016 */ 

/* adding background-color */ 
body { 
	background-color: #0B5172;
}

/* adding padding for head and body */
head {
	padding: 200px;
}
body {
	padding-right: 400px; 
	padding-left: 400px;
	padding-top: 70px
	padding-bottom: 70px ; 
}

/* editing the color of text and the background-color of the text, font, and allignment */ 
#h2 {
	color: #FFFFFF
	/* text-shadow: rgba(0, 0, 0, 1) -1px -2px 0.5em ; */
}

.greeting {
	color: #FFFFFF ; 
	background-color: #008542 ;
	max-width: 425px ; 
	font-family: "Courier New", Courier, monospace ; 
}

.canHasSleep { 
	color: #000000 ;
	background-color: #66CC33 ;
	max-width: 425px ;
	text-align: left ; 
	font-family: "Courier New", Courier, monospace ;
	position: relative ; 
	left: 300px ; 
}

.response { 
	color: #FFFFFF ; 
	background-color: #008542 ;
	max-width: 425px ;
	font-family: "Courier New", Courier, monospace ;
}

.projectDescription { 
	color: #FFFFFF ; 
	background-color: #008542 ;
	max-width: 425px ;
	font-family: "Courier New", Courier, monospace ;
}

#catAsks {
	color: #000000 ;
	background-color: #66CC33 ;
	max-width: 425px ;
	text-align: left ;
	font-family: "Courier New", Courier, monospace ;
	position: relative ; 
	left: 300px ; 
}

#responseToCat { 
	color: #FFFFFF ; 
	background-color: #008542 ;
	max-width: 425px ;
	font-family: "Courier New", Courier, monospace ;
}

table {
	color: white ; 
}

.moodAsk { 
	color: #000000 ;
	background-color: #66CC33 ;
	max-width: 425px ;
	text-align: left ;
	font-family: "Courier New", Courier, monospace ;
	position: relative ; 
	left: 300px ; 
}

.MoodData {
	color: #FFFFFF ; 
	background-color: #008542 ;
	max-width: 425px ;
	font-family: "Courier New", Courier, monospace ;
}

#moodScale { 
	color: #FFFFFF ; 
	background-color: #008542 ;
	max-width: 425px ;
	font-family: "Courier New", Courier, monospace ;
}

button { 
	background-color: #E37222 ; 
	font-size: 50 px ;
	border-radius: 90%;
}
	
	</style>

	<body> 
	
			<!-- referencing the external style sheet --> 

	
		<!-- heading for our about page -->
		<h2> About <br />I can has sleep? </h2> 
	
		<a href="/"><button type = "button"> I can has Sleep? </button></a> 
	
		<!-- greeting our users -->
		<p class = "greeting">  Hey there!
		<br /> We're glad you're here. </p> 

		 </b> 
		 
		<!-- description of our project -->
		
		<p class = "canHasSleep">  <b> I can has sleep? </b> </p>

		<p class = "response"> Yes, you can.  </p>
		
		<p class = "projectDescription">
		Our personal cat assistants will be happy to help you analyze   
		your sleep. At I can has sleep? you give us your sleep and mood  
		data and the cats run analytics to help you detect patterns 
		in your sleep. Our team of cats will even map your daily mood to 
		the amount of sleep you get per day. Awesome, right?! We thought so. </p> 
		</strong>
		
		<!-- file formating and input and instructions and such -->
		<p id = "catAsks"> <i> <b> But hoomans, how do they format their data files? </i> </b> </p> 
		
		<p id ="responseToCat"> Good question, Felix. The humans will need to have <em> two </em> different types of files. <br />
		<br /> 
		The first file needed is the <em> sleep data file </em>. This file is needed so the cats can assess the patterns of your sleep. <br /> 
		This file needs to be in CSV format. You can follow the following format in Excel and export to CSV. </p> 
		
		<!-- sleep data file format --> 
		<table border = 2 >
			<tr> 
				<td> Date </td>
				<td colspan = "2">  Time You Went to Sleep  </td>
				<td colspan = "3"> Time You Woke Up </td>
				<td colspan = "4"> # Hours of Sleep </td>
			</tr> 
			<tr>
				<td> 03/12/16 </td>
				<td colspan = "2"> 22:15  </td> 
				<td colspan = "3"> 06:00 </td> 
				<td colspan = "4"> 7.75 </td> 
			</tr> 
			<br /> 
		</table> 
		
		<p class = "moodAsk"> <b> Mood data? </b> </p> 
		
		<p class = "MoodData"> The second file needed is the <em> mood data file </em>. This file is needed so the cats can map your mood to your hours of sleep/day. <br /> 
		This file needs to be in CSV format. You can follow the following format in Excel and export to CSV. </p> 
		<!-- mood data format --> 
		<table border = 2> 
			<tr> 
				<td> Date </td> 
				<td colspan = "2"> Mood </td> 
			</tr> 
			<tr> 
				<td> 03/12/2016 </td> 
				<td colspan = "2"> 3 </td> 
			</tr> 
		</table> 
		
		<!-- measurement method for mood -->
		<p id = "moodScale"> The measurement of mood is on a five point scale. Here are the categories of moods: 
		
		<br /> 1 = VERY not happy 
		<br /> 2 = not happy 
		<br /> 3 = content 
		<br /> 4 = well 
		<br /> 5 = everything is AWESOME 
		
		</p> 
			
	</body> 

</html> 
