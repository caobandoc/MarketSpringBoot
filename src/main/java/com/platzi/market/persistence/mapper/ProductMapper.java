package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(target = "idProducto", source = "productId"),
            @Mapping(target = "nombre", source = "name"),
            @Mapping(target = "idCategoria", source = "categoryId"),
            @Mapping(target = "precioVenta", source = "price"),
            @Mapping(target = "cantidadStock", source = "stock"),
            @Mapping(target = "estado", source = "active"),
            @Mapping(target = "categoria", source = "category"),
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
