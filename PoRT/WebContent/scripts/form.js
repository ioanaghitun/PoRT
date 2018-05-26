function verifica() {
	var title = document.getElementById("title").value;
	var description = document.getElementById("description").value;
	var date = document.getElementById("date").value;
	var time = document.getElementById("time").value;
	var latitude = document.getElementById("latitudine").value;
	var longitude = document.getElementById("longitudine").value;
	var email = document.getElementById("email").value;

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			alert(this.responseText);
		}
	};
	xhttp.open("POST", "VerifyHandler", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("title=" + title + "&description=" + description + "&date="
			+ date + "&time=" + time + "&latitude=" + latitude + "&longitude="
			+ longitude + "&email=" + email);
}