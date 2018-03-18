var map = L.map('map').setView([53.00, 9.00], 4);
mapLink =
    '<a href="http://openstreetmap.org"></a>';
L.tileLayer(
    'http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution:  mapLink ,
        maxZoom: 20,
    }).addTo(map);

