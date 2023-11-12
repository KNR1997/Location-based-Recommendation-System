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

// Place Categories
CREATE (beach:PlaceCategory{name:"Beach"});

// 32 beaches
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (unawatuna:Place{name:"Unawatuna"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (bentota:Place{name:"Bentota"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (mirissa:Place{name:"Mirissa"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (dickwella:Place{name:"Dickwella"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (weligama:Place{name:"Weligama"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (galle:Place{name:"Galle"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (induruwa:Place{name:"Induruwa"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (koggala:Place{name:"Koggala"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (negombo:Place{name:"Negombo"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (arugamBay:Place{name:"Arugam Bay"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (uppuveli:Place{name:"Uppuveli"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (trincomalee:Place{name:"Trincomalee"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (polhena:Place{name:"Polhena"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (mountLavinia:Place{name:"Mount Lavinia"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (kalpitiya:Place{name:"Kalpitiya"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (tangalle:Place{name:"Tangalle"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (pasakudahAndKalkudah:Place{name:"Pasakudah And Kalkudah"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (talallaSouth:Place{name:"Talalla South"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (matara:Place{name:"Matara"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (nilaveli:Place{name:"Nilaveli"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (muhathuwaram:Place{name:"Muhathuwaram"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (wijaya:Place{name:"Wijaya"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (pigeonIsland:Place{name:"Pigeon Island"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (rekawa:Place{name:"Rekawa"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (pottuvil:Place{name:"Pottuvil"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (casuarinaBeach:Place{name:"Casuarina Beach"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (kahandamodaraBeach:Place{name:"Kahandamodara Beach"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (beruwalaBeach:Place{name:"Beruwala Beach"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (batticaloaBeach:Place{name:"Batticaloa Beach"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (kalkudah:Place{name:"Kalkudah"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (hiriketiya:Place{name:"Hiriketiya"})-[:HAS_CATEGORY]->(beach);
MATCH (beach:PlaceCategory {name: "Beach"})
CREATE (hikkaduwa:Place{name:"Hikkaduwa"})-[:HAS_CATEGORY]->(beach);


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

MATCH (user:User)-[r:RELATIONSHIP_TYPE]->(product:Product)
  WHERE user.username = 'price'
DELETE r


MATCH (n:Label)
  WHERE n.property_name = {value}
DELETE n

MATCH (n:NodeLabel {name: 'old_name'})
SET n.name = 'new_name'
RETURN n

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
CREATE (Hiking:SubCategory {name: 'Hiking'});
CREATE (Camping:SubCategory {name: 'Camping'});
CREATE (Biking:SubCategory {name: 'Biking'});
CREATE (WildlifeWatching:SubCategory {name: 'Wildlife watching'});
CREATE (WaterSports :SubCategory {name: 'Water sports '});

CREATE (Museums:SubCategory {name: 'Museums'});
CREATE (HistoricalSites:SubCategory {name: 'Historical sites'});
CREATE (ArtGalleries:SubCategory {name: 'Art galleries'});
CREATE (ArchaeologicalSites:SubCategory {name: 'Archaeological sites'});
CREATE (CulturalFestivals:SubCategory {name: 'Cultural festivals'});

CREATE (LocalCuisine:SubCategory {name: 'Local cuisine'});
CREATE (StreetFood:SubCategory {name: 'Street food'});
CREATE (FineDining:SubCategory {name: 'Fine dining'});
CREATE (CookingClasses:SubCategory {name: 'Cooking classes'});
CREATE (FoodMarkets:SubCategory {name: 'Food markets'});

CREATE (ZipLining:SubCategory {name: 'Zip-lining'});
CREATE (Paragliding:SubCategory {name: 'Paragliding'});
CREATE (RockClimbing:SubCategory {name: 'Rock climbing'});
CREATE (BungeeJumping:SubCategory {name: 'Bungee jumping'});
CREATE (ExtremeSports:SubCategory {name: 'Extreme sports'});

CREATE (SpasAndWellnessCenters:SubCategory {name: 'Spas and wellness centers'});
CREATE (YogaAndMeditation:SubCategory {name: 'Yoga and meditation'});
CREATE (HotSprings:SubCategory {name: 'Hot springs'});
CREATE (BeachResorts:SubCategory {name: 'Beach resorts'});
CREATE (Retreats:SubCategory {name: 'Retreats'});

CREATE (AmusementParks:SubCategory {name: 'Amusement parks'});
CREATE (ZoosAndAquariums:SubCategory {name: 'Zoos and aquariums'});
CREATE (FamilyFriendlyMuseums:SubCategory {name: 'Family-friendly museums'});
CREATE (PicnicSpots:SubCategory {name: 'Picnic spots'});
CREATE (EducationalActivities:SubCategory {name: 'Educational activities'});

CREATE (Nightclubs:SubCategory {name: 'Nightclubs'});
CREATE (LiveMusicVenues:SubCategory {name: 'Live music venues'});
CREATE (TheatersAndShows:SubCategory {name: 'Theaters and shows'});
CREATE (ComedyClubs:SubCategory {name: 'Comedy clubs'});
CREATE (CasinoAndGambling:SubCategory {name: 'Casino and gambling'});

CREATE (FleaMarkets:SubCategory {name: 'Flea markets'});
CREATE (Boutiques:SubCategory {name: 'Boutiques'});
CREATE (AntiquesShops:SubCategory {name: 'Antiques shops'});
CREATE (SouvenirShops:SubCategory {name: 'Souvenir shops'});
CREATE (ShoppingDistricts:SubCategory {name: 'Shopping districts'});

CREATE (ScenicViewpoints:SubCategory {name: 'Scenic viewpoints'});
CREATE (Waterfalls:SubCategory {name: 'Waterfalls'});
CREATE (NationalParks:SubCategory {name: 'National parks'});
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

CREATE (ReligiousSitesAndTemples:SubCategory {name: 'Religious sites and temples'});
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









