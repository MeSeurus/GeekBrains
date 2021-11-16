INSERT INTO categories (id, name) VALUES (1, 'TOYS'), (2, 'CARS'), (3, 'FOOD');

INSERT INTO products (id, name, description) VALUES (1, 'Lego Star Wars', 'Droid battle set'),
                                                    (2, 'Skoda Karoq', 'City SUV'),
                                                    (3, 'Kia K5', 'Sport Sedan'),
                                                    (4, 'Chicken', 'Refrigerated'),
                                                    (5, 'Mango', 'Imported from Ecuador'),
                                                    (6, 'Lego Princess', 'Girls set');
INSERT INTO products_categories (product_id, categories_id) VALUES (1,1),
                                                                   (2,2),
                                                                   (3,2),
                                                                   (4,3),
                                                                   (5,3),
                                                                   (6,1);