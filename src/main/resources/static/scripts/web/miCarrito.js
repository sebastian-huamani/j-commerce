console.log($('#panel_micarrito').val());


function agregarCarrito(id){
    console.log('here')
}

$(document).on("click", "#panel_micarrito", function(){
    $('#box_carrito').toggleClass('fade');
});