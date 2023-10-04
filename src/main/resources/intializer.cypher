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
  (central:Province{name:"Central", capital:"Kandy"}),
  (eastern:Province{name:"Eastern", capital:"Trincomalee"}),
  (northCentral:Province{name:"North Central", capital:"Anuradhapura"}),
  (northern:Province{name:"Northern", capital:"Jaffna"}),
  (northWestern:Province{name:"North Western", capital:"Kurunegala"}),
  (sabaragamuwa:Province{name:"Sabaragamuwa", capital:"Ratnapura"}),
  (southern:Province{name:"Southern", capital:"Galle"}),
  (uva:Province{name:"Uva", capital:"Badulla"}),
  (western:Province{name:"Western", capital:"Colombo"});

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

CREATE (:District {name: 'Ampara'})-[:BELONGS_TO]->(:Province {name: 'Eastern'});
CREATE (:District {name: 'Anuradhapura'})-[:BELONGS_TO]->(:Province {name: 'North Central'});
CREATE (:District {name: 'Badulla'})-[:BELONGS_TO]->(:Province {name: 'Uva'});
CREATE (:District {name: 'Batticaloa'})-[:BELONGS_TO]->(:Province {name: 'Eastern'});
CREATE (:District {name: 'Colombo'})-[:BELONGS_TO]->(:Province {name: 'Western'});
CREATE (:District {name: 'Galle'})-[:BELONGS_TO]->(:Province {name: 'Southern'});
CREATE (:District {name: 'Gampaha'})-[:BELONGS_TO]->(:Province {name: 'Western'});
CREATE (:District {name: 'Hambantota'})-[:BELONGS_TO]->(:Province {name: 'Southern'});
CREATE (:District {name: 'Jaffna'})-[:BELONGS_TO]->(:Province {name: 'Northern'});
CREATE (:District {name: 'Kalutara'})-[:BELONGS_TO]->(:Province {name: 'Western'});
CREATE (:District {name: 'Kandy'})-[:BELONGS_TO]->(:Province {name: 'Central'});
CREATE (:District {name: 'Kegalle'})-[:BELONGS_TO]->(:Province {name: 'Sabaragamuwa'});
CREATE (:District {name: 'Kilinochchi'})-[:BELONGS_TO]->(:Province {name: 'Northern'});
CREATE (:District {name: 'Kurunegala'})-[:BELONGS_TO]->(:Province {name: 'North Western'});
CREATE (:District {name: 'Mannar'})-[:BELONGS_TO]->(:Province {name: 'Northern'});
CREATE (:District {name: 'Matale'})-[:BELONGS_TO]->(:Province {name: 'Central'});
CREATE (:District {name: 'Matara'})-[:BELONGS_TO]->(:Province {name: 'Southern'});
CREATE (:District {name: 'Monaragala'})-[:BELONGS_TO]->(:Province {name: 'Uva'});
CREATE (:District {name: 'Mullaitivu'})-[:BELONGS_TO]->(:Province {name: 'Northern'});
CREATE (:District {name: 'NuwaraEliya'})-[:BELONGS_TO]->(:Province {name: 'Central'});
CREATE (:District {name: 'Polonnaruwa'})-[:BELONGS_TO]->(:Province {name: 'North Central'});
CREATE (:District {name: 'Puttalama'})-[:BELONGS_TO]->(:Province {name: 'North Western'});
CREATE (:District {name: 'Ratnapura'})-[:BELONGS_TO]->(:Province {name: 'Sabaragamuwa'});
CREATE (:District {name: 'Trincomalee'})-[:BELONGS_TO]->(:Province {name: 'Eastern'});
CREATE (:District {name: 'Vavuniya'})-[:BELONGS_TO]->(:Province {name: 'Northern'});

CREATE
  (unawatuna:Beach{name:"Unawatuna"}),
  (bentota:Beach{name:"Bentota"}),
  (mirissa:Beach{name:"Mirissa"}),
  (dickwella:Beach{name:"Dickwella"}),
  (weligama:Beach{name:"Weligama"}),
  (galle:Beach{name:"Galle"}),
  (induruwa:Beach{name:"Induruwa"}),
  (koggala:Beach{name:"Koggala"}),
  (negombo:Beach{name:"Negombo"}),
  (arugamBay:Beach{name:"Arugam Bay"}),
  (uppuveli:Beach{name:"Uppuveli"}),
  (trincomalee:Beach{name:"Trincomalee"}),
  (polhena:Beach{name:"Polhena"}),
  (mountLavinia:Beach{name:"Mount Lavinia"}),
  (kalpitiya:Beach{name:"Kalpitiya"}),
  (tangalle:Beach{name:"Tangalle"}),
  (pasakudahAndKalkudah:Beach{name:"Pasakudah And Kalkudah"}),
  (talallaSouth:Beach{name:"Talalla South"}),
  (matara:Beach{name:"Matara"}),
  (nilaveli:Beach{name:"Nilaveli"}),
  (muhathuwaram:Beach{name:"Muhathuwaram"}),
  (wijaya:Beach{name:"Wijaya"}),
  (pigeonIsland:Beach{name:"Pigeon Island"}),
  (rekawa:Beach{name:"Rekawa"}),
  (pottuvil:Beach{name:"Pottuvil"}),
  (casuarinaBeach:Beach{name:"Casuarina Beach"}),
  (kahandamodaraBeach:Beach{name:"Kahandamodara Beach"}),
  (beruwalaBeach:Beach{name:"Beruwala Beach"}),
  (batticaloaBeach:Beach{name:"Batticaloa Beach"}),
  (wijaya:Beach{name:"Wijaya"}),
  (kalkudah:Beach{name:"Kalkudah", rating:7}),
  (hiriketiya:Beach{name:"Hiriketiya", rating:5}),
  (hikkaduwa:Beach{name:"Hikkaduwa", rating:5});


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
  (relaxation         :BeachCategory{name: "Relaxation"         }),
  (surfing            :BeachCategory{name: "Surfing"            }),
  (snorkeling         :BeachCategory{name: "Snorkeling"         }),
  (wildLife           :BeachCategory{name: "WildLife"           }),
  (party              :BeachCategory{name: "Party"              }),
  (historic           :BeachCategory{name: "Historic"           }),
  (deserted           :BeachCategory{name: "Deserted"           }),
  (underWaterParadise :BeachCategory{name: "UnderWaterParadise" }),
  (islandParadise     :BeachCategory{name: "IslandParadise"     });

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












