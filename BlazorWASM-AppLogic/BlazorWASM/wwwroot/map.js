let map, infoWindow, marker;
let exportPosition

function initialize() {
	map = new google.maps.Map(document.getElementById("map"), {
		center: { lat: -34.397, lng: 150.644 },
		zoom: 6,
	});

	marker = new google.maps.Marker({
		// The below line is equivalent to writing:
		// position: new google.maps.LatLng(-34.397, 150.644)
		position: { lat: -34.397, lng: 150.644 },
		map: map,
	});

	infoWindow = new google.maps.InfoWindow();

	const locationButton = document.createElement("button");

	locationButton.textContent = "Pan to Current Location";
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
		exportPosition = e.latLng
	});

	// uncomment for automatic location
	// locateToLocation()

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

// window.initMap = initMap;
