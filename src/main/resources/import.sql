-- INSERTAR DATOS DE PRUEBA

-- Insertar datos de prueba para la tabla franquicia
INSERT INTO accenture.franquicia (nombre) VALUES ('Franquicia Alpha');
INSERT INTO accenture.franquicia (nombre) VALUES ('Franquicia Beta');
INSERT INTO accenture.franquicia (nombre) VALUES ('Franquicia Gamma');

-- Insertar datos de prueba para la tabla sucursal
-- Sucursales para Franquicia Alpha
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Alpha 1', 1);
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Alpha 2', 1);
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Alpha 3', 1);
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Alpha 4', 1);
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Alpha 5', 1);

-- Sucursales para Franquicia Beta
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Beta 1', 2);
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Beta 2', 2);
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Beta 3', 2);
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Beta 4', 2);
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Beta 5', 2);

-- Sucursales para Franquicia Gamma
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Gamma 1', 3);
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Gamma 2', 3);
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Gamma 3', 3);
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Gamma 4', 3);
INSERT INTO accenture.sucursal (nombre, franquicia_id) VALUES ('Sucursal Gamma 5', 3);

-- Insertar datos de prueba para la tabla producto
-- Productos para Sucursal Alpha 1
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A1-1', 100, 1);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A1-2', 200, 1);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A1-3', 150, 1);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A1-4', 120, 1);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A1-5', 180, 1);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A1-6', 130, 1);

-- Productos para Sucursal Alpha 2
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A2-1', 110, 2);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A2-2', 210, 2);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A2-3', 160, 2);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A2-4', 130, 2);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A2-5', 190, 2);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A2-6', 140, 2);

-- Productos para Sucursal Alpha 3
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A3-1', 120, 3);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A3-2', 220, 3);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A3-3', 170, 3);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A3-4', 140, 3);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A3-5', 200, 3);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A3-6', 150, 3);

-- Productos para Sucursal Alpha 4
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A4-1', 130, 4);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A4-2', 230, 4);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A4-3', 180, 4);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A4-4', 150, 4);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A4-5', 210, 4);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A4-6', 160, 4);

-- Productos para Sucursal Alpha 5
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A5-1', 140, 5);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A5-2', 240, 5);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A5-3', 190, 5);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A5-4', 160, 5);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A5-5', 220, 5);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto A5-6', 170, 5);

-- Productos para Sucursal Beta 1
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B1-1', 100, 6);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B1-2', 200, 6);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B1-3', 150, 6);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B1-4', 120, 6);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B1-5', 180, 6);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B1-6', 130, 6);

-- Productos para Sucursal Beta 2
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B2-1', 110, 7);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B2-2', 210, 7);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B2-3', 160, 7);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B2-4', 130, 7);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B2-5', 190, 7);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B2-6', 140, 7);

-- Productos para Sucursal Beta 3
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B3-1', 120, 8);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B3-2', 220, 8);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B3-3', 170, 8);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B3-4', 140, 8);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B3-5', 200, 8);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B3-6', 150, 8);

-- Productos para Sucursal Beta 4
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B4-1', 130, 9);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B4-2', 230, 9);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B4-3', 180, 9);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B4-4', 150, 9);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B4-5', 210, 9);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B4-6', 160, 9);

-- Productos para Sucursal Beta 5
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B5-1', 140, 10);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B5-2', 240, 10);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B5-3', 190, 10);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B5-4', 160, 10);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B5-5', 220, 10);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto B5-6', 170, 10);

-- Productos para Sucursal Gamma 1
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G1-1', 100, 11);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G1-2', 200, 11);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G1-3', 150, 11);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G1-4', 120, 11);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G1-5', 180, 11);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G1-6', 130, 11);

-- Productos para Sucursal Gamma 2
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G2-1', 110, 12);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G2-2', 210, 12);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G2-3', 160, 12);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G2-4', 130, 12);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G2-5', 190, 12);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G2-6', 140, 12);

-- Productos para Sucursal Gamma 3
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G3-1', 120, 13);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G3-2', 220, 13);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G3-3', 170, 13);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G3-4', 140, 13);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G3-5', 200, 13);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G3-6', 150, 13);

-- Productos para Sucursal Gamma 4
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G4-1', 130, 14);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G4-2', 230, 14);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G4-3', 180, 14);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G4-4', 150, 14);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G4-5', 210, 14);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G4-6', 160, 14);

-- Productos para Sucursal Gamma 5
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G5-1', 140, 15);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G5-2', 240, 15);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G5-3', 190, 15);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G5-4', 160, 15);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G5-5', 220, 15);
INSERT INTO accenture.producto (nombre, stock, sucursal_id) VALUES ('Producto G5-6', 170, 15);