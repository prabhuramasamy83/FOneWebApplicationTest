$(document).ready(
		function() {

           var driverDivTagName= "#getTopDriversResult";
            var teamDivTagName= "#getTopTeamsResult";
			$("#getTopDrivers").click(function(event) {
				event.preventDefault();
				$(teamDivTagName).empty();
				ajaxGet(driverDivTagName,"getTopDrivers","DRIVER");
			});


            $("#getTopTeams").click(function(event) {
				event.preventDefault();
				$(driverDivTagName).empty();
				ajaxGet(teamDivTagName,"getTopTeams","TEAM");
			});

			function ajaxGet(divTagName,restUrl,searchType) {
				$.ajax({
					type : "GET",
					url : window.location + restUrl,
					success : function(result) {
						if (result.status == "success") {
							$(divTagName).empty();
							var divTagData = "<table border=1><tr><th>"+searchType+"</th><th>RACES</th><th>1ST</th><th>2ND</th><th>3RD</th><th>PODIUM</th><th>POLES</th><th>FASTEST</th><th>POINTS</th></th></tr>";
							$.each(result.object, function(i, data) {
								 divTagData =  divTagData + "<tr><td>" + data.name +"</td> <td>" + data.noOfRaces +"</td> <td>" + data.noOfFirstPos +"</td> <td>" + data.noOfSecondPos +"</td> <td>" + data.noOfThirdPos + "</td><td>" + data.noOfPodiums +"</td><td>" + data.noOfPoles +"</td> <td>" + data.noOfTimesFastest +"</td><td>" + data.noOfPoints +"</td></tr>";
							});
							divTagData = divTagData+"</table>";
						    $(divTagName).append(divTagData);
						} else {
							$(divTagName).html("<strong>No Data Found</strong>");
						}
					},
					error : function(e) {
						$(divTagName).html("<strong>Error Processing</strong>");
					}
				});
			}
})