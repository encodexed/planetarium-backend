-- General information about stars
SELECT id, name, stellar_class, solar_masses, solar_radii, surface_temperature_k
FROM stars
ORDER BY name;

-- Inner join example for star_systems and users
SELECT name, username as first_arrival_by, first_arrival_at 
FROM star_systems
INNER JOIN users ON star_systems.first_arrival_by = users.id;

-- Inner join for stars and star_systems
SELECT stars.name AS 'Star', star_systems.name AS 'System', stellar_class AS 'Stellar Class',
solar_masses AS 'Solar Masses', solar_radii AS 'Solar Radii', surface_temperature_k AS 'Surface Temp (K)'
FROM stars
INNER JOIN star_systems ON star_systems.id = stars.star_system_id
ORDER BY surface_temperature_k DESC;