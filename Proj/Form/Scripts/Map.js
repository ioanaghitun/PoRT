var map = L.map('map').setView([53.00, 9.00], 4);
var lati=document.getElementById("latitudine");
var long=document.getElementById("longitudine");
mapLink =
    '<a href="http://openstreetmap.org">OpenStreetMap</a>';
L.tileLayer(
    'http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; ' + mapLink + ' Contributors',
        maxZoom: 20,
    }).addTo(map);



function updateMap(){
	var lat=parseFloat(lati.value)||0;
	var lon=parseFloat(long.value)||0;
	map.panTo(new L.LatLng(lat, lon));
}


