//$(document).on("click", "#panel_micarrito", function(){
//    $('#box_carrito').toggleClass('d-none');
//});

function agregarCarrito(id){
    $.ajax({
        type: "POST",
        url: "/carrito/compras/agregar",
        contentType: "application/json",
        data:  JSON.stringify({
            id : id,
            cantidad : 1
        }),
        success: function(res){
            console.log(res);
        },
        error: function(xhr, status, error) {
            console.log("error");
        }
    });
}

function eliminarProductoCarrito(id){
    console.log('elinar producto en proceso');
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

