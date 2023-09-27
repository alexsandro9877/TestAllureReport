package org.example.Model;

/// Criar modelo interface
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

    private String id;

    private String sku;

    private String name;
}
