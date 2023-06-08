package ProductosREST.com.gestion.productos.controller;

import ProductosREST.com.gestion.productos.model.Producto;
import ProductosREST.com.gestion.productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return service.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id) {
        try {
            Producto producto = service.obtenerProductoPorId(id);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/productos")
    public void guardarProducto(@RequestBody Producto producto){
        service.guardarProducto(producto);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id){
        try {
            Producto productoActual = service.obtenerProductoPorId(id);
            productoActual.setName(producto.getName());
            productoActual.setPrice(producto.getPrice());
            service.guardarProducto(productoActual);
            return new ResponseEntity<Producto>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        service.eliminarProducto(id);
    }
}