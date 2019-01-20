// JavaScript Document

/*$(document).on('click','#select',function(){
  //Launch the modal on click event
	$('#myModal').modal();
});*/


//set button id on click to hide first modal
$("#signin").on( "click", function() {
        $('#myModal1').modal('hide');  
});
//trigger next modal
$("#signin").on( "click", function() {
        $('#myModal2').modal('show');  
});
