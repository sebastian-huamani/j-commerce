package com.example.demo.controller;


import com.example.demo.model.db.*;
import com.example.demo.model.repository.EntregaRepository;
import com.example.demo.model.request.PagoRequest;
import com.example.demo.model.request.ProductoRequest;
import com.example.demo.model.response.RespuestaResponse;
import com.example.demo.model.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/pagar")
public class PagarController {

    private DireccionService direccionService;
    private CarritoComprasService carritoComprasService;
    private EntregaService entregaService;
    private FacturaService facturaService;
    private DetalleService detalleService;

    @GetMapping("/")
    public String pagar(Model model){
        model.addAttribute("productos", carritoComprasService.listar());
        model.addAttribute("total", carritoComprasService.calcular());
        model.addAttribute("departamentos", direccionService.listarDepartamentos());
        return "/carrito/completarPago";
    }

    @GetMapping("/provincias/{id}")
    @ResponseBody
    public List<Provincia> listarProvincias(@PathVariable int id, Model model){
        return direccionService.listarProvinciaPorDepartamento(id);
    }

    @GetMapping("/distrito/{id}")
    @ResponseBody
    public List<Distrito> listarDistrito(@PathVariable int id, Model model){
        return direccionService.listarDistritoPorProvincia(id);
    }

    @PostMapping("/procesar/direccion")
    @ResponseBody
    public RespuestaResponse store(@RequestBody PagoRequest pagoRequest){
        String msg = "Compra Procesada con Exito";
        Boolean status = true;
        try{
            Direccion direccion =  direccionService.save(pagoRequest);

            Entrega entrega =  entregaService.save(pagoRequest, direccion);

            Factura factura = facturaService.save(pagoRequest, entrega);

            // aqui convertimos toda la lista de deseos a detalle de factura
            detalleService.saveDetalleProductos(factura);

            //actualizamos el monto total de la factura
            facturaService.actualizarTotalFactura(factura.getId());

        }catch (Exception exception){
            msg = exception.getMessage();
            System.out.println(msg);
        }
        return RespuestaResponse.builder().mensaje(msg).respuesta(status).build();
    }



}
