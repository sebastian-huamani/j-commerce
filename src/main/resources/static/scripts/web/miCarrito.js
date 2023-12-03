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

