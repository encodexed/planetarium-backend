-- General information about stars
SELECT id, name, stellar_class, coordinate_x AS x, coordinate_y AS y, coordinate_z AS z, solar_masses, solar_radii, surface_temperature_k
FROM stars
ORDER BY name;