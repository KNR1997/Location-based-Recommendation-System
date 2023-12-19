package Locationbased.Recommendation.System.Neo4j.algorithm;

import Locationbased.Recommendation.System.Neo4j.models.node.District;
import Locationbased.Recommendation.System.Neo4j.models.node.Place;
import Locationbased.Recommendation.System.Neo4j.models.node.Province;
import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.PlaceQueryResult;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.ProvinceQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.DistrictRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.ProvinceRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

        // Assuming you have a list of subcategory IDs
        List<Long> subCategoryIds = Arrays.asList(196L, 199L, 48L); // Replace with your actual IDs

        // get subCategories list by IDs
        List<SubCategory> subCategoryList = subCategoryRepository.findAllById(subCategoryIds);

        // get location details
        District district = districtRepository.findDistrictByname(location);
        ProvinceQueryResult provinceQueryResult = districtRepository.findProvince(district.getName());
        province = new Province(provinceQueryResult);

        // get all places in the province
        List<PlaceQueryResult> placeQueryResultList = provinceRepository.getAllPlacesInProvince(province.getName());

        // find places contain that likeSubCategories
        if (placeQueryResultList != null) {
            for (PlaceQueryResult placeQueryResult : placeQueryResultList) {
                Place place = placeQueryResult.getPlace();

                // Retain only the subCategories that exist in both place.getSubCategories() and subCategoryList
                List<SubCategory> commonSubCategories = new ArrayList<>(place.getSubCategories());
                commonSubCategories.retainAll(subCategoryList);

                // Check if commonSubCategories is not empty
                if (!commonSubCategories.isEmpty()) {
                    placesNameList.add(place.getName());
                } else {
                    System.out.println("Empty");
                }
            }
        } else {
            System.out.println("Something wrong");
        }


        return placesNameList.toArray(new String[0]);
    }

}
