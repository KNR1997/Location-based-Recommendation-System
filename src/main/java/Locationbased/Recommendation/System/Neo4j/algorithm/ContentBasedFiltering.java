package Locationbased.Recommendation.System.Neo4j.algorithm;

import Locationbased.Recommendation.System.Neo4j.models.node.*;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.PlaceQueryResult;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.ProvinceQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentBasedFiltering {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    public String[] contentBasedRecommendedPlaces(String[] likeSubCategories, String location) {
        List<String> placesNameList = new ArrayList<>();
        Province province;

        // get location details
        District district = districtRepository.findDistrictByname(location);
        ProvinceQueryResult provinceQueryResult = districtRepository.findProvince(location);
        province = new Province(provinceQueryResult);

        // get all places in the province



        // find places contain that likeSubCategories
        List<PlaceQueryResult> placeQueryResults = subCategoryRepository.findPlacesContainsSubCategory(likeSubCategories);
        for (PlaceQueryResult placeQueryResult : placeQueryResults) {
            placesNameList.add(placeQueryResult.getPlace().getName());
        }

        return placesNameList.toArray(new String[0]);
    }

}
