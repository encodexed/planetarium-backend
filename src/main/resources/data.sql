INSERT INTO users(id, email, password, role, username)
VALUES
  (1, "admin@test.com", "$2a$10$koYwYjrev5xAUf86S3XU7ODHruZ.EKUlF8TOMbCGu8ahR0JG4pN62", "ROLE_ADMIN", "admin"),
  (2, "robbie@test.com", "$2a$10$koYwYjrev5xAUf86S3XU7ODHruZ.EKUlF8TOMbCGu8ahR0JG4pN62", "ROLE_ADMIN", "robbie"),
  (3, "emily@test.com", "$2a$10$koYwYjrev5xAUf86S3XU7ODHruZ.EKUlF8TOMbCGu8ahR0JG4pN62", "ROLE_ADMIN", "emily"),
  (4, "lorenzo@test.com", "$2a$10$koYwYjrev5xAUf86S3XU7ODHruZ.EKUlF8TOMbCGu8ahR0JG4pN62", "ROLE_ADMIN", "lorenzo")
;

INSERT INTO star_systems(id, name, coordinate_x, coordinate_y, coordinate_z, date_instantiated, first_arrival_at, first_arrival_user_id, first_colonised_at, first_colonised_user_id, first_explored_at, first_explored_user_id)
VALUES
  (1, "Sol", 50, 50, 50, "2023-12-01 15:29:25.427000", "2023-12-01 15:29:25.427000", 1, "2023-12-01 15:29:25.427000", 1, "2023-12-01 15:29:25.427000", 1),
  (2, "Alpha Centauri", 40, 50, 60, "2023-12-01 15:29:25.427000", "2023-12-01 15:29:25.427000", 2, "2023-12-01 15:29:25.427000", 2, "2023-12-01 15:29:25.427000", 2),
  (3, "Sirius", 30, 60, 40, "2023-12-01 15:29:25.427000", "2023-12-01 15:29:25.427000", 4, "2023-12-01 15:29:25.427000", 4, "2023-12-01 15:29:25.427000", 4),
  (4, "Procyon", 50, 50, 50, "2023-12-01 15:29:25.427000", "2023-12-01 15:29:25.427000", 1, "2023-12-01 15:29:25.427000", 1, "2023-12-01 15:29:25.427000", 1)
 ;

INSERT INTO stars(id, name, stellar_class, solar_radii, solar_masses, surface_temperature_k, star_system_id, date_instantiated)
VALUES
  (1, "The Sun", "G", 1, 1, 5772, 1, "2023-12-01 15:29:25.427000"),
  (2, "Alpha Centauri A", "G", 1.2175, 1.0788, 5790, 1, "2023-12-01 15:29:25.427000"),
  (3, "Alpha Centauri B", "K", 0.8591, 0.9092, 5260, 1, "2023-12-01 15:29:25.427000"),
  (4, "Sirius A", "A", 1.711, 2.063, 9940, 1, "2023-12-01 15:29:25.427000"),
  (5, "Procyon A", "F", 2.048, 1.499, 6530, 1, "2023-12-01 15:29:25.427000")
 ;