/*IF NOT EXISTS
    (SELECT 1 FROM tipocliente WHERE tipocliente_id = 1 AND tipocliente_nombre = 'Tiempo Completo')
    BEGIN
        INSERT tipocliente (tipocliente_id, tipocliente_nombre) VALUES (1, 'Tiempo Completo')
    END;
IF NOT EXISTS
    (SELECT 1 FROM tipocliente WHERE tipocliente_id = 2 AND tipocliente_nombre = 'Medio Tiempo')
    BEGIN
        INSERT tipocliente (tipocliente_id, tipocliente_nombre) VALUES (2, 'Medio Tiempo')
    END;
IF NOT EXISTS
    (SELECT 1 FROM tipocliente WHERE tipocliente_id = 3 AND tipocliente_nombre = 'CAS')
    BEGIN
        INSERT tipocliente (tipocliente_id, tipocliente_nombre) VALUES (3, 'CAS')
    END;*/
    
    
    INSERT INTO tipocliente (tipocliente_id, tipocliente_nombre)
SELECT 1, 'Tiempo Completo'
WHERE NOT EXISTS (SELECT 1 FROM tipocliente WHERE tipocliente_id = 1 AND tipocliente_nombre = 'Tiempo Completo');

INSERT INTO tipocliente (tipocliente_id, tipocliente_nombre)
SELECT 2, 'Medio Tiempo'
WHERE NOT EXISTS (SELECT 1 FROM tipocliente WHERE tipocliente_id = 2 AND tipocliente_nombre = 'Medio Tiempo');

INSERT INTO tipocliente (tipocliente_id, tipocliente_nombre)
SELECT 3, 'CAS'
WHERE NOT EXISTS (SELECT 1 FROM tipocliente WHERE tipocliente_id = 3 AND tipocliente_nombre = 'CAS');
    