$(document).on("click", "#tarjeta_credito_button", function(){
    $('#paypal').addClass('d-none');
    $('#tarjeta_credito').removeClass('d-none');
    $('#tarjeta_credito_button').addClass('active');
    $('#paypal_button').removeClass('active');
});

$(document).on("click", "#paypal_button", function(){
    $('#paypal').removeClass('d-none');
   $('#tarjeta_credito').addClass('d-none');
   $('#tarjeta_credito_button').removeClass('active');
   $('#paypal_button').addClass('active');
});


$(document).on('change', '#departamento', function(){
    $.ajax({
        type: "GET",
        url: "/pagar/provincias/" + this.value,
        contentType: "application/json",
        success: function(res){
            $("#provincia").empty();
            res.map((item) => {
                $("#provincia").append(`
                    <option value="${item.id}">${item.nombre}</option>
                `);
            })
        },
        error: function(xhr, status, error) {
            console.log("error");
        }
    });
});

$(document).on('change', '#provincia', function(){
    $.ajax({
        type: "GET",
        url: "/pagar/distrito/" + this.value,
        contentType: "application/json",
        success: function(res){
            $("#distrito").empty();
            res.map((item) => {
                $("#distrito").append(`
                    <option value="${item.id}">${item.nombre}</option>
                `);
            })
        },
        error: function(xhr, status, error) {
            console.log("error");
        }
    });
});

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


$(document).on('click', '#btn-procesar', function(){
    $.ajax({
        type: "POST",
        url: "/pagar/procesar/direccion",
        contentType: "application/json",
        data:  JSON.stringify({
            id              : $('#valueId').val(),
            direccion       : $('#direccion').val(),
            referencias     : $('#referencias').val(),
            telefono        : $('#telefono').val(),
            departamento    : $('#departamento').val(),
            provincia       : $('#provincia').val(),
            distrito        : $('#distrito').val(),
            codigo_zip      : $('#zip').val(),
            direccion_preferida : $('#direccion_preferida').is(":checked"),
            tipoPago : $('#tipo_pago').val(),
            tipoEntrega : 1,
            costo_delivery: 3.55
        }),
        success: function(res){
            if(res.respuesta){
                    window.location.href = "/factura/exito";
            }
            console.log(res.respuesta);
        },
        error: function(xhr, status, error) {
            console.log("error");
        }
    })
});
