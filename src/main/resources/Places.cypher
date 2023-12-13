// 32 beaches
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE
  (:Place{name:"Wijaya beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Mirissa beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Unawatuna beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Weligama beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Bentota beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Arugam Bay beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Nilaveli beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Kalpitiya beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Koggala beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Negombo beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Hiriketiya beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Hikkaduwa beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Uppuveli beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Tangalle beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Trincomalee beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Pigeon Island beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Dickwella beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Rekawa beach"})-[:HAS_CATEGORY]->(beach),
  (:Place{name:"Batticaloa beach"})-[:HAS_CATEGORY]->(beach);

//       (:Place{name:"Galle beach"})-[:HAS_CATEGORY]->(beach),
//       (:Place{name:"Induruwa beach"})-[:HAS_CATEGORY]->(beach),
//       (:Place{name:"Polhena beach"})-[:HAS_CATEGORY]->(beach),
//       (:Place{name:"Mount Lavinia beach"})-[:HAS_CATEGORY]->(beach),
//       (:Place{name:"Pasakudah And Kalkudah beach"})-[:HAS_CATEGORY]->(beach),
//       (:Place{name:"Talalla South beach"})-[:HAS_CATEGORY]->(beach),
//       (:Place{name:"Matara beach"})-[:HAS_CATEGORY]->(beach),
//       (:Place{name:"Muhathuwaram beach"})-[:HAS_CATEGORY]->(beach),
//       (:Place{name:"Pottuvil beach"})-[:HAS_CATEGORY]->(beach),
//       (:Place{name:"Casuarina beach"})-[:HAS_CATEGORY]->(beach),
//       (:Place{name:"Kahandamodara beach"})-[:HAS_CATEGORY]->(beach),
//       (:Place{name:"Beruwala beach"})-[:HAS_CATEGORY]->(beach),
//       (:Place{name:"Kalkudah beach"})-[:HAS_CATEGORY]->(beach),

MATCH (waterfall:PlaceCategory {name: "Waterfall"})
CREATE
  (:Place{name:"Bambarakanda Waterfall"})-[:HAS_CATEGORY]->(waterfall),
  (:Place{name:"Baker Falls"})-[:HAS_CATEGORY]->(waterfall),
  (:Place{name:"St.Clair’s Falls"})-[:HAS_CATEGORY]->(waterfall),
  (:Place{name:"Ravana Falls"})-[:HAS_CATEGORY]->(waterfall),
  (:Place{name:"Dunhinda Falls"})-[:HAS_CATEGORY]->(waterfall),
  (:Place{name:"Gartmore Falls"})-[:HAS_CATEGORY]->(waterfall),
  (:Place{name:"Devon Falls"})-[:HAS_CATEGORY]->(waterfall),
  (:Place{name:"Diyaluma Falls"})-[:HAS_CATEGORY]->(waterfall),
  (:Place{name:"Bomburu Falls"})-[:HAS_CATEGORY]->(waterfall),
  (:Place{name:"Kirindi Ella"})-[:HAS_CATEGORY]->(waterfall);

MATCH (museum:PlaceCategory {name: "Museum"})
CREATE
  (:Place{name:"Colombo National Museum"})-[:HAS_CATEGORY]->(museum),
  (:Place{name:"Community Tsunami Museum"})-[:HAS_CATEGORY]->(museum),
  (:Place{name:"Ceylon Tea Museum"})-[:HAS_CATEGORY]->(museum),
  (:Place{name:"Martin Wickramasinghe Folk Museum Complex"})-[:HAS_CATEGORY]->(museum),
  (:Place{name:"Sigiriya Museum"})-[:HAS_CATEGORY]->(museum),
  (:Place{name:"Ariyapala Mask Museum"})-[:HAS_CATEGORY]->(museum),
  (:Place{name:"World Buddhist Museum"})-[:HAS_CATEGORY]->(museum),
  (:Place{name:"Raja Museum"})-[:HAS_CATEGORY]->(museum),
  (:Place{name:"Maritime Archeology Museum"})-[:HAS_CATEGORY]->(museum);

MATCH (place:Place)-[:HAS_CATEGORY]->(category:PlaceCategory {name: "Museum"})
Match (subCat:SubCategory {name:"Museums"})
FOREACH (b IN [place] | CREATE (b)-[:HAS_FEATURE]->(subCat));

MATCH (nationalPark:PlaceCategory {name: "NationalPark"})
CREATE
  (:Place{name:"Kumana National Park"})-[:HAS_CATEGORY]->(nationalPark),
  (:Place{name:"Yala National Park"})-[:HAS_CATEGORY]->(nationalPark),
  (:Place{name:"Minneriya National Park"})-[:HAS_CATEGORY]->(nationalPark),
  (:Place{name:"Udawalawe National Park"})-[:HAS_CATEGORY]->(nationalPark),
  (:Place{name:"Wilpattu National Park"})-[:HAS_CATEGORY]->(nationalPark);

MATCH (place:Place)-[:HAS_CATEGORY]->(category:PlaceCategory {name: "NationalPark"})
Match (subCat:SubCategory {name:"Wildlife Watching"})
FOREACH (b IN [place] | CREATE (b)-[:HAS_FEATURE]->(subCat));

MATCH (mountain:PlaceCategory {name: "Mountain"})
MATCH (rock:PlaceCategory {name: "Rock"})
CREATE
  (:Place{name:"Hike through the Knuckles Mountain Range"})-[:HAS_CATEGORY]->(mountain),
  (:Place{name:"Hike to the Stunning Pidurangala & Sigiriya"})-[:HAS_CATEGORY]->(rock),
  (:Place{name:"Ella Rock & Little Adam’s Peak"})-[:HAS_CATEGORY]->(rock),
  (:Place{name:"Trekking in the Sinharaja Forest"})-[:HAS_CATEGORY]->(mountain),
  (:Place{name:"The World’s End Cliff & Baker Falls"})-[:HAS_CATEGORY]->(mountain);

MATCH (place:Place)-[:HAS_CATEGORY]->(category:PlaceCategory {name: "Mountain"})
Match (subCat:SubCategory {name:"Hiking"})
FOREACH (b IN [place] | CREATE (b)-[:HAS_FEATURE]->(subCat));

MATCH (place:Place)-[:HAS_CATEGORY]->(category:PlaceCategory {name: "Rock"})
Match (subCat:SubCategory {name:"Hiking"})
FOREACH (b IN [place] | CREATE (b)-[:HAS_FEATURE]->(subCat));

///////////////////////////////////////////////////////////////////////////////////////////////////////


MATCH (rock:PlaceCategory {name: "Rock"})
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



MATCH (nationalPark:PlaceCategory {name: "NationalPark"})
CREATE (:Place{name:"Yala National Park"})-[:HAS_CATEGORY]->(nationalPark)
//MATCH (trail:PlaceCategory {name: "Trail"})
//CREATE (:Place{name:"Nine Arch Bridge from Ella Rd")-[:HAS_CATEGORY]->(trail)
//CREATE (:Place{name:"Diyaluwa Falls", difficulty: "Moderate", length: 2.3, Est: 55})-[:HAS_CATEGORY]->(trail)