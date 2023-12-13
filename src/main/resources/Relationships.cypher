// Province -> District
MATCH (central:Province {name: 'Central'})
MATCH (district:District)
  WHERE district.name IN ['NuwaraEliya', 'Kandy', 'Matale']
FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d));

MATCH (central:Province {name: 'Eastern'})
MATCH (district:District)
  WHERE district.name IN ['Ampara', 'Batticaloa', 'Trincomalee']
FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d));

MATCH (central:Province {name: 'Northern'})
MATCH (district:District)
  WHERE district.name IN ['Jaffna', 'Kilinochchi', 'Mannar', 'Mullaitivu', 'Vavuniya']
FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d));

MATCH (central:Province {name: 'NorthCentral'})
MATCH (district:District)
  WHERE district.name IN ['Anuradhapura', 'Polonnaruwa']
FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d));

MATCH (central:Province {name: 'Southern'})
MATCH (district:District)
  WHERE district.name IN ['Galle', 'Hambantota', 'Matara']
FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d));

MATCH (central:Province {name: 'Sabaragamuwa'})
MATCH (district:District)
  WHERE district.name IN ['Kegalle', 'Ratnapura']
FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d));

MATCH (central:Province {name: 'Uva'})
MATCH (district:District)
  WHERE district.name IN ['Badulla', 'Monaragala']
FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d));

MATCH (central:Province {name: 'Western'})
MATCH (district:District)
  WHERE district.name IN ['Colombo', 'Gampaha', 'Kalutara']
FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d));

MATCH (central:Province {name: 'NorthWestern'})
MATCH (district:District)
  WHERE district.name IN ['Kurunegala', 'Puttalama']
FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


