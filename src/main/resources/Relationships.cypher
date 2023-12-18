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

// Place -> District
//MATCH (district:District {name: 'Matale'})
//MATCH (place:Place)
//  WHERE place.name IN ['Hike to the Stunning Pidurangala & Sigiriya', 'Hike through the Knuckles Mountain Range']
//FOREACH (b IN [place] | CREATE (b)-[:LOCATED_IN]->(district));
//
//MATCH (district:District {name: 'Kandy'})
//MATCH (place:Place)
//  WHERE place.name IN ['Hike through the Knuckles Mountain Range']
//FOREACH (b IN [place] | CREATE (b)-[:LOCATED_IN]->(district));
//
//MATCH (district:District {name: 'Badulla'})
//MATCH (place:Place)
//  WHERE place.name IN ['Hike through the Knuckles Mountain Range']
//FOREACH (b IN [place] | CREATE (b)-[:LOCATED_IN]->(district));
//
//MATCH (district:District {name: 'Ratnapura'})
//MATCH (place:Place)
//  WHERE place.name IN ['Hike through the Knuckles Mountain Range']
//FOREACH (b IN [place] | CREATE (b)-[:LOCATED_IN]->(district));
//
//MATCH (district:District {name: 'NuwaraEliya'})
//MATCH (place:Place)
//  WHERE place.name IN ['Hike through the Knuckles Mountain Range']
//FOREACH (b IN [place] | CREATE (b)-[:LOCATED_IN]->(district));


MATCH (district:District {name: 'Ampara'})
MATCH (place:Place)
  WHERE place.name IN ['Kumana National Park']
FOREACH (b IN [place] | CREATE (district)-[:HAS_PLACE]->(b));

MATCH (district:District {name: 'Hambantota'})
MATCH (place:Place)
  WHERE place.name IN ['Yala National Park']
FOREACH (b IN [place] | CREATE (district)-[:HAS_PLACE]->(b));

MATCH (district:District {name: 'Polonnaruwa'})
MATCH (place:Place)
  WHERE place.name IN ['Minneriya National Park']
FOREACH (b IN [place] | CREATE (district)-[:HAS_PLACE]->(b));

MATCH (district:District {name: 'Ratnapura'})
MATCH (place:Place)
  WHERE place.name IN ['Udawalawe National Park']
FOREACH (b IN [place] | CREATE (district)-[:HAS_PLACE]->(b));

MATCH (district:District {name: 'Puttalama'})
MATCH (place:Place)
  WHERE place.name IN ['Wilpattu National Park']
FOREACH (b IN [place] | CREATE (district)-[:HAS_PLACE]->(b));



MATCH (district:District {name: 'Galle'})
MATCH (beach:Place)
  WHERE beach.name IN ['Unawatuna beach', 'Bentota beach', 'Koggala beach', 'Wijaya beach','Hikkaduwa beach']
FOREACH (b IN [beach] | CREATE (district)-[:HAS_PLACE]->(b));

MATCH (district:District {name: 'Matara'})
MATCH (beach:Place)
  WHERE beach.name IN ['Mirissa beach', 'Dickwella beach', 'Weligama beach','Hiriketiya beach']
FOREACH (b IN [beach] | CREATE (district)-[:HAS_PLACE]->(b));

MATCH (district:District {name: 'Trincomalee'})
MATCH (beach:Place)
  WHERE beach.name IN ['Nilaveli beach', 'Uppuveli beach', 'Trincomalee beach', 'Pigeon Island beach']
FOREACH (b IN [beach] | CREATE (district)-[:HAS_PLACE]->(b));

MATCH (district:District {name: 'Hambantota'})
MATCH (beach:Place)
  WHERE beach.name IN ['Tangalle beach', 'Rekawa beach']
FOREACH (b IN [beach] | CREATE (district)-[:HAS_PLACE]->(b));

MATCH (district:District {name: 'Ampara'})
MATCH (beach:Place)
  WHERE beach.name IN ['Arugam Bay beach']
FOREACH (b IN [beach] | CREATE (district)-[:HAS_PLACE]->(b));

MATCH (district:District {name: 'Puttalama'})
MATCH (beach:Place)
  WHERE beach.name IN ['Kalpitiya beach']
FOREACH (b IN [beach] | CREATE (district)-[:HAS_PLACE]->(b));

MATCH (district:District {name: 'Gampaha'})
MATCH (beach:Place)
  WHERE beach.name IN ['Negombo beach']
FOREACH (b IN [beach] | CREATE (district)-[:HAS_PLACE]->(b));

MATCH (district:District {name: 'Batticaloa'})
MATCH (beach:Place)
  WHERE beach.name IN ['Batticaloa beach']
FOREACH (b IN [beach] | CREATE (district)-[:HAS_PLACE]->(b));



MATCH (subCategory:SubCategory {name: 'Museums'})
MATCH (place:Place)
  WHERE place.name IN ['Colombo National Museum', 'Community Tsunami Museum',
    'Ceylon Tea Museum', 'Martin Wickramasinghe Folk Museum Complex', 'Sigiriya Museum', 'Ariyapala Mask Museum', 'World Buddhist Museum', 'Raja Museum', 'Maritime Archeology Museum']
FOREACH (b IN [place] | CREATE (b)-[:HAS_SUBCATEGORY]->(subCategory));

MATCH (district:District {name: 'Colombo'})
MATCH (place:Place)
  WHERE place.name IN ['Colombo National Museum']
FOREACH (b IN [place] | CREATE (b)-[:LOCATED_IN]->(district));

MATCH (district:District {name: 'Galle'})
MATCH (place:Place)
  WHERE place.name IN ['Community Tsunami Museum', 'Martin Wickramasinghe Folk Museum Complex',
    'Maritime Archeology Museum', 'Ariyapala Mask Museum']
FOREACH (b IN [place] | CREATE (b)-[:LOCATED_IN]->(district));

MATCH (district:District {name: 'Kandy'})
MATCH (place:Place)
  WHERE place.name IN ['Ceylon Tea Museum', 'World Buddhist Museum', 'Raja Museum']
FOREACH (b IN [place] | CREATE (b)-[:LOCATED_IN]->(district));

MATCH (district:District {name: 'Matale'})
MATCH (place:Place)
  WHERE place.name IN ['Sigiriya Museum']
FOREACH (b IN [place] | CREATE (b)-[:LOCATED_IN]->(district));