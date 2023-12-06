INSERT INTO users(id, email, password, role, username)
VALUES
  (1, "admin@test.com", "$2a$10$koYwYjrev5xAUf86S3XU7ODHruZ.EKUlF8TOMbCGu8ahR0JG4pN62", "ROLE_ADMIN", "admin"),
  (2, "robbie@test.com", "$2a$10$koYwYjrev5xAUf86S3XU7ODHruZ.EKUlF8TOMbCGu8ahR0JG4pN62", "ROLE_ADMIN", "robbie"),
  (3, "emily@test.com", "$2a$10$koYwYjrev5xAUf86S3XU7ODHruZ.EKUlF8TOMbCGu8ahR0JG4pN62", "ROLE_ADMIN", "emily"),
  (4, "lorenzo@test.com", "$2a$10$koYwYjrev5xAUf86S3XU7ODHruZ.EKUlF8TOMbCGu8ahR0JG4pN62", "ROLE_ADMIN", "lorenzo")
;

-- INSERT INTO stars(id, name, stellar_class, solar_radii, solar_masses, surface_temperature_k)
-- VALUES
--   (1, "Sol", "G", 1, 1, 5772),
--   (2, "Alpha Centauri A", "G", 1.2175, 1.0788, 5790),
--   (3, "Alpha Centauri B", "K", 0.8591, 0.9092, 5260),
--   (4, "Sirius", "A", 1.711, 2.063, 9940),
--   (5, "Procyon", "F", 2.048, 1.499, 6530)
-- ;

-- INSERT INTO star_systems(id, name, )
