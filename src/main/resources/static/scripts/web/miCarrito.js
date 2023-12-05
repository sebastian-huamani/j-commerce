$(document).on("click", "#panel_micarrito", function(){
    $('#box_carrito').toggleClass('fade');
});

function agregarCarrito(id, nombre){
    var lista = [];
    var existProductJSON =  window.localStorage.getItem('productos');
    var data = JSON.parse(existProductJSON);

    if(data != null) {
        data.forEach((element) => lista.push(element));
    }

    if(!lista.includes(id)){
        lista.push(id);
        window.localStorage.setItem('productos', JSON.stringify(lista));
    }
}


$(document).on('click', '#btn-guardar', function(){
    $.ajax({
        type: "POST",
        url: "/productos/store",
        contentType: "application/json",
        data:  JSON.stringify({
            id : $('#txtid').val(),
            nombre : $('#txtnombre').val(),
            descripcion : $('#txtdescripcion').val(),
            marca : $('#txtmarca').val(),
            precio_compra : $('#txtprecio_compra').val(),
            precio_venta : $('#txtprecio_venta').val(),
            activo : $('#txtactivo').is(":checked"),
            cantidad : $('#txtcantidad').val(),
            cantidad_minima : $('#txtcantidad_minima').val()
        }),
        success: function(res){
            console.log(res);
        },
        error: function(xhr, status, error) {
            console.log("error");
        }
    })
});

