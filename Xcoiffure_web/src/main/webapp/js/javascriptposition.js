



navigator.geolocation.getCurrentPosition(function(position){
	console.log(position);
	var lat = position.coords.latitude;
	var lng = position.coords.longitude;
	
	$.ajax({
		method: 'GET',
		url: 'http://maps.googleapis.com/maps/api/geocode/json',
		data:{
			latlng:lat + "," + lng
		},

		success: function(adresse) {
			console.log(adresse);
			console.log(adresse.results[0].formatted_address);
			
			
			$('input[name ="ad"]').val(adresse.results[0].formatted_address);

	}
	})
});


class Address {
	constructor (address) {
	this.address = address;
	}
};



$('#form-adresse').bind('submit', ajouterAddress);



function ajouterAddress(){	
var newAddress = new Address (
		$('input[name ="ad"]').val()
		);

$.ajax({
	method: 'GET',
	url: 'http://maps.googleapis.com/maps/api/geocode/json',
	data:{
		address: newAddress.address
	},

	success: function(adresse) {
		console.log(adresse.results[0].geometry.location);
				
			
			
			var latlng = new google.maps.LatLng(adresse.results[0].geometry.location);
			var service = new google.maps.places.PlacesService(document.querySelector('#map'));	
			

		service.textSearch({
			location: latlng,
			radius: '500',
			query: ['coiffeur']
		}, function(place, status) {
			console.log(place);
		
/*			function créerLigneTableau(produit){

				var myLigne =  $("<tr/>");


				// Creation element html (la ligne et les 3 colonnes)
				var myColumnNom = $("<td/>"); 

				// Je place le contenu dans les colonnes nom
				myColumnNom.html(produit.nom); 

				// J'associe les colonnes à la ligne
				myLigne.append(myColumnNom);

				// On ajoute la ligne au tableau html
*/				
			for (let i = 0; i < 19; i++) {
				$('#tableau-adresse').append(place[0+i].formatted_address);
			}		
/*}*/
	
		});
}
})


return false;
};