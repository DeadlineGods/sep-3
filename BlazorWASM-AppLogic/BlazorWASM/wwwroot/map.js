let map, infoWindow, marker;
let exportPosition = { lat: -34.397, lng: 150.644 }

function initialize() {

	map = new google.maps.Map(document.getElementById("map"), {
		center: exportPosition,
		zoom: 6,
	});

	marker = new google.maps.Marker({
		// The below line is equivalent to writing:
		// position: new google.maps.LatLng(-34.397, 150.644)
		position: exportPosition,
		map: map,
	});

	infoWindow = new google.maps.InfoWindow();

	const locationButton = document.createElement("button");

	locationButton.textContent = "Get Current Location";
	locationButton.classList.add("btn");
	locationButton.classList.add("btn-light");
	locationButton.classList.add("custom-map-control-button");
	map.controls[google.maps.ControlPosition.TOP_CENTER].push(locationButton);


	// change location after clicking on locationButton
	locationButton.addEventListener("click", () => {
		locateToLocation()
	})

	// Configure the click listener.
	map.addListener("click", (e) => {
		marker.setPosition(e.latLng)
		map.panTo(e.latLng);
		exportPosition.lat = e.latLng.lat()
		exportPosition.lng = e.latLng.lng()
	});

	// uncomment for automatic location
	locateToLocation()
}

function locateToLocation() {
	// Try HTML5 geolocation.
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(
			(position) => {
				const pos = {
					lat: position.coords.latitude,
					lng: position.coords.longitude,
				};

				infoWindow.setPosition(pos);

				marker.setPosition(pos)
				infoWindow.setContent("Location found.");
				infoWindow.open(map, marker);
				map.setCenter(pos);
				exportPosition = pos
			},
			() => {
				handleLocationError(true, infoWindow, map.getCenter());
			}
		);
	} else {
		// Browser doesn't support Geolocation
		handleLocationError(false, infoWindow, map.getCenter());
	}
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	infoWindow.setPosition(pos);
	infoWindow.setContent(
		browserHasGeolocation
			? "Error: The Geolocation service failed."
			: "Error: Your browser doesn't support geolocation."
	);
	infoWindow.open(map);
}

function getData() {
	return `{
		"latitude": ${exportPosition.lat},
		"longitude": ${exportPosition.lng}
	}`
}

// var searchBox = new google.maps.places.SearchBox(document.getElementById('pac-input'));
// map.controls[google.maps.ControlPosition.TOP_CENTER].push(document.getElementById('pac-input'));
// google.maps.event.addListener(searchBox, 'places_changed', function() {
// 	searchBox.set('map', null);
//
// 	var places = searchBox.getPlaces();
//
// 	var bounds = new google.maps.LatLngBounds();
// 	var i, place;
// 	for (i = 0; place = places[i]; i++) {
// 		(function(place) {
// 			var marker = new google.maps.Marker({
//
// 				position: place.geometry.location
// 			});
// 			marker.bindTo('map', searchBox, 'map');
// 			google.maps.event.addListener(marker, 'map_changed', function() {
// 				if (!this.getMap()) {
// 					this.unbindAll();
// 				}
// 			});
// 			bounds.extend(place.geometry.location);
//
//
// 		}(place));
//
// 	}
// 	map.fitBounds(bounds);
// 	searchBox.set('map', map);
// 	map.setZoom(Math.min(map.getZoom(),12));
// });

// window.initMap = initMap;
