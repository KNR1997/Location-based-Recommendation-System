CREATE
  (adventure:Interest{name:"Adventure"}),
  (hiking:Interest{name:"Hiking"}),
  (natureWildLife:Interest{name:"Nature & Wild Life"}),
  (camping:Interest{name:"Camping"}),
  (resort:Interest{name:"Resort"});
CREATE (beach:Interest{name:"Beach"});

CREATE
  (kandy:PopularPlaces{name:"Kandy"}),
  (galle:PopularPlaces{name:"Galle"}),
  (mirissa:PopularPlaces{name:"Mirissa"}),
  (ella:PopularPlaces{name:"Ella"}),
  (kitulgala:PopularPlaces{name:"Kitulgala"}),
  (anuradhapura:PopularPlaces{name:"Anuradhapura"}),
  (bentota:PopularPlaces{name:"Bentota"}),
  (dambulla:PopularPlaces{name:"Dambulla"}),
  (ohiya:PopularPlaces{name:"Ohiya"});

CREATE
  (ampara:District{name:"Ampara"}),
  (anuradhapura:District{name:"Anuradhapura"}),
  (badulla:District{name:"Badulla"}),
  (batticaloa:District{name:"Batticaloa"}),
  (colombo:District{name:"Colombo"}),
  (galle:District{name:"Galle"}),
  (gampaha:District{name:"Gampaha"}),
  (hambantota:District{name:"Hambantota"}),
  (jaffna:District{name:"Jaffna"}),
  (kalutara:District{name:"Kalutara"}),
  (kandy:District{name:"Kandy"}),
  (kegalle:District{name:"Kegalle"}),
  (kilinochchi:District{name:"Kilinochchi"}),
  (kurunegala:District{name:"Kurunegala"}),
  (mannar:District{name:"Mannar"}),
  (matale:District{name:"Matale"}),
  (matara:District{name:"Matara"}),
  (monaragala:District{name:"Monaragala"}),
  (mullaitivu:District{name:"Mullaitivu"}),
  (nuwaraEliya:District{name:"NuwaraEliya"}),
  (polonnaruwa:District{name:"Polonnaruwa"}),
  (puttalama:District{name:"Puttalama"}),
  (ratnapura:District{name:"Ratnapura"}),
  (trincomalee:District{name:"Trincomalee"}),
  (vavuniya:District{name:"Vavuniya"});

CREATE
  (:Province{name:"Central", capital:"Kandy"}),
  (:Province{name:"Eastern", capital:"Trincomalee"}),
  (:Province{name:"Northern", capital:"Jaffna"}),
  (:Province{name:"NorthCentral", capital:"Anuradhapura"}),
  (:Province{name:"NorthWestern", capital:"Kurunegala"}),
  (:Province{name:"Southern", capital:"Galle"}),
  (:Province{name:"Sabaragamuwa", capital:"Ratnapura"}),
  (:Province{name:"Uva", capital:"Badulla"}),
  (:Province{name:"Western", capital:"Colombo"});

//MATCH (central:Province {name: 'Central'})
//MATCH (district:District)
//  WHERE district.name IN ['NuwaraEliya', 'Kandy', 'Matale']
//FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d))

//MATCH (central:Province {name: 'Eastern'})
//MATCH (district:District)
//  WHERE district.name IN ['Ampara', 'Batticaloa', 'Trincomalee']
//FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d))

//MATCH (central:Province {name: 'Northern'})
//MATCH (district:District)
//  WHERE district.name IN ['Jaffna', 'Kilinochchi', 'Mannar', 'Mullaitivu', 'Vavuniya']
//FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d))

//MATCH (central:Province {name: 'NorthCentral'})
//MATCH (district:District)
//  WHERE district.name IN ['Anuradhapura', 'Polonnaruwa', 'Kurunegala', 'Puttalama']
//FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d))

//MATCH (central:Province {name: 'Southern'})
//MATCH (district:District)
//  WHERE district.name IN ['Galle', 'Hambantota', 'Matara']
//FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d))

//MATCH (central:Province {name: 'Sabaragamuwa'})
//MATCH (district:District)
//  WHERE district.name IN ['Kegalle', 'Ratnapura']
//FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d))

//MATCH (central:Province {name: 'Uva'})
//MATCH (district:District)
//  WHERE district.name IN ['Badulla', 'Monaragala']
//FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d))

//MATCH (central:Province {name: 'Western'})
//MATCH (district:District)
//  WHERE district.name IN ['Colombo', 'Gampaha', 'Kalutara']
//FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d))

//MATCH (central:Province {name: 'NorthWestern'})
//MATCH (district:District)
//  WHERE district.name IN ['Kurunegala', 'Puttalama']
//FOREACH (d IN [district] | CREATE (central)-[:HAS_DISTRICT]->(d))

// Place Categories
CREATE (beach:PlaceCategory{name:"Beach"});
CREATE (:PlaceCategory{name:"Mountain"});
CREATE (:PlaceCategory{name:"Rock"});
CREATE (:PlaceCategory{name:"RainForest"});
CREATE (:PlaceCategory{name:"Bridge"});
CREATE (:PlaceCategory{name:"Trail"});
CREATE (:PlaceCategory{name:"NationalPark"});
CREATE (:PlaceCategory{name:"Waterfall"});

// 32 beaches
//MATCH (beach:PlaceCategory {name: "Beach"})
//CREATE (:Place{name:"Unawatuna beach"})-[:HAS_CATEGORY]->(beach),
//  (:Place{name:"Bentota beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Mirissa beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Dickwella beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Weligama beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Galle beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Induruwa beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Koggala beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Negombo beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Arugam Bay beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Uppuveli beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Trincomalee beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Polhena beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Mount Lavinia beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Kalpitiya beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Tangalle beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Pasakudah And Kalkudah beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Talalla South beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Matara beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Nilaveli beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Muhathuwaram beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Wijaya beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Pigeon Island beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Rekawa beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Pottuvil beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Casuarina beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Kahandamodara beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Beruwala beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Batticaloa beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Kalkudah beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Hiriketiya beach"})-[:HAS_CATEGORY]->(beach),
// (:Place{name:"Hikkaduwa beach"})-[:HAS_CATEGORY]->(beach);

// Mountains & Rocks
MATCH (rock:PlaceCategory {name: "Rock"})
// sigirya added
CREATE (:Place{name:"Ella Rock Trail", difficulty: "Hard", length: 5.3, Est: 129})-[:HAS_CATEGORY]->(rock)
CREATE (:Place{name:"Pidurangala Rock", difficulty: "Moderate", length: 1.4, Est: 40})-[:HAS_CATEGORY]->(rock)
CREATE (:Place{name:"Katusu Konda", difficulty: "Hard"})-[:HAS_CATEGORY]->(rock)


MATCH (mountain:PlaceCategory {name: "Mountain"})
CREATE (:Place{name:"Ella to Ella Rock", difficulty: "Moderate", length: 10, Est: 190})-[:HAS_CATEGORY]->(mountain)
CREATE (:Place{name:"Little Adam's Peak", difficulty: "Moderate", length: 1.6, Est: 34})-[:HAS_CATEGORY]->(mountain)
CREATE (:Place{name:"Adam's Peak", difficulty: "Hard", length: 1.6, Est: 34})-[:HAS_CATEGORY]->(mountain)
CREATE (:Place{name:"World's End Trail", difficulty: "Moderate", length: 8.2, Est: 160})-[:HAS_CATEGORY]->(mountain)
CREATE (:Place{name:"Little Adam's Peak and Lookout", difficulty: "Moderate", length: 2.9, Est: 71})-[:HAS_CATEGORY]->(mountain)
CREATE (:Place{name:"Kirigalpotta", difficulty: "Moderate", length: 11.7})-[:HAS_CATEGORY]->(mountain)

MATCH (bridge:PlaceCategory {name: "Bridge"})
CREATE (:Place{name:"Nine Arch Bridge from Ella Rd", difficulty: "Moderate", length: 8.2, Est: 160})-[:HAS_CATEGORY]->(bridge)
CREATE (:Place{name:"Nine Arch Bridge", difficulty: "Moderate", length: 1.3, Est: 31})-[:HAS_CATEGORY]->(bridge)

MATCH (rainForest:PlaceCategory {name: "RainForest"})
CREATE (:Place{name:"Sinharaja World Heritage"})-[:HAS_CATEGORY]->(rainForest)
CREATE (:Place{name:"Peak Wilderness Sanctuary"})-[:HAS_CATEGORY]->(rainForest)
CREATE (:Place{name:"Kunckles"})-[:HAS_CATEGORY]->(rainForest)

MATCH (waterfall:PlaceCategory {name: "Waterfall"})
CREATE (:Place{name:"Baker Falls"})-[:HAS_CATEGORY]->(waterfall)
CREATE (:Place{name:"Bambarakanda Falls"})-[:HAS_CATEGORY]->(waterfall)
CREATE (:Place{name:"St. Clair’s Falls"})-[:HAS_CATEGORY]->(waterfall)
CREATE (:Place{name:"Ravana Falls"})-[:HAS_CATEGORY]->(waterfall)
CREATE (:Place{name:"Dunhinda Falls"})-[:HAS_CATEGORY]->(waterfall)
CREATE (:Place{name:"Gartmore Falls"})-[:HAS_CATEGORY]->(waterfall)
CREATE (:Place{name:"Devon Falls"})-[:HAS_CATEGORY]->(waterfall)
CREATE (:Place{name:"Diyaluma Falls"})-[:HAS_CATEGORY]->(waterfall)
CREATE (:Place{name:"Bomburu Falls"})-[:HAS_CATEGORY]->(waterfall)
CREATE (:Place{name:"Kirindi Ella Falls"})-[:HAS_CATEGORY]->(waterfall)

MATCH (nationalPark:PlaceCategory {name: "NationalPark"})
CREATE (:Place{name:"Yala National Park"})-[:HAS_CATEGORY]->(nationalPark)
//MATCH (trail:PlaceCategory {name: "Trail"})
//CREATE (:Place{name:"Nine Arch Bridge from Ella Rd")-[:HAS_CATEGORY]->(trail)
//CREATE (:Place{name:"Diyaluwa Falls", difficulty: "Moderate", length: 2.3, Est: 55})-[:HAS_CATEGORY]->(trail)


MATCH (Matale:District {name: 'Matale'})
MATCH (beach:Place)
  WHERE beach.name IN ['Sigiriya', 'Pidurangala Rock']
FOREACH (b IN [beach] | CREATE (b)-[:LOCATED_IN]->(Matale))

MATCH (Badulla:District {name: 'Badulla'})
MATCH (beach:Place)
  WHERE beach.name IN ['Ella Rock Trail', 'Ella to Ella Rock', 'Nine Arch Bridge', 'Bambarakanda Falls',
'Ravana Falls', 'Dunhinda Falls', 'Diyaluma Falls', 'Nine Arch Bridge from Ella Rd']
FOREACH (b IN [beach] | CREATE (b)-[:LOCATED_IN]->(Badulla))

MATCH (nuwaraEliya:District {name: 'NuwaraEliya'})
MATCH (beach:Place)
  WHERE beach.name IN ['Gartmore Falls', 'Devon Falls', 'Bomburu Falls', 'Kirigalpotta', 'Baker Falls ',
    "St. Clair’s Fall", "World's End Trail"]
FOREACH (b IN [beach] | CREATE (b)-[:LOCATED_IN]->(nuwaraEliya))

MATCH (ratnapura:District {name: 'Ratnapura'})
MATCH (beach:Place)
  WHERE beach.name IN ["Adam's Peak", "Sinharaja World Heritage", "Peak Wilderness Sanctuary", "Kirindi Ella Falls"]
FOREACH (b IN [beach] | CREATE (b)-[:LOCATED_IN]->(ratnapura))


// Beach Located In -> district
//MATCH (galle:District {name: 'Galle'})
//MATCH (beach:Place)
//  WHERE beach.name IN ['Unawatuna beach', 'Bentota beach', 'Galle beach', 'Koggala beach', 'Wijaya beach'
//  ,'Hikkaduwa beach']
//FOREACH (b IN [beach] | CREATE (b)-[:LOCATED_IN]->(galle))

//MATCH (matara:District {name: 'Matara'})
//MATCH (beach:Place)
//  WHERE beach.name IN ['Mirissa beach', 'Dickwella beach', 'Weligama beach', 'Talalla beach', 'Matara beach'
//  ,'Hiriketiya beach', 'Polhena beach']
//FOREACH (b IN [beach] | CREATE (b)-[:LOCATED_IN]->(matara))

//MATCH (ratnapura:District {name: 'Ratnapura'})
//MATCH (beach:Place)
//  WHERE beach.name IN ['Induruwa beach', 'Dickwella beach', 'Weligama beach', 'Talalla beach', 'Matara beach'
//  ,'Hiriketiya beach']
//FOREACH (b IN [beach] | CREATE (b)-[:LOCATED_IN]->(ratnapura))


CREATE (:District {name: 'Galle'})-[:HAS_BEACH]->(:Beach {name: 'Unawatuna'});
CREATE (:District {name: 'Galle'})-[:HAS_BEACH]->(:Beach {name: 'Bentota'});
CREATE (:District {name: 'Matara'})-[:HAS_BEACH]->(:Beach {name: 'Mirissa'});
CREATE (:District {name: 'Matara'})-[:HAS_BEACH]->(:Beach {name: 'Dickwella'});
CREATE (:District {name: 'Matara'})-[:HAS_BEACH]->(:Beach {name: 'Weligama'});
CREATE (:District {name: 'Galle'})-[:HAS_BEACH]->(:Beach {name: 'Galle'});
CREATE (:District {name: 'Galle'})-[:HAS_BEACH]->(:Beach {name: 'Induruwa'});
CREATE (:District {name: 'Galle'})-[:HAS_BEACH]->(:Beach {name: 'Hikkaduwa '});
CREATE (:District {name: 'Galle'})-[:HAS_BEACH]->(:Beach {name: 'Koggala'});
CREATE (:District {name: 'Gampaha'})-[:HAS_BEACH]->(:Beach {name: 'Negombo'});
CREATE (:District {name: 'Ampara'})-[:HAS_BEACH]->(:Beach {name: 'Arugam Bay'});
CREATE (:District {name: 'Trincomalee'})-[:HAS_BEACH]->(:Beach {name: 'Uppuveli'});
CREATE (:District {name: 'Trincomalee'})-[:HAS_BEACH]->(:Beach {name: 'Trincomalee'});
CREATE (:District {name: 'Matara'})-[:HAS_BEACH]->(:Beach {name: 'Polhena'});
CREATE (:District {name: 'Colombo'})-[:HAS_BEACH]->(:Beach {name: 'Mount Lavinia'});
CREATE (:District {name: 'Puttalama'})-[:HAS_BEACH]->(:Beach {name: 'Kalpitiya'});
CREATE (:District {name: 'Hambantota'})-[:HAS_BEACH]->(:Beach {name: 'Tangalle'});
CREATE (:District {name: 'Batticaloa'})-[:HAS_BEACH]->(:Beach {name: 'Pasakudah And Kalkudah'});
CREATE (:District {name: 'Matara'})-[:HAS_BEACH]->(:Beach {name: 'Talalla South'});
CREATE (:District {name: 'Matara'})-[:HAS_BEACH]->(:Beach {name: 'Matara'});
CREATE (:District {name: 'Trincomalee'})-[:HAS_BEACH]->(:Beach {name: 'Nilaveli'});
CREATE (:District {name: 'Batticaloa'})-[:HAS_BEACH]->(:Beach {name: 'Muhathuwaram'});
CREATE (:District {name: 'Galle'})-[:HAS_BEACH]->(:Beach {name: 'Wijaya'});
CREATE (:District {name: 'Trincomalee'})-[:HAS_BEACH]->(:Beach {name: 'Pigeon Island'});
CREATE (:District {name: 'Hambantota'})-[:HAS_BEACH]->(:Beach {name: 'Rekawa'});
CREATE (:District {name: 'Ampara'})-[:HAS_BEACH]->(:Beach {name: 'Pottuvil'});
CREATE (:District {name: 'Jaffna'})-[:HAS_BEACH]->(:Beach {name: 'Casuarina Beach'});
CREATE (:District {name: 'Hambantota'})-[:HAS_BEACH]->(:Beach {name: 'Kahandamodara Beach'});
CREATE (:District {name: 'Kalutara'})-[:HAS_BEACH]->(:Beach {name: 'Beruwala Beach'});
CREATE (:District {name: 'Batticaloa'})-[:HAS_BEACH]->(:Beach {name: 'Batticaloa Beach'});

CREATE (:District {name: 'Galle'})-[:HAS_BEACH]->(:Beach {name: 'Wijaya'});
CREATE (:District {name: 'Matara'})-[:HAS_BEACH]->(:Beach {name: 'Hiriketiya'});
CREATE (:District {name: 'Batticaloa'})-[:HAS_BEACH]->(:Beach {name: 'Kalkudah'});

// Overall rating
MATCH (n:Beach {name: 'Mirissa'})     SET n.rating = 7;
MATCH (n:Beach {name: 'Unawatuna'})   SET n.rating = 7;
MATCH (n:Beach {name: 'Weligama'})    SET n.rating = 7;
MATCH (n:Beach {name: 'Bentota'})     SET n.rating = 7;
MATCH (n:Beach {name: 'Arugam Bay'})  SET n.rating = 7;
MATCH (n:Beach {name: 'Nilaveli'})    SET n.rating = 7;
MATCH (n:Beach {name: 'Kalpitiya'})   SET n.rating = 7;

// Surfing rating
MATCH (n:Beach {name: 'Arugam Bay'})  SET n.surfing = 9;
MATCH (n:Beach {name: 'Hiriketiya'})  SET n.surfing = 9;
MATCH (n:Beach {name: 'Hikkaduwa'})   SET n.surfing = 9;

MATCH (n:Beach {name: 'Mirissa'})     SET n.surfing = 7;
MATCH (n:Beach {name: 'Koggala'})     SET n.surfing = 7;
MATCH (n:Beach {name: 'Weligama'})    SET n.surfing = 7;
MATCH (n:Beach {name: 'Unawatuna'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Wijaya'})      SET n.surfing = 0;
MATCH (n:Beach {name: 'Trincomalee'}) SET n.surfing = 0;
MATCH (n:Beach {name: 'Tangalle'})    SET n.surfing = 0;

MATCH (n:Beach {name: 'Unawatuna'})   SET n.surfing = 0;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Bentota'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Kalkudah'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Nilaveli'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Kalpitiya'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;

MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;

MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;
MATCH (n:Beach {name: 'Weligama'})   SET n.surfing = 5;

// Beach category nodes
CREATE
  (relaxation         :SubCategory{name: "Relaxation"}),
  (surfing            :SubCategory{name: "Surfing"}),
  (snorkeling         :SubCategory{name: "Snorkeling"}),
  (wildLife           :SubCategory{name: "WildLife"}),
  (party              :SubCategory{name: "Party"}),
  (historic           :SubCategory{name: "Historic"}),
  (deserted           :SubCategory{name: "Deserted"}),
  (underWaterParadise :SubCategory{name: "UnderWaterParadise"}),
  (islandParadise     :SubCategory{name: "IslandParadise"});

// Beach and Beach Category relationship
CREATE (:Beach {name: 'Wijaya'})-[:HAS_CATEGORY]->(:BeachCategory {name: 'Relaxation'});
CREATE (:Beach {name: 'Mirissa'})-[:HAS_CATEGORY]->(:BeachCategory {name: 'Surfing'});
CREATE (:Beach {name: 'Hiriketiya'})-[:HAS_CATEGORY]->(:BeachCategory {name: 'Surfing'});
CREATE (:Beach {name: 'Trincomalee'})-[:HAS_CATEGORY]->(:BeachCategory {name: 'Snorkeling'});
CREATE (:Beach {name: 'Tangalle'})-[:HAS_CATEGORY]->(:BeachCategory {name: 'Relaxation'});
CREATE (:Beach {name: 'Koggala'})-[:HAS_CATEGORY]->(:BeachCategory {name: 'Surfing'});
CREATE (:Beach {name: 'Koggala'})-[:HAS_CATEGORY]->(:BeachCategory {name: 'WildLife'});
CREATE (:Beach {name: 'Arugam Bay'})-[:HAS_CATEGORY]->(:BeachCategory {name: 'Surfing'});
CREATE (:Beach {name: 'Unawatuna'})-[:HAS_CATEGORY]->(:BeachCategory {name: 'Relaxation'});
CREATE (:Beach {name: 'Hikkaduwa'})-[:HAS_CATEGORY]->(:BeachCategory {name: 'Surfing'});
CREATE (:Beach {name: 'Hikkaduwa'})-[:HAS_CATEGORY]->(:BeachCategory {name: 'Snorkeling'});
CREATE (:Beach {name: 'Hikkaduwa'})-[:HAS_CATEGORY]->(:BeachCategory {name: 'WildLife'});

MATCH (b:Beach {name: 'Wijaya'})
MATCH (c:Beach {name: 'Tangalle'})
MATCH (s:BeachCategory {name: 'Relaxation'})
CREATE (s)-[:IS_A_SUB_OF]->(b)
CREATE (s)-[:IS_A_SUB_OF]->(c);

// Delete query
MATCH ()-[r:RELATIONSHIP_TYPE]->()
DELETE r

MATCH (userNode:User)-[r:RELATIONSHIP_TYPE]->(product:Product)
  WHERE userNode.username = 'price'
DELETE r


MATCH (n:Label)
  WHERE n.property_name = {value}
DELETE n

MATCH (n:NodeLabel {name: 'old_name'})
SET n.name = 'new_name'
RETURN n

MATCH (s:SubCategory {name: 'Hiking'})
SET s.status = 'Active'
RETURN s;


// subCategory
MATCH (a:SubCategory {name: 'Relaxation'})
MATCH (b:SubCategory {name: 'Surfing'})
MATCH (c:SubCategory {name: 'Snorkeling'})
MATCH (d:SubCategory {name: 'WildLife'})
MATCH (e:SubCategory {name: 'Party'})
MATCH (f:SubCategory {name: 'Historic'})
MATCH (g:SubCategory {name: 'Deserted'})
MATCH (h:SubCategory {name: 'UnderWaterParadise'})
MATCH (i:SubCategory {name: 'IslandParadise'})

CREATE (swimming:SubCategory {name: 'Swimming'});
CREATE (diving:SubCategory {name: 'Diving'});
CREATE (kiteSurfing:SubCategory {name: 'Kitesurfing'});
CREATE (windsurfing:SubCategory {name: 'Windsurfing'});
CREATE (jetSkis:SubCategory {name: 'JetSkis'});
CREATE (restaurant:SubCategory {name: 'Restaurant'});

CREATE (beach:PlaceCategory{name:"Beach"});

//Create subCategories
CREATE (Hiking:SubCategory {name: 'Hiking'});                       // Active
CREATE (Camping:SubCategory {name: 'Camping'});                     // Active
CREATE (Biking:SubCategory {name: 'Biking'});                       // Active
CREATE (WildlifeWatching:SubCategory {name: 'Wildlife watching'});  // Active
CREATE (WaterSports :SubCategory {name: 'Water sports '});          // Active

CREATE (Museums:SubCategory {name: 'Museums'});                     // Active
CREATE (HistoricalSites:SubCategory {name: 'Historical sites'});     // Active
CREATE (ArtGalleries:SubCategory {name: 'Art galleries'});            // Active
CREATE (ArchaeologicalSites:SubCategory {name: 'Archaeological sites'});
CREATE (CulturalFestivals:SubCategory {name: 'Cultural festivals'}); // Active

CREATE (LocalCuisine:SubCategory {name: 'Local cuisine'});
CREATE (StreetFood:SubCategory {name: 'Street food'});              // Active
CREATE (FineDining:SubCategory {name: 'Fine dining'});              // Active
CREATE (CookingClasses:SubCategory {name: 'Cooking classes'});
CREATE (FoodMarkets:SubCategory {name: 'Food markets'});

CREATE (ZipLining:SubCategory {name: 'Zip-lining'});                // Active
CREATE (Paragliding:SubCategory {name: 'Paragliding'});             // Active
CREATE (RockClimbing:SubCategory {name: 'Rock climbing'});          // Active
CREATE (BungeeJumping:SubCategory {name: 'Bungee jumping'});
CREATE (ExtremeSports:SubCategory {name: 'Extreme sports'});        // Active

CREATE (SpasAndWellnessCenters:SubCategory {name: 'Spas and wellness centers'}); // Active
CREATE (YogaAndMeditation:SubCategory {name: 'Yoga and meditation'}); // Active
CREATE (HotSprings:SubCategory {name: 'Hot springs'});                // Active
CREATE (BeachResorts:SubCategory {name: 'Beach resorts'});            // Active
CREATE (Retreats:SubCategory {name: 'Retreats'});

CREATE (AmusementParks:SubCategory {name: 'Amusement parks'});
CREATE (ZoosAndAquariums:SubCategory {name: 'Zoos and aquariums'});   // Active
CREATE (FamilyFriendlyMuseums:SubCategory {name: 'Family-friendly museums'});
CREATE (PicnicSpots:SubCategory {name: 'Picnic spots'});
CREATE (EducationalActivities:SubCategory {name: 'Educational activities'});

CREATE (Nightclubs:SubCategory {name: 'Nightclubs'});
CREATE (LiveMusicVenues:SubCategory {name: 'Live music venues'});
CREATE (TheatersAndShows:SubCategory {name: 'Theaters and shows'});
CREATE (ComedyClubs:SubCategory {name: 'Comedy clubs'});
CREATE (CasinoAndGambling:SubCategory {name: 'Casino and gambling'});

CREATE (FleaMarkets:SubCategory {name: 'Flea markets'});
CREATE (Boutiques:SubCategory {name: 'Boutiques'});               // Active
CREATE (AntiquesShops:SubCategory {name: 'Antiques shops'});
CREATE (SouvenirShops:SubCategory {name: 'Souvenir shops'});
CREATE (ShoppingDistricts:SubCategory {name: 'Shopping districts'});

CREATE (ScenicViewpoints:SubCategory {name: 'Scenic viewpoints'}); // Active
CREATE (Waterfalls:SubCategory {name: 'Waterfalls'});             // Active
CREATE (NationalParks:SubCategory {name: 'National parks'});      // Active
CREATE (SunriseSunsetSpots:SubCategory {name: 'Sunrise/sunset spots'});
CREATE (PhotographyTours:SubCategory {name: 'Photography tours'});

CREATE (CulturalCeremonies:SubCategory {name: 'Cultural ceremonies'});
CREATE (ReligiousFestivals:SubCategory {name: 'Religious festivals'});
CREATE (LocalTraditionsAndCustoms:SubCategory {name: 'Local traditions and customs'});
CREATE (SeasonalCelebrations:SubCategory {name: 'Seasonal celebrations'});
CREATE (CarnivalsAndParades:SubCategory {name: 'Carnivals and parades'});

CREATE (EcoFriendlyLodges:SubCategory {name: 'Eco-friendly lodges'});
CREATE (SustainableTours:SubCategory {name: 'Sustainable tours'});
CREATE (WildlifeConservation:SubCategory {name: 'Wildlife conservation'});
CREATE (OrganicFarms:SubCategory {name: 'Organic farms'});
CREATE (GreenInitiatives:SubCategory {name: 'Green initiatives'});

CREATE (SportsAndRecreation:SubCategory {name: 'Sports and Recreation'});
CREATE (GolfCourses:SubCategory {name: 'Golf courses'});
CREATE (TennisCourts:SubCategory {name: 'Tennis courts'});
CREATE (SkiResorts:SubCategory {name: 'Ski resortss'});
CREATE (SportsBarsAndVenues:SubCategory {name: 'Sports bars and venues'});

CREATE (ArtStudios:SubCategory {name: 'Art studios'});
CREATE (CraftWorkshops:SubCategory {name: 'Craft workshops'});
CREATE (ArtisanMarkets:SubCategory {name: 'Artisan markets'});
CREATE (StreetArtTours:SubCategory {name: 'Street art tours'});

CREATE (ReligiousSitesAndTemples:SubCategory {name: 'Religious sites and temples'}); // Active
CREATE (SpiritualRetreats:SubCategory {name: 'Spiritual retreats'});
CREATE (PilgrimageDestinations:SubCategory {name: 'Pilgrimage destinations'});
CREATE (MeditationCenters:SubCategory {name: 'Meditation centers'});
CREATE (SpiritualGuidance:SubCategory {name: 'Spiritual guidance'});

CREATE (AuthorsHomes:SubCategory {name: 'Authors homes'});
CREATE (LiteraryMuseums:SubCategory {name: 'Literary museums'});
CREATE (FamousBookstores:SubCategory {name: 'Famous bookstores'});
CREATE (HistoricLibraries:SubCategory {name: 'Historic libraries'});
CREATE (LiteraryWalkingTours:SubCategory {name: 'Literary walking tours'});

CREATE (EducationalTours:SubCategory {name: 'Educational tours'});
CREATE (WorkshopsAndClasses:SubCategory {name: 'Workshops and classes'});
CREATE (ScienceCenters:SubCategory {name: 'Science centers'});
CREATE (InteractiveMuseums:SubCategory {name: 'Interactive museums'});
CREATE (DIYAndCraftingWorkshops:SubCategory {name: 'DIY and crafting workshops'});

// Set subCategories Active/ Inactive
// Hiking, Camping, Biking, Wildlife watching, Water sports, Museums, Historical sites, Art galleries, Cultural festivals, Street food, Fine dining
// Zip-lining, Paragliding, Rock climbing, Extreme sports, SpasAndWellnessCenters, YogaAndMeditation, HotSprings, BeachResorts, ZoosAndAquariums
// Waterfalls, National parks, ReligiousSitesAndTemples
MATCH (s:SubCategory)
SET s.status = CASE
  WHEN s.name IN ['Hiking', 'Camping', 'Biking', 'Wildlife watching', 'Water sports', 'Museums', 'Historical sites', 'Art galleries', 'Cultural festivals', 'Street food',
  'Fine dining', 'Zip-lining', 'Paragliding', 'Rock climbing', 'Extreme sports', 'Spas and wellness centers', 'Yoga and meditation', 'Hot springs'
, 'Beach resorts', 'Zoos and aquariums', 'Waterfalls', 'National parks', 'Religious sites and temples', 'Scenic viewpoints' ] THEN 'Active'
  ELSE 'Inactive'
  END
RETURN s;









