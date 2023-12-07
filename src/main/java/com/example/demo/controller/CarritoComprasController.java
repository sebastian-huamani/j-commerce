package com.example.demo.controller;


import com.example.demo.model.request.CarritoComprasRequest;
import com.example.demo.model.response.RespuestaResponse;
import com.example.demo.model.service.CarritoComprasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
@RequestMapping("/carrito/compras")
public class CarritoComprasController {

    private CarritoComprasService carritoComprasService;

    @PostMapping("/agregar")
    @ResponseBody
    public RespuestaResponse agregar(@RequestBody CarritoComprasRequest carritoComprasRequest){
        return carritoComprasService.agregar(carritoComprasRequest);
    }

}
