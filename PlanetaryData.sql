-- This SQL was generated from a diagram on diagram.db and details a future realisation of the simulation

-- Consider that stars and planets data may be missing/null as a measure of showing that the entity exists but hasn't been fully explored
CREATE TABLE `stars` (
  `id` integer PRIMARY KEY,
  `name` varchar(255) not null unique,
  `stellar_class` enum('O', 'B', 'A', 'F', 'G', 'K', 'M', 'OTHER') not null,
  `coordinateX` integer,
  `coordinateY` integer,
  `coordinateZ` integer,
  `is_main_star` boolean,
  `surface_temperature_K` integer,
  `solar_masses` float,
  `orbits_star_id` integer,
  `radius_Km` double,
  `first_discovered_by` integer,
  `first_discovered` datetime,
  `first_explored_by` integer,
  `first_explored` datetime,
  `first_colonised_by` integer,
  `first_colonised` datetime
);

CREATE TABLE `planets` (
  `id` integer PRIMARY KEY,
  `orbits_star_id` integer,
  `isMoon` boolean,
  `orbits_planet_id` integer,
  `name` varchar(255),
  `landable` boolean,
  `habitable` boolean,
  `terraformable` boolean,
  `average_surface_temp_K` integer,
  `earth_masses` double,
  `gravity` float,
  `atmosphere_type` varchar(255),
  `distanceToStar_LS` integer,
  `orbitTime` integer,
  `radius_Km` double
);

CREATE TABLE `planet_resources` (
  `id` integer PRIMARY KEY,
  `planet_id` integer,
  `resource_id` integer
);

CREATE TABLE `resources` (
  `id` integer PRIMARY KEY,
  `name` varchar(255),
  `value` float,
  `weight` int
);

CREATE TABLE `settlements` (
  `planet_id` integer,
  `id` integer PRIMARY KEY,
  `name` varchar(255),
  `population` int,
  `land_size` int,
  `food` int,
  `water` int
);

CREATE TABLE `settlement_facilities` (
  `id` integer PRIMARY KEY,
  `settlement_id` integer,
  `facility_id` integer
);

CREATE TABLE `facilities` (
  `id` integer PRIMARY KEY,
  `name` varchar(255),
  `workers_required` int,
  `population_housed` int,
  `commodity_produced_id` integer
);

CREATE TABLE `commodities` (
  `id` integer PRIMARY KEY,
  `value` int,
  `weight` int,
  `recipe_id` integer
);

CREATE TABLE `commodity_recipes` (
  `id` integer PRIMARY KEY,
  `req_resource1_id` integer,
  `req_resource2_id` integer,
  `req_resource3_id` integer,
  `res1_amount` int,
  `res2_amount` int,
  `res3_amount` int
);

ALTER TABLE `planets` ADD FOREIGN KEY (`orbits_planet_id`) REFERENCES `planets` (`id`);

ALTER TABLE `planets` ADD FOREIGN KEY (`orbits_star_id`) REFERENCES `stars` (`id`);

ALTER TABLE `stars` ADD FOREIGN KEY (`orbits_star_id`) REFERENCES `stars` (`id`);

ALTER TABLE `settlements` ADD FOREIGN KEY (`planet_id`) REFERENCES `planets` (`id`);

ALTER TABLE `planet_resources` ADD FOREIGN KEY (`resource_id`) REFERENCES `resources` (`id`);

ALTER TABLE `planet_resources` ADD FOREIGN KEY (`planet_id`) REFERENCES `planets` (`id`);

ALTER TABLE `settlement_facilities` ADD FOREIGN KEY (`settlement_id`) REFERENCES `settlements` (`id`);

ALTER TABLE `settlement_facilities` ADD FOREIGN KEY (`facility_id`) REFERENCES `facilities` (`id`);

ALTER TABLE `facilities` ADD FOREIGN KEY (`commodity_produced_id`) REFERENCES `commodities` (`id`);

ALTER TABLE `commodity_recipes` ADD FOREIGN KEY (`id`) REFERENCES `commodities` (`recipe_id`);

CREATE TABLE `commodity_recipes_resources` (
  `commodity_recipes_req_resource1_id` integer,
  `resources_id` integer,
  PRIMARY KEY (`commodity_recipes_req_resource1_id`, `resources_id`)
);

ALTER TABLE `commodity_recipes_resources` ADD FOREIGN KEY (`commodity_recipes_req_resource1_id`) REFERENCES `commodity_recipes` (`req_resource1_id`);

ALTER TABLE `commodity_recipes_resources` ADD FOREIGN KEY (`resources_id`) REFERENCES `resources` (`id`);


CREATE TABLE `commodity_recipes_resources(1)` (
  `commodity_recipes_req_resource2_id` integer,
  `resources_id` integer,
  PRIMARY KEY (`commodity_recipes_req_resource2_id`, `resources_id`)
);

ALTER TABLE `commodity_recipes_resources(1)` ADD FOREIGN KEY (`commodity_recipes_req_resource2_id`) REFERENCES `commodity_recipes` (`req_resource2_id`);

ALTER TABLE `commodity_recipes_resources(1)` ADD FOREIGN KEY (`resources_id`) REFERENCES `resources` (`id`);


CREATE TABLE `commodity_recipes_resources(2)` (
  `commodity_recipes_req_resource3_id` integer,
  `resources_id` integer,
  PRIMARY KEY (`commodity_recipes_req_resource3_id`, `resources_id`)
);

ALTER TABLE `commodity_recipes_resources(2)` ADD FOREIGN KEY (`commodity_recipes_req_resource3_id`) REFERENCES `commodity_recipes` (`req_resource3_id`);

ALTER TABLE `commodity_recipes_resources(2)` ADD FOREIGN KEY (`resources_id`) REFERENCES `resources` (`id`);

