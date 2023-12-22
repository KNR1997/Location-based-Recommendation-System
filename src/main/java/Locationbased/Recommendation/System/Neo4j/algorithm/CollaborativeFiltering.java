package Locationbased.Recommendation.System.Neo4j.algorithm;

import Locationbased.Recommendation.System.Neo4j.models.node.District;
import Locationbased.Recommendation.System.Neo4j.models.node.Province;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.PlaceQueryResult;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.ProvinceQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.DistrictRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollaborativeFiltering {
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    public String[] collaborativeFilteringRecommendedPlaces(String location) {
        Province province;
        List<String> placesNameList = new ArrayList<>();

        // get location details
        District district = districtRepository.findDistrictByname(location);
        ProvinceQueryResult provinceQueryResult = districtRepository.findProvince(district.getName());
        province = new Province(provinceQueryResult);

        // find province visitors
        List<PlaceQueryResult> placeQueryResultList = provinceRepository.getAllRatedPlacesInProvince(province.getName());
        for (PlaceQueryResult placeQueryResult : placeQueryResultList) {
            placesNameList.add(placeQueryResult.getPlace().getName());
        }
        return placesNameList.toArray(new String[0]);
    }

}
