INSERT INTO users(id, email, password, role, username)
VALUES
  (1, "admin@test.com", "$2a$10$koYwYjrev5xAUf86S3XU7ODHruZ.EKUlF8TOMbCGu8ahR0JG4pN62", "ROLE_ADMIN", "admin"),
  (2, "robbie@test.com", "$2a$10$koYwYjrev5xAUf86S3XU7ODHruZ.EKUlF8TOMbCGu8ahR0JG4pN62", "ROLE_ADMIN", "robbie")
;

INSERT INTO stars(id, name, stellar_class, coordinate_x, coordinate_y, coordinate_z, solar_radii, solar_masses, surface_temperature_k, first_discovered_by, first_discovered, first_explored_by, first_explored, first_colonised_by, first_colonised)
VALUES
  (1, "Sol", "G", 0, 0, 0, 1, 1, 5772, 2, "2023-12-01 15:29:25.427000", 2, "2023-12-01 15:29:25.427000", 2, "2023-12-01 15:29:25.427000"),
  (2, "Alpha Centauri A", "G", 4, 0, 0, 1.2175, 1.0788, 5790, 2, "2023-12-01 15:29:25.427000", 2, "2023-12-01 15:29:25.427000", 2, "2023-12-01 15:29:25.427000"),
  (3, "Alpha Centauri B", "K", 4, 0, 0, 0.8591, 1, 5260, 2, "2023-12-01 15:29:25.427000", 2, "2023-12-01 15:29:25.427000", 2, "2023-12-01 15:29:25.427000"),
  (4, "Sirius", "A", 2, 5, 1, 1.711, 2.063, 9940, 2, "2023-12-01 15:29:25.427000", 2, "2023-12-01 15:29:25.427000", 2, "2023-12-01 15:29:25.427000"),
  (5, "Procyon", "F", 4, 8, 4, 2.048, 1.499, 6530, 2, "2023-12-01 15:29:25.427000", 2, "2023-12-01 15:29:25.427000", 2, "2023-12-01 15:29:25.427000");