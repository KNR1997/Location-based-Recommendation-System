// Province
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

// District
CREATE
  (:District{name:"Ampara"}),
  (:District{name:"Anuradhapura"}),
  (:District{name:"Badulla"}),
  (:District{name:"Batticaloa"}),
  (:District{name:"Colombo"}),
  (:District{name:"Galle"}),
  (:District{name:"Gampaha"}),
  (:District{name:"Hambantota"}),
  (:District{name:"Jaffna"}),
  (:District{name:"Kalutara"}),
  (:District{name:"Kandy"}),
  (:District{name:"Kegalle"}),
  (:District{name:"Kilinochchi"}),
  (:District{name:"Kurunegala"}),
  (:District{name:"Mannar"}),
  (:District{name:"Matale"}),
  (:District{name:"Matara"}),
  (:District{name:"Monaragala"}),
  (:District{name:"Mullaitivu"}),
  (:District{name:"NuwaraEliya"}),
  (:District{name:"Polonnaruwa"}),
  (:District{name:"Puttalama"}),
  (:District{name:"Ratnapura"}),
  (:District{name:"Trincomalee"}),
  (:District{name:"Vavuniya"});

// Place Category
CREATE
  (:PlaceCategory{name:"Beach"}),
  (:PlaceCategory{name:"Mountain"}),
  (:PlaceCategory{name:"Rock"}),
  (:PlaceCategory{name:"RainForest"}),
  (:PlaceCategory{name:"Bridge"}),
  (:PlaceCategory{name:"Trail"}),
  (:PlaceCategory{name:"NationalPark"}),
  (:PlaceCategory{name:"Waterfall"});

CREATE (:PlaceCategory{name:"Museum"});
// SubCategory
CREATE
  (:SubCategory {name: 'Hiking', status: 'Active'}),
  (:SubCategory {name: 'Camping', status: 'Active'}),
  (:SubCategory {name: 'Biking', status: 'Active'}),
  (:SubCategory {name: 'Wildlife Watching', status: 'Active'}),
  (:SubCategory {name: 'Water Sports', status: 'Active'}),

  (:SubCategory {name: 'Museums', status: 'Active'}),
  (:SubCategory {name: 'Historical Sites', status: 'Active'}),
  (:SubCategory {name: 'Art Galleries', status: 'Active'}),
  (:SubCategory {name: 'Archaeological Sites', status: 'Active'}),
  (:SubCategory {name: 'Cultural Festivals', status: 'Active'}),

  (:SubCategory {name: 'Street Food', status: 'Active'}),
  (:SubCategory {name: 'Fine Dining', status: 'Active'}),
  (:SubCategory {name: 'Zip-lining', status: 'Active'}),
  (:SubCategory {name: 'Paragliding', status: 'Active'}),
  (:SubCategory {name: 'Rock Climbing', status: 'Active'}),

  (:SubCategory {name: 'Extreme Sports', status: 'Active'}),
  (:SubCategory {name: 'Spas & Wellness centers', status: 'Active'}),
  (:SubCategory {name: 'Yoga & meditation', status: 'Active'}),
  (:SubCategory {name: 'Hot Springs', status: 'Active'}),
  (:SubCategory {name: 'Beach Resorts', status: 'Active'}),

  (:SubCategory {name: 'Zoos & Aquariums', status: 'Active'}),
  (:SubCategory {name: 'Boutiques', status: 'Active'}),
  (:SubCategory {name: 'Scenic Viewpoints', status: 'Active'}),
  (:SubCategory {name: 'Waterfalls', status: 'Active'}),
  (:SubCategory {name: 'National Parks', status: 'Active'}),

  (:SubCategory {name: 'Religious Sites & temples', status: 'Active'}),
  (:SubCategory {name: 'Relaxation', status: 'Active'});

CREATE (:SubCategory {name: 'Souvenir shops', status: 'Active'})
CREATE (:SubCategory {name: 'Shopping districts', status: 'Active'})

//  (:SubCategory {name: 'Local Cuisine'})
//  (:SubCategory {name: 'Cooking classes'})
//  (:SubCategory {name: 'Food markets'})
//  (:SubCategory {name: 'Bungee jumping'})
//  (:SubCategory {name: 'Retreats'})
//
// (:SubCategory {name: 'Amusement parks'})
// (:SubCategory {name: 'Family-friendly museums'})
// (:SubCategory {name: 'Picnic spots'})
// (:SubCategory {name: 'Educational activities'})
//
// (:SubCategory {name: 'Nightclubs'})
// (:SubCategory {name: 'Live music venues'})
// (:SubCategory {name: 'Theaters and shows'})
// (:SubCategory {name: 'Comedy clubs'})
// (:SubCategory {name: 'Casino and gambling'})
//
// (:SubCategory {name: 'Flea markets'})
// (:SubCategory {name: 'Antiques shops'})
 (:SubCategory {name: 'Souvenir shops'})
 (:SubCategory {name: 'Shopping districts'})
//
// (:SubCategory {name: 'Sunrise/sunset spots'})
// (:SubCategory {name: 'Photography tours'})
//
// (:SubCategory {name: 'Cultural ceremonies'})
// (:SubCategory {name: 'Religious festivals'})
// (:SubCategory {name: 'Local traditions and customs'})
// (:SubCategory {name: 'Seasonal celebrations'})
// (:SubCategory {name: 'Carnivals and parades'})
//
// (:SubCategory {name: 'Eco-friendly lodges'})
// (:SubCategory {name: 'Sustainable tours'})
// (:SubCategory {name: 'Wildlife conservation'})
// (:SubCategory {name: 'Organic farms'})
// (:SubCategory {name: 'Green initiatives'})
//
// (:SubCategory {name: 'Sports and Recreation'})
// (:SubCategory {name: 'Golf courses'})
// (:SubCategory {name: 'Tennis courts'})
// (:SubCategory {name: 'Ski resorts'})
// (:SubCategory {name: 'Sports bars and venues'})
//
// (:SubCategory {name: 'Art studios'})
// (:SubCategory {name: 'Craft workshops'})
// (:SubCategory {name: 'Artisan markets'})
// (:SubCategory {name: 'Street art tours'})
//
// (:SubCategory {name: 'Spiritual retreats'})
// (:SubCategory {name: 'Pilgrimage destinations'})
// (:SubCategory {name: 'Meditation centers'})
// (:SubCategory {name: 'Spiritual guidance'})
//
// (:SubCategory {name: 'Authors homes'})
// (:SubCategory {name: 'Literary museums'})
// (:SubCategory {name: 'Famous bookstores'})
// (:SubCategory {name: 'Historic libraries'})
// (:SubCategory {name: 'Literary walking tours'})
//
// (:SubCategory {name: 'Educational tours'})
// (:SubCategory {name: 'Workshops and classes'})
// (:SubCategory {name: 'Science centers'})
// (:SubCategory {name: 'Interactive museums'})
// (:SubCategory {name: 'DIY and crafting workshops'})

